package controller;

import dao.Dao;
import dao.concrete.DaoConcrete;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Autor;
import model.Editora;
import model.Livro;
import view.View;

public class Controller {
    View view;
    Dao dao;
    int addNumAutor = 0, edtNumAutor = 0;
    ArrayList<String> addAutores = new ArrayList<>();
    ArrayList<String> edtAutores = new ArrayList<>();
    
    public Controller(View view){
        this.view = view;
        view.criaJanela();
        dao = new DaoConcrete();
        
        view.setBuscaLivroBtnAl(new BotaoBuscaLivroAl());
        view.setBuscaAutorBtnAl(new BotaoBuscaAutorAl());
        view.setBuscaEditoraBtnAl(new BotaoBuscaEditoraAl());
        
        view.autorIdCombo(dao.populaAutorCombo());
        view.editoraIdCombo(dao.populaEditoraCombo());       
        view.livroIsbnCombo(dao.populaLivroCombo());
        
        view.setExcBuscaLivroAl(new BuscaExcIsbnLivroAl());
        view.setExcBuscaAutorAl(new BuscaExcIdAutorAl());
        view.setExcBuscaEditoraAl(new BuscaExcIdEditoraAl());
        
        view.setExcLivroAl(new BotaoExcluiLivroAl());
        view.setExcAutorAl(new BotaoExcluiAutorAl());
        view.setExcEditoraAl(new BotaoExcluiEditoraAl());
        
        view.setEdtBuscaLivroAl(new BuscaEdtIsbnLivroAl());
        view.setEdtBuscaAutorAl(new BuscaEdtIdAutorAl());
        view.setEdtBuscaEditoraAl(new BuscaEdtIdEditoraAl());
        
        view.setEdtLivroAl(new BotaoEditaLivroAl());
        view.setEdtAutorAl(new BotaoEditaAutorAl());
        view.setEdtEditoraAl(new BotaoEditaEditoraAl());
        
        view.setAddLivroAl(new BotaoAdicionaLivroAl());
        view.setAddAutorAl(new BotaoAdicionaAutorAl());
        view.setAddEditoraAl(new BotaoAdicionaEditoraAl());
        
        view.setAddMaisAl(new BotaoAddLivroMaisAutor());
        view.setAddMenosAl(new BotaoAddLivroMenosAutor());
        
        view.setEdtMaisAl(new BotaoEdtLivroMaisAutor());
        view.setEdtMenosAl(new BotaoEdtLivroMenosAutor());
        
        view.setTrocaAbaAcoes(new BotaoTrocaAbaAcoes("Listar"), 1);
        view.setTrocaAbaAcoes(new BotaoTrocaAbaAcoes("Adicionar"), 2);
        view.setTrocaAbaAcoes(new BotaoTrocaAbaAcoes("Editar"), 3);
        view.setTrocaAbaAcoes(new BotaoTrocaAbaAcoes("Excluir"), 4);
        
        view.setTrocaAbaListar(new BotaoTrocaAbaListar("listarLivroPanel"), 1);
        view.setTrocaAbaListar(new BotaoTrocaAbaListar("listarAutorPanel"), 2);
        view.setTrocaAbaListar(new BotaoTrocaAbaListar("listarEditoraPanel"), 3);
        
        view.setTrocaAbaAdicionar(new BotaoTrocaAbaAdicionar("adicionarLivroPanel"), 1);
        view.setTrocaAbaAdicionar(new BotaoTrocaAbaAdicionar("adicionarAutorPanel"), 2);
        view.setTrocaAbaAdicionar(new BotaoTrocaAbaAdicionar("adicionarEditoraPanel"), 3);
        
        view.setTrocaAbaEditar(new BotaoTrocaAbaEditar("editarLivroPanel"), 1);
        view.setTrocaAbaEditar(new BotaoTrocaAbaEditar("editarAutorPanel"), 2);
        view.setTrocaAbaEditar(new BotaoTrocaAbaEditar("editarEditoraPanel"), 3);
        
        view.setTrocaAbaExcluir(new BotaoTrocaAbaExcluir("excluirLivroPanel"), 1);
        view.setTrocaAbaExcluir(new BotaoTrocaAbaExcluir("excluirAutorPanel"), 2);
        view.setTrocaAbaExcluir(new BotaoTrocaAbaExcluir("excluirEditoraPanel"), 3);       
    }
    
