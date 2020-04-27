package br.mack.ps2;

public class App
{
    public static void main( String[] args ) {
        ProdutoDAOMySQL mysqlDAO = new ProdutoDAOMySQL();
        Teste teste = new Teste(mysqlDAO);
        teste.iniciar();

    }

}

