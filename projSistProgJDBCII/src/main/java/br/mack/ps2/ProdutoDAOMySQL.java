package br.mack.ps2;

import java.sql.*;
import java.util.*;

public class ProdutoDAOMySQL implements ProdutoDAO{

    private String createSQL= "INSERT INTO produto VALUES (?,?,?,?)";
    private String readSQL= "SELECT * FROM produto";
    private String deleteSQL= "DELETE FROM produto WHERE idproduto=?";
    private String updateSQL= "UPDATE produto SET descricao = ?, marca= ?, preco= ? WHERE idproduto=?";

    private final MySQLConnection mysql= new MySQLConnection();

    @Override
    public boolean create(Produto produto) {
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm= conexao.prepareStatement(createSQL);
            stm.setString(1,produto.getIdproduto());
            stm.setString(2,produto.getDescricao());
            stm.setString(3,produto.getMarca());
            stm.setDouble(4,produto.getPreco());

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
    public List<Produto> read() {
        Connection conexao= mysql.getConnection();
        List<Produto> produtos = new ArrayList();

        try{
            PreparedStatement stm= conexao.prepareStatement(readSQL);
            ResultSet rs= stm.executeQuery();

            while(rs.next()){
                Produto produto = new Produto();
                produto.setIdproduto(rs.getString("idproduto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setMarca(rs.getString("marca"));
                produto.setPreco(rs.getDouble("preco"));


                produtos.add(produto);
            }
            return produtos;
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
        return produtos;
    }

    public boolean delete(Produto produto){
        Connection conexao= mysql.getConnection();

        try{

            PreparedStatement stm= conexao.prepareStatement(deleteSQL);
            stm.setString(1, produto.getIdproduto());
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

    public boolean update(Produto produto){
        Connection conexao= mysql.getConnection();

        try{
            PreparedStatement stm= conexao.prepareStatement(updateSQL);
            stm.setString(4,produto.getIdproduto());
            stm.setString(1,produto.getDescricao());
            stm.setString(2,produto.getMarca());
            stm.setDouble(3,produto.getPreco());




            int registros = stm.executeUpdate();
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
