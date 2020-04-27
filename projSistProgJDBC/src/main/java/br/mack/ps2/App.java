package br.mack.ps2;

public class App
{
    public static void main( String[] args ) {
        CarroDAOMySQL mysqlDAO = new CarroDAOMySQL();
        Teste teste = new Teste(mysqlDAO);
        teste.iniciar();

    }

}
