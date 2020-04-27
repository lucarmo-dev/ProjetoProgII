package br.mack.ps2;

import java.util.*;

public interface ProdutoDAO {
    boolean create (Produto produto);
    List<Produto> read();
    boolean update (Produto produto);
    boolean delete (Produto produto);
}