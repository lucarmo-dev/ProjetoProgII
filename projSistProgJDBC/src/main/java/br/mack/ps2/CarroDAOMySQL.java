package br.mack.ps2;

import java.sql.*;
import java.util.*;

public class CarroDAOMySQL implements CarroDAO{

    private String createSQL= "INSERT INTO carro VALUES (?,?,?,?,?)";
    private String readSQL= "SELECT * FROM carro";
    private String deleteSQL= "DELETE FROM carro WHERE idcarro=?";
    private String updateSQL= "UPDATE carro SET modelo = ?, ano = ?, marca= ?, categoria= ? where idcarro=?";

    private final MySQLConnection mysql= new MySQLConnection();

    @Override
    public boolean create(Carro carro) {
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm= conexao.prepareStatement(createSQL);
            stm.setString(1,carro.getIdcarro());
            stm.setString(2,carro.getModelo());
            stm.setString(3,carro.getMarca());
            stm.setInt(4, carro.getAno());
            stm.setString(5,carro.getCategoria());

            int registros = stm.executeUpdate();
            return registros>0 ? true:false;

        }catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        }catch(final Exception ex) {
            ex.printStackTrace();
        }finally {
            try{
                conexao.close();
            }catch(final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Carro> read() {
        Connection conexao= mysql.getConnection();
        List<Carro> carros = new ArrayList();

        try{
            PreparedStatement stm= conexao.prepareStatement(readSQL);
            ResultSet rs= stm.executeQuery();

            while(rs.next()){
                Carro carro = new Carro();
                carro.setIdcarro(rs.getString("idcarro"));
                carro.setModelo(rs.getString("modelo"));
                carro.setMarca(rs.getString("marca"));
                carro.setAno(rs.getInt("ano"));
                carro.setCategoria(rs.getString("categoria"));


                carros.add(carro);
            }
            return carros;
        }catch(final SQLException ex){
            System.out.println("Banco de dados deu erro ");
            ex.printStackTrace();
        }catch(final Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                conexao.close();
            }catch(final Exception ex){
                ex.printStackTrace();
            }
        }
        return carros;
    }

    public boolean delete(Carro carro){
        Connection conexao= mysql.getConnection();

        try{

            PreparedStatement stm= conexao.prepareStatement(deleteSQL);
            stm.setString(1, carro.getIdcarro());
            int registros= stm.executeUpdate();
            return registros>0 ? true:false;

        }catch(final SQLException ex){
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        }catch(final Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                conexao.close();
            }catch(final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean update(Carro carro){
        Connection conexao= mysql.getConnection();

        try{
            PreparedStatement stm= conexao.prepareStatement(updateSQL);
            stm.setString(5,carro.getIdcarro());
            stm.setString(1,carro.getModelo());
            stm.setInt(2, carro.getAno());
            stm.setString(3,carro.getMarca());
            stm.setString(4,carro.getCategoria());


            int registros= stm.executeUpdate();
            return registros>0 ? true:false;
        }catch(final SQLException ex){
            System.out.println("Banco de dados deu erro ");
            ex.printStackTrace();
        }catch(final Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                conexao.close();
            }catch(final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }
}
