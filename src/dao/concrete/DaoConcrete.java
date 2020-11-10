package dao.concrete;

import dao.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Livro;
import model.Autor;
import model.Editora;
import java.util.ArrayList;

public class DaoConcrete implements Dao{
    Connection con = null;
    PreparedStatement ps = null, check_db = null;
    ResultSet rs = null;
    String query = null;
    
    @Override
    public ArrayList<Livro> buscaLivros(String key, String tipo) {
    ArrayList<Livro> livros = new ArrayList<>();
    try{
      con = ConexaoFabrica.getConexao();
      query = "SELECT ba.isbn, title, price, a.name AS aname, fname, p.name AS pname, url FROM Books b "
                    + "INNER JOIN BooksAuthors ba ON b.isbn=ba.isbn "
                    + "INNER JOIN Authors a ON ba.author_id=a.author_id "
                    + "INNER JOIN Publishers p ON b.publisher_id=p.publisher_id ";
      if(tipo.equals("Titulo")) query = query + "WHERE LOWER(title) LIKE LOWER(?) ORDER BY title";
      if(tipo.equals("Autor")) query = query + "WHERE LOWER(fname) LIKE LOWER(?) ORDER BY fname";
      if(tipo.equals("Editora")) query = query + "WHERE LOWER(p.name) LIKE LOWER(?) ORDER BY p.name";
      ps = con.prepareStatement(query);
      ps.setString(1, "%"+key+"%");
      rs = ps.executeQuery();
      while(rs.next()){
        Livro livro = new Livro(rs.getString("isbn"), 
                                rs.getString("title"), 
                                rs.getDouble("price")
        );
        livro.addAutor(new Autor(rs.getString("fname"), rs.getString("aname")));
        livro.setEditora(new Editora(rs.getString("pname"), rs.getString("url")));
        livros.add(livro);
      }
      //ConexaoFabrica.closeConn(con, ps);
      return livros;
    }catch(Exception e){
      e.printStackTrace();
    }
    return null;
  }   
    
    @Override
    public ArrayList<Autor> buscaAutores(String key) {
    ArrayList<Autor> autores = new ArrayList<>();
    try{
      con = ConexaoFabrica.getConexao();
      query = "SELECT * FROM Authors "
                    + "WHERE LOWER(fname) LIKE LOWER(?) ORDER BY fname";
      ps = con.prepareStatement(query);
      ps.setString(1, "%"+key+"%");
      rs = ps.executeQuery();
      while(rs.next()){

        Autor autor = new Autor(rs.getString("fname"), 
                                rs.getString("name"),
                                rs.getInt("author_id")
        );
          
        autores.add(autor);
      }
      //ConexaoFabrica.closeConn(con, ps);
      return autores;
    }catch(Exception e){
      e.printStackTrace();
    }
    return null;
  }
    
    @Override
    public ArrayList<Editora> buscaEditoras(String key) {
    ArrayList<Editora> editoras = new ArrayList<>();
    try{
      con = ConexaoFabrica.getConexao();
      query = "SELECT * FROM Publishers "
                    + "WHERE LOWER(name) LIKE LOWER(?) ORDER BY name";
      ps = con.prepareStatement(query);
      ps.setString(1, "%"+key+"%");
      rs = ps.executeQuery();
      while(rs.next()){
        Editora editora = new Editora(rs.getString("name"), 
                                    rs.getString("url"),
                                    rs.getInt("publisher_id")
        );
        editoras.add(editora);
      }
      //ConexaoFabrica.closeConn(con, ps);
      return editoras;
    }catch(Exception e){
      e.printStackTrace();
    }
    return null;
  }
    
