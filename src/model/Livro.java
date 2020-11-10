package model;

import java.util.ArrayList;

public class Livro {
    String isbn, titulo;
    double preco;
    ArrayList<Autor> autores;
    Editora editora;
    
    public Livro(String aIsbn, String aTitulo, double aPreco){
        this.isbn = aIsbn;
        this.titulo = aTitulo;
        this.preco = aPreco;
    }
    
    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String aIsbn){
        this.isbn = aIsbn;
    }
    
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String aTitulo){
        this.titulo = aTitulo;
    }
    
    public double getPreco(){
        return preco;
    }
    public void setPreco(double aPreco){
        this.preco = aPreco;
    }
    
    public Editora getEditora(){
        return editora;
    }
    public void setEditora(Editora aEditora){
        this.editora = aEditora;
    }
    
    public ArrayList<Autor> getAutores(){
        return autores;
    }
    public void addAutor(Autor autor){
        if(this.autores==null) this.autores = new ArrayList<>();
        this.autores.add(autor);
    }
    
    @Override
    public String toString(){
        return "ISBN: " + this.getIsbn() + " Titulo: " + this.getTitulo()
                + " Preco: " + this.getPreco();
    }
}
