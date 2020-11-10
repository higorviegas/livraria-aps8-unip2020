package model;

public class Autor {
    String nome, sobrenome;
    int idAutor;
    
    public Autor(String aNome, String aSobrenome, int aIdAutor){
        this.nome = aNome;
        this.sobrenome = aSobrenome;
        this.idAutor = aIdAutor;
    }
    
    public Autor(String aNome, String aSobrenome){
        this.nome = aNome;
        this.sobrenome = aSobrenome;
        
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String aNome){
        this.nome = aNome;
    }
    
    public String getSobrenome(){
        return sobrenome;
    }
    public void setSobrenome(String aSobrenome){
        this.sobrenome = aSobrenome;
    }
    
    public int getIdAutor(){
        return idAutor;
    }
    public void setIdAutor(int aIdAutor){
        this.idAutor = aIdAutor;
    }
    
    @Override
    public String toString(){
        return "ID: " + this.getIdAutor() + " Nome: " + this.getNome() 
                + " Sobrenome: " + this.getSobrenome();
    }
}
