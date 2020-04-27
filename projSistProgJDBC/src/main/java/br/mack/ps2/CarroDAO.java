package br.mack.ps2;

import java.util.*;

public interface CarroDAO {
    boolean create (Carro carro);
    List<Carro> read();
    boolean update (Carro carro);
    boolean delete (Carro carro);
}