    class BotaoBuscaLivroAl implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
      String busca = view.getLivroBusca();
      String key = busca.substring(0, busca.indexOf(" "));
      String tipo = busca.substring(busca.indexOf(" ")+7);
      ArrayList<Livro> livros =  dao.buscaLivros(key, tipo);
      view.mostraTabelaLivro(livros);
    }
    
  }
    
    class BotaoBuscaAutorAl implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
      String key = view.getAutorBusca();
      ArrayList<Autor> autores =  dao.buscaAutores(key);
      view.mostraTabelaAutor(autores);
    }
    
  }
    
    class BotaoBuscaEditoraAl implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
      String key = view.getEditoraBusca();
      ArrayList<Editora> editoras =  dao.buscaEditoras(key);
      view.mostraTabelaEditora(editoras);
    }
    
  }
    class BuscaExcIsbnLivroAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Livro livro = dao.buscaExcluiLivro(view.getExcLivroIsbn());
            view.fillExcLivro(livro);
        }
    }
    
    class BuscaExcIdAutorAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Autor autor = dao.buscaExcluiAutor(view.getExcAutorId());
            view.fillExcAutor(autor);
        }
    }
    
    class BuscaExcIdEditoraAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Editora editora = dao.buscaExcluiEditora(view.getExcEditoraId());
            view.fillExcEditora(editora);
        }
    }
    
    class BuscaEdtIsbnLivroAl implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Livro livro = dao.buscaEditaLivro(view.getEdtLivroIsbn());
            for(int i=0 ; i<livro.getAutores().size() ; i++){
                edtAutores.add(livro.getAutores().get(i).getIdAutor()+" | "+livro.getAutores().get(i).getNome().trim());
                System.out.println(edtNumAutor);
                edtNumAutor++;
            }
            System.out.println(edtAutores.toString());
            view.fillEdtLivro(livro);
        }
        
    }
    
    class BuscaEdtIdAutorAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Autor autor = dao.buscaEditaAutor(view.getEdtAutorId());
            view.fillEdtAutor(autor);
        }
    }
    
    class BuscaEdtIdEditoraAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Editora editora = dao.buscaEditaEditora(view.getEdtEditoraId());
            view.fillEdtEditora(editora);
        }
    }
    
    class BotaoExcluiLivroAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", 
                    "Confirmacao", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION){
                String id = view.getExcLivroIsbn();
                if(dao.excluiLivro(id)){
                    JOptionPane.showMessageDialog(null, "Livro removido com sucesso");
                    atualizaTabelas();
                    atualizaCombos();
                    limpaCampos();
                }else{
                    JOptionPane.showMessageDialog(null, "Nao foi possivel remover o livro.");
                }
            }
        }
    }
    
    class BotaoExcluiAutorAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", 
                    "Confirmacao", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION){
                String id = view.getExcAutorId();
                if(dao.excluiAutor(id)){
                    JOptionPane.showMessageDialog(null, "Autor removido com sucesso");
                    atualizaTabelas();
                    atualizaCombos();
                    limpaCampos();
                }else{
                    //JOptionPane.showMessageDialog(null, "Nao foi possivel remover o autor.");
                    int op2 = JOptionPane.showConfirmDialog(null, "Nao foi possivel remover o autor pois existem um ou mais livros "
                            + "associados a ele.\n Para realizar a exclusao do mesmo e necessario excluir os livros associados. "
                            + "\nDeseja excluir o autor e seus livros?", "Confirmacao", JOptionPane.YES_NO_OPTION);
                    if(op2==JOptionPane.YES_OPTION){
                        dao.excluiAutorLivros(id);
                        dao.excluiAutor(id);
                        JOptionPane.showMessageDialog(null, "Autor e livros removidos com sucesso");
                        atualizaTabelas();
                        atualizaCombos();
                        limpaCampos();
                    }
                }
                
            }
            
        }
    }
    
    class BotaoExcluiEditoraAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", 
                    "Confirmacao", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION){
                String id = view.getExcEditoraId();
                if(dao.excluiEditora(id)){
                    JOptionPane.showMessageDialog(null, "Editora removida com sucesso");
                    atualizaTabelas();
                    atualizaCombos();
                    limpaCampos();
                }else{
                    //JOptionPane.showMessageDialog(null, "Nao foi possivel remover a editora.");
                    int op2 = JOptionPane.showConfirmDialog(null, "Nao foi possivel remover a editora pois existem um ou mais livros "
                            + "associados a ela.\n Para realizar a exclusao da mesma e necessario excluir os livros associados. "
                            + "\nDeseja excluir a editora e seus livros?", "Confirmacao", JOptionPane.YES_NO_OPTION);
                    if(op2==JOptionPane.YES_OPTION){
                        dao.excluiEditoraLivros(id);
                        dao.excluiEditora(id);                       
                        JOptionPane.showMessageDialog(null, "Editora e livros removidos com sucesso");
                        atualizaTabelas();
                        atualizaCombos();
                        limpaCampos();
                    }
                }
 
            }
            
        }
    }
    
    class BotaoEditaLivroAl implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar as alteracoes?", 
                    "Confirmacao", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION){
                //String id = view.getEdtLivroIsbn();
                
                String anome; int aid;
                Livro livro = view.getEdtLivro();                
                
                if(!(livro.getTitulo().isEmpty()) && !(edtAutores.isEmpty()) && !(livro.getPreco()<0)
                        && !(livro.getIsbn().length()<3) && (livro.getIsbn().matches("[0-9\\-]+"))){
                    for(int i=0 ; i<edtAutores.size() ; i++){
                        anome = edtAutores.get(i).substring(edtAutores.get(i).lastIndexOf(" ")+1);
                        aid = Integer.parseInt(edtAutores.get(i).substring(0, edtAutores.get(i).indexOf(" ")));
                        livro.addAutor(new Autor(anome, "", aid));
                    }
                    dao.editaLivro(livro);
                    edtNumAutor = 0;
                    edtAutores.clear();
                    JOptionPane.showMessageDialog(null, "Alteracao de livro realizada com sucesso");
                    atualizaTabelas();
                    atualizaCombos();
                    limpaCampos();
                }else{
                    JOptionPane.showMessageDialog(null, "Favor preencher todos os campos corretamente");
                }
                
            }
        }
        
    }
    
    class BotaoEditaAutorAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar as alteracoes?", 
                    "Confirmacao", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION){
                //String id = view.getEdtAutorId();
                Autor autor = view.getEdtAutor();
                if(!(autor.getNome().isEmpty()) && !(autor.getSobrenome().isEmpty())){
                    dao.editaAutor(autor);
                    JOptionPane.showMessageDialog(null, "Alteracao de autor realizada com sucesso");
                    atualizaTabelas();
                    atualizaCombos();
                    limpaCampos();
                }else{
                    JOptionPane.showMessageDialog(null, "Favor preencher todos os campos corretamente");
                }
                
            }
            
        }
    }
    
    class BotaoEditaEditoraAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar as alteracoes?", 
                    "Confirmacao", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION){
                //String id = view.getEdtEditoraId();
                Editora editora = view.getEdtEditora();
                if(!(editora.getNome().isEmpty()) && !(editora.getUrl().isEmpty()) && (editora.getUrl().contains("."))){
                    dao.editaEditora(editora);
                               
                    JOptionPane.showMessageDialog(null, "Alteracao de editora realizada com sucesso");
                    atualizaTabelas();
                    atualizaCombos();
                    limpaCampos();
                }else{
                    JOptionPane.showMessageDialog(null, "Favor preencher todos os campos corretamente");
                }
                
            }
            
        }
    }
    
    class BotaoAdicionaLivroAl implements ActionListener{
        Livro livro;
        @Override
        public void actionPerformed(ActionEvent e){
           
            livro = view.getAddLivro();
            if(!(livro.getTitulo().isEmpty()) && !(addAutores.isEmpty()) && !(livro.getPreco()<0)
                    && (livro.getIsbn().length()==13 || livro.getIsbn().length()==10) 
                    && (livro.getIsbn().matches("[0-9\\-]+"))){
                String anome; 
                int aid;

                    for(int i=0 ; i<addAutores.size() ; i++){
                        anome = addAutores.get(i).substring(addAutores.get(i).lastIndexOf(" ")+1);
                        aid = Integer.parseInt(addAutores.get(i).substring(0, addAutores.get(i).indexOf(" ")));
                        livro.addAutor(new Autor(anome, "", aid));
                    }

                
                    if(dao.verificaLivro(livro.getIsbn())==true){
                        JOptionPane.showMessageDialog(null, "ISBN ja existente");
                    }else{
                        dao.adicionaLivro(livro);
                        addNumAutor = 0;
                        addAutores.clear();
                        JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso");
                        atualizaTabelas();
                        atualizaCombos();
                        limpaCampos();
                    }
               
            }else{
                JOptionPane.showMessageDialog(null, "Favor preencher todos os campos corretamente");
            }
            
            
        }
    }
    
    class BotaoAdicionaAutorAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Autor autor = view.getAddAutor();
            if(!(autor.getNome().isEmpty()) && !(autor.getSobrenome().isEmpty())){
                dao.adicionaAutor(autor);
                JOptionPane.showMessageDialog(null, "Autor adicionado com sucesso");
                atualizaTabelas();
                atualizaCombos();
                limpaCampos();
            }else{
                JOptionPane.showMessageDialog(null, "Favor preencher todos os campos corretamente");
            }
            
        }
    }
    
    class BotaoAdicionaEditoraAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Editora editora = view.getAddEditora();

            if(!(editora.getNome().isEmpty()) && !(editora.getUrl().isEmpty()) && (editora.getUrl().contains("."))){
                dao.adicionaEditora(editora);
                JOptionPane.showMessageDialog(null, "Editora adicionada com sucesso");
                atualizaTabelas();
                atualizaCombos();
                limpaCampos();
            }else{
                JOptionPane.showMessageDialog(null, "Favor preencher todos os campos corretamente");
            }
            
        }
    }
    
    class BotaoAddLivroMaisAutor implements ActionListener{
        String autor;
        @Override
        public void actionPerformed(ActionEvent e) {
            autor = view.getAddLivroMaisAutor();
            if(!(addAutores.contains(autor))){
                addAutores.add(autor);
                System.out.println(addNumAutor);
                System.out.println(addAutores.toString());
                System.out.println(addAutores.get(addNumAutor).substring(addAutores.get(addNumAutor).lastIndexOf(" ")+1));

                addNumAutor++;
                view.livroAutoresAddField(addAutores);
            }            
        }        
    }
    class BotaoAddLivroMenosAutor implements ActionListener{
        String autor;
        @Override
        public void actionPerformed(ActionEvent e) {
            if(addNumAutor>0){
                addNumAutor--;
                addAutores.remove(addNumAutor);
                
                System.out.println(addAutores.toString());
                
                
                view.livroAutoresAddField(addAutores);
            }            
        }        
    }
    
    class BotaoEdtLivroMaisAutor implements ActionListener{
        String autor;
        @Override
        public void actionPerformed(ActionEvent e) {
            autor = view.getEdtLivroMaisAutor();
            if(!(edtAutores.contains(autor))){
                edtAutores.add(autor);
                System.out.println(edtNumAutor);
                System.out.println(edtAutores.toString());
                System.out.println(edtAutores.get(edtNumAutor).substring(edtAutores.get(edtNumAutor).lastIndexOf(" ")+1));

                edtNumAutor++;
                view.livroAutoresEdtField(edtAutores);
            }            
        }        
    }
    class BotaoEdtLivroMenosAutor implements ActionListener{
        String autor;
        @Override
        public void actionPerformed(ActionEvent e) {
            if(edtNumAutor>0){
                edtNumAutor--;
                edtAutores.remove(edtNumAutor);
                
                System.out.println(edtAutores.toString());
                
                view.livroAutoresEdtField(edtAutores);
            }            
        }        
    }
    
    //ATUALIZA CAMPOS
    public void atualizaTabelas(){
        
      ArrayList<Livro> livros = dao.buscaLivros("%%", "Titulo");
      ArrayList<Autor> autores = dao.buscaAutores("%%");
      ArrayList<Editora> editoras =  dao.buscaEditoras("%%");
      
      view.mostraTabelaLivro(livros);
      view.mostraTabelaAutor(autores);
      view.mostraTabelaEditora(editoras);
    }
    
    void atualizaCombos(){
        ArrayList<Livro> livros = dao.buscaLivros("%%", "Titulo");
        ArrayList<Autor> autores = dao.buscaAutores("%%");
        ArrayList<Editora> editoras =  dao.buscaEditoras("%%");
        view.autorIdCombo(autores);
        view.livroIsbnCombo(livros);
        view.editoraIdCombo(editoras);
    }
    
    void limpaCampos(){
        view.limpaCampos();
        addNumAutor = 0;
        edtNumAutor = 0;
        addAutores.clear();
        edtAutores.clear();
    }
    
    //ALTERNAR PANELS/JFRAMES
    class BotaoTrocaAbaAcoes implements ActionListener{
        String nomePanel;
        BotaoTrocaAbaAcoes(String aNomePanel){
            this.nomePanel = aNomePanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            view.trocaAbaAcoes(nomePanel);
        }
    }
    
    class BotaoTrocaAbaListar implements ActionListener{
        String nomePanel;
        BotaoTrocaAbaListar(String aNomePanel){
            this.nomePanel = aNomePanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            view.trocaAbaListar(nomePanel);
        }
    }
    
    class BotaoTrocaAbaAdicionar implements ActionListener{
        String nomePanel;
        BotaoTrocaAbaAdicionar(String aNomePanel){
            this.nomePanel = aNomePanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            view.trocaAbaAdicionar(nomePanel);
        }
    }
    
    class BotaoTrocaAbaEditar implements ActionListener{
        String nomePanel;
        BotaoTrocaAbaEditar(String aNomePanel){
            this.nomePanel = aNomePanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            view.trocaAbaEditar(nomePanel);
        }
    }
    
    class BotaoTrocaAbaExcluir implements ActionListener{
        String nomePanel;
        BotaoTrocaAbaExcluir(String aNomePanel){
            this.nomePanel = aNomePanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            view.trocaAbaExcluir(nomePanel);
        }
    }
}
