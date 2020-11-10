package model;

public class Editora {
    String nome, url;
    int idEditora;
    
    public Editora(String aNome, String aUrl, int aIdEditora){
        this.nome = aNome;
        this.url = aUrl;
        this.idEditora = aIdEditora;
    }
    
    public Editora(String aNome, String aUrl){
        this.nome = aNome;
        this.url = aUrl;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String aNome){
        this.nome = aNome;
    }
    
    public String getUrl(){
        return url;
    }
    public void setUrl(String aUrl){
        this.url = aUrl;
    }
    
    public int getIdEditora(){
        return idEditora;
    }
    public void setIdEditora(int aIdEditora){
        this.idEditora = aIdEditora;
    }
    
    @Override
    public String toString(){
        return "ID: " + this.getIdEditora() + " Nome: " + this.getNome() 
                + " URL: " + this.getUrl();
    }
}