    @Override
    public ArrayList<Autor> populaAutorCombo(){
        ArrayList<Autor> autores = new ArrayList<>();
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT DISTINCT * FROM Authors ORDER BY fname";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
              Autor autor = new Autor(rs.getString("fname"), 
                                      rs.getString("name"),
                                      rs.getInt("author_id")
              );

              autores.add(autor);
            }
            //ConexaoFabrica.closeConn(con, ps);
            return autores;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public ArrayList<Editora> populaEditoraCombo(){
        ArrayList<Editora> editoras = new ArrayList<>();
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT DISTINCT * FROM Publishers ORDER BY name";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
              Editora editora = new Editora(rs.getString("name"), 
                                      rs.getString("url"),
                                      rs.getInt("publisher_id")
              );

              editoras.add(editora);
            }
            //ConexaoFabrica.closeConn(con, ps);
            return editoras;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public ArrayList<Livro> populaLivroCombo(){
        ArrayList<Livro> livros = new ArrayList<>();
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT DISTINCT * FROM Books ORDER BY title";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
              Livro livro = new Livro(rs.getString("isbn"), 
                                      rs.getString("title"),
                                      rs.getDouble("price")
              );

              livros.add(livro);
            }
            //ConexaoFabrica.closeConn(con, ps);
            return livros;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public boolean excluiLivro(String id){
        try{
            con = ConexaoFabrica.getConexao();
            query = "DELETE FROM BooksAuthors WHERE isbn=?";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
            query = "DELETE FROM Books WHERE isbn=?";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
            
            return true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    @Override
    public boolean excluiAutor(String id){
        try{
            con = ConexaoFabrica.getConexao();
            query = "DELETE FROM Authors WHERE author_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            
            //CHECA BANCO PARA SABER SE EXISTE ALGUM LIVRO ASSOCIADO AO AUTOR
            check_db = con.prepareStatement("SELECT * FROM BooksAuthors WHERE author_id=?");
            check_db.setInt(1, Integer.parseInt(id));
            rs = check_db.executeQuery();
            if(!(rs.next())){
                ps.executeUpdate();
                return true;
            }
            //
     
        }catch(Exception e){
            e.printStackTrace();           
        }
        return false;
    }
    
    @Override
    public void excluiAutorLivros(String id){
        String isbn;
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT isbn FROM BooksAuthors WHERE author_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            while(rs.next()){
                isbn = rs.getString("isbn");
                query = "DELETE FROM BooksAuthors WHERE isbn=?";
                ps = con.prepareStatement(query);
                ps.setString(1, isbn);
                ps.executeUpdate();
                query = "DELETE FROM Books WHERE isbn=?";
                ps = con.prepareStatement(query);
                ps.setString(1, isbn);
                ps.executeUpdate();
            }
//            query = "DELETE FROM BooksAuthors WHERE author_id=?";
//            ps = con.prepareStatement(query);
//            ps.setInt(1, Integer.parseInt(id));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean excluiEditora(String id){
        try{
            con = ConexaoFabrica.getConexao();
            query = "DELETE FROM Publishers WHERE publisher_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            
            check_db = con.prepareStatement("SELECT * FROM Books WHERE publisher_id=?");
            check_db.setInt(1, Integer.parseInt(id));
            rs = check_db.executeQuery();
            if(!(rs.next())){
                ps.executeUpdate();
                return true;
            }      
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public void excluiEditoraLivros(String id){
        String isbn;
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT isbn FROM Books WHERE publisher_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            while(rs.next()){
                isbn = rs.getString("isbn");
                query = "DELETE FROM BooksAuthors WHERE isbn=?";
                ps = con.prepareStatement(query);
                ps.setString(1, isbn);
                ps.executeUpdate();
                query = "DELETE FROM Books WHERE isbn=?";
                ps = con.prepareStatement(query);
                ps.setString(1, isbn);
                ps.executeUpdate();
            }
//            query = "DELETE FROM BooksAuthors WHERE author_id=?";
//            ps = con.prepareStatement(query);
//            ps.setInt(1, Integer.parseInt(id));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public Livro buscaExcluiLivro(String id){
        Livro livro = null;
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT b.isbn, title, fname, a.name, price, p.name, url "
                    + " FROM Books b, Publishers p, Authors a, BooksAuthors ba "
                    + " WHERE b.publisher_id=p.publisher_id "
                    + " AND b.isbn = ba.isbn "
                    + " AND ba.author_id=a.author_id "
                    + " AND b.isbn=? ";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            rs.next();
            livro = new Livro(rs.getString("isbn"), rs.getString("title"), rs.getDouble("price"));
            livro.setEditora(new Editora(rs.getString(6),rs.getString("url")));
            
            query = "SELECT * FROM BooksAuthors, Authors "
                    + " WHERE Authors.author_id=BooksAuthors.author_id AND isbn=?";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                livro.addAutor(new Autor(rs.getString("fname"), rs.getString("name")));
            }
            
            return livro;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override 
    public Autor buscaExcluiAutor(String id){
        Autor autor;
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT * FROM Authors WHERE author_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            rs.next();
            autor = new Autor(rs.getString("fname"), rs.getString("name"), rs.getInt("author_id"));
            return autor;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override 
    public Editora buscaExcluiEditora(String id){
        Editora editora;
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT * FROM Publishers WHERE publisher_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            rs.next();
            editora = new Editora(rs.getString("name"), rs.getString("url"), rs.getInt("publisher_id"));
            return editora;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void editaLivro(Livro livro){
        try{
            con = ConexaoFabrica.getConexao();
            query = "DELETE FROM BooksAuthors WHERE isbn=?";
            ps = con.prepareStatement(query);
            ps.setString(1, livro.getIsbn());
            ps.executeUpdate();
            
            query = "UPDATE Books SET title=?, price=ROUND(?, 2), publisher_id=? "
                    + "WHERE isbn=?;";
            ps = con.prepareStatement(query);
            ps.setString(1, livro.getTitulo());
            ps.setDouble(2, livro.getPreco());
            ps.setInt(3, livro.getEditora().getIdEditora());
            ps.setString(4, livro.getIsbn());
            ps.executeUpdate();
            
            query = "INSERT INTO BooksAuthors (isbn, author_id, seq_no) "
                    + "VALUES (?, ?, ?)";
            ps = con.prepareStatement(query);
            for(int i=0 ; i<livro.getAutores().size() ; i++){
                ps.setString(1, livro.getIsbn());
                ps.setInt(2, livro.getAutores().get(i).getIdAutor());
                ps.setInt(3, i+1);
                ps.executeUpdate();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void editaAutor(Autor autor){
        try{
            con = ConexaoFabrica.getConexao();
            query = "UPDATE Authors SET fname=?, name=? WHERE author_id=?";
            ps = con.prepareStatement(query);
            ps.setString(1, autor.getNome());
            ps.setString(2, autor.getSobrenome());
            ps.setInt(3, autor.getIdAutor());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void editaEditora(Editora editora){
        try{
            con = ConexaoFabrica.getConexao();
            query = "UPDATE Publishers SET name=?, url=? WHERE publisher_id=?";
            ps = con.prepareStatement(query);
            ps.setString(1, editora.getNome());
            ps.setString(2, editora.getUrl());
            ps.setInt(3, editora.getIdEditora());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public Livro buscaEditaLivro(String id){
        Livro livro = null;
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT b.isbn, title, fname, a.name, price, p.name, url, b.publisher_id "
                    + " FROM Books b, Publishers p, Authors a, BooksAuthors ba "
                    + " WHERE b.publisher_id=p.publisher_id "
                    + " AND b.isbn = ba.isbn "
                    + " AND ba.author_id=a.author_id "
                    + " AND b.isbn=? ";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            rs.next();
            livro = new Livro(rs.getString("isbn"), rs.getString("title"), rs.getDouble("price"));
            livro.setEditora(new Editora(rs.getString(6),rs.getString("url"), rs.getInt(8)));
            
            query = "SELECT fname, name, BooksAuthors.author_id FROM BooksAuthors, Authors "
                    + " WHERE Authors.author_id=BooksAuthors.author_id AND isbn=?";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                livro.addAutor(new Autor(rs.getString("fname"), rs.getString("name"), rs.getInt(3)));
            }
            
            return livro;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override 
    public Autor buscaEditaAutor(String id){
        Autor autor;
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT * FROM Authors WHERE author_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            rs.next();
            autor = new Autor(rs.getString("fname"), rs.getString("name"), rs.getInt("author_id"));
            return autor;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override 
    public Editora buscaEditaEditora(String id){
        Editora editora;
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT * FROM Publishers WHERE publisher_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            rs.next();
            editora = new Editora(rs.getString("name"), rs.getString("url"), rs.getInt("publisher_id"));
            return editora;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void adicionaLivro(Livro livro){
        try{
            con = ConexaoFabrica.getConexao();
            query = "INSERT INTO Books (isbn, title, price, publisher_id) "
                    + "VALUES (?, ?, ROUND(?, 2), ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, livro.getIsbn());
            ps.setString(2, livro.getTitulo());
            ps.setDouble(3, livro.getPreco());
            ps.setInt(4, livro.getEditora().getIdEditora());
            ps.executeUpdate();
            
            query = "INSERT INTO BooksAuthors (isbn, author_id, seq_no) "
                    + "VALUES (?, ?, ?)";
            ps = con.prepareStatement(query);
            for(int i=0 ; i<livro.getAutores().size() ; i++){
                ps.setString(1, livro.getIsbn());
                ps.setInt(2, livro.getAutores().get(i).getIdAutor());
                ps.setInt(3, i+1);
                ps.executeUpdate();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void adicionaAutor(Autor autor){
        try{
            con = ConexaoFabrica.getConexao();
            query = "INSERT INTO Authors (fname, name) "
                    + "VALUES (?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, autor.getNome());
            ps.setString(2, autor.getSobrenome());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void adicionaEditora(Editora editora){
        try{
            con = ConexaoFabrica.getConexao();
            query = "INSERT INTO Publishers (name, url) "
                    + "VALUES (?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, editora.getNome());
            ps.setString(2, editora.getUrl());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean verificaLivro(String id){
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT * FROM Books WHERE isbn=?";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean verificaAutor(int id){
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT * FROM Authors WHERE author_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean verificaEditora(int id){
        try{
            con = ConexaoFabrica.getConexao();
            query = "SELECT * FROM Publishers WHERE publisher_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
