package dao;

import java.util.ArrayList;
import model.Livro;
import model.Autor;
import model.Editora;

public interface Dao {
    public ArrayList<Livro> buscaLivros(String key, String tipo);
    public ArrayList<Autor> buscaAutores(String key);
    public ArrayList<Editora> buscaEditoras(String key);
    
    public ArrayList<Autor> populaAutorCombo();
    public ArrayList<Editora> populaEditoraCombo();
    public ArrayList<Livro> populaLivroCombo();
    
    public Autor buscaExcluiAutor(String id);
    public Editora buscaExcluiEditora(String id);
    public Livro buscaExcluiLivro(String id);
    
    public boolean excluiLivro(String id);
    public boolean excluiAutor(String id);
    public boolean excluiEditora(String id);
    
    public void excluiAutorLivros(String id);
    public void excluiEditoraLivros(String id);
    
    public Livro buscaEditaLivro(String id);
    public Autor buscaEditaAutor(String id);
    public Editora buscaEditaEditora(String id);
    
    public void editaLivro(Livro livro);
    public void editaAutor(Autor autor);
    public void editaEditora(Editora editora);
    
    public void adicionaLivro(Livro livro);
    public void adicionaAutor(Autor autor);
    public void adicionaEditora(Editora editora);
    
    public boolean verificaLivro(String id);
    public boolean verificaAutor(int id);
    public boolean verificaEditora(int id);
}
