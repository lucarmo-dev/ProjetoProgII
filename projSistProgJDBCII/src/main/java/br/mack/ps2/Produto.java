package br.mack.ps2;

public class Produto {
    private String idproduto;
    private String descricao;
    private String marca;
    private double preco;


    public Produto(){}

    public Produto(String idproduto, String descricao, String marca, double preco){
        this.idproduto=idproduto;
        this.descricao=descricao;
        this.marca=marca;
        this.preco=preco;

    }

    public String getIdproduto(){
        return idproduto;
    }

    public void setIdproduto(String idproduto){
        this.idproduto=idproduto;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao=descricao;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca=marca;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco=preco;
    }


    @Override
    public String toString() {
        return   "  id: " + idproduto + "\n" +
                "   descricao: " + descricao + "\n" +
                "   marca: " + marca + "\n" +
                "   preco: " + preco;


    }

}