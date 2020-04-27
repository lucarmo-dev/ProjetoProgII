package br.mack.ps2;

public class Carro {
    private String idcarro;
    private String modelo;
    private String marca;
    private int ano;
    private String categoria;


    public Carro(){}

    public Carro(String idcarro, String modelo, String marca, int ano,String categoria){
        this.idcarro=idcarro;
        this.modelo=modelo;
        this.marca=marca;
        this.ano=ano;
        this.categoria=categoria;

    }

    public String getIdcarro(){
        return idcarro;
    }

    public void setIdcarro(String idcarro){
        this.idcarro=idcarro;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo=modelo;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca=marca;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setCategoria(String categoria){
        this.categoria=categoria;
    }

    public int getAno(){
        return ano;
    }

    public void setAno(int ano){
        this.ano=ano;
    }

    @Override
    public String toString() {
        return   "  id: " + idcarro + "\n" +
                "   modelo: " + modelo + "\n" +
                "   marca: " + marca + "\n" +
                "   ano: " + ano + "\n" +
                "   categoria: " + categoria;


    }

}

