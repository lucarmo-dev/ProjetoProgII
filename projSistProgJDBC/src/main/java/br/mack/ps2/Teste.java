package br.mack.ps2;

import java.util.*;

public class Teste {
    CarroDAO dao;
    Scanner in;

    public Teste(CarroDAO dao){
        this.dao= dao;
        this.in= new Scanner(System.in);
    }

    public void iniciar(){
        imprimirMenu();
    }

    private void imprimirMenu(){
        int opc=0;
        do{
            System.out.println("\n==================");
            System.out.println("==== MENU ====");
            System.out.println("\t1. Create");
            System.out.println("\t2. Read");
            System.out.println("\t3. Update");
            System.out.println("\t4. Delete");
            System.out.println("\t5. Sair");
            System.out.println("\n==================");
            System.out.println("Escolha uma opção: ");
            opc= in.nextInt();

            in.nextLine();

            switch (opc){
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    this.update();
                    break;
                case 4:
                    this.delete();
                    break;
                case 5:
                    System.out.println("Você saiu!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    System.out.println("Escolha uma das opções exibidas no menu!");
            }

        }while(opc!=5);
    }

    private void create(){
        Carro carro = new Carro();

        System.out.println("\n***************");
        System.out.println("*** Novo Carro ***");
        System.out.println("\n***************");

        System.out.println("Informe o id do carro: ");
        carro.setIdcarro(in.nextLine());

        System.out.println("Informe o modelo do carro: ");
        carro.setModelo(in.nextLine());

        System.out.println("Informe a marca do carro: ");
        carro.setMarca(in.nextLine());

        System.out.println("Digite o ano do carro: ");
        carro.setAno(in.nextInt());
        in.nextLine();

        System.out.println("Informe a categoria do carro: ");
        carro.setCategoria(in.nextLine());

        if(dao.create(carro)){
            System.out.println("Informações do carro adicionadas ao banco de dados");
        }else{
            System.out.println("Erro: Não foi possível adicionar as informções no banco de dados");
        }
    }

    private void read(){
        List<Carro> Carro = dao.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de carros Cadastrados ***");
        System.out.println("***********************************");
        for(Carro carro : Carro) {
            System.out.println(carro);
        }
    }

    private void update(){
        Carro carro = new Carro();
        read();

        System.out.println("Informe o id do carro: ");
        carro.setIdcarro(in.nextLine());

        System.out.println("Atualize o modelo do carro: ");
        carro.setModelo(in.nextLine());

        System.out.println("Atualize o ano do carro: ");
        carro.setAno(in.nextInt());

        in.nextLine();

        System.out.println("Atualize a marca do carro: ");
        carro.setMarca(in.nextLine());

        System.out.println("Atualize a categoria do carro: ");
        carro.setCategoria(in.nextLine());

        if(dao.update(carro)){
            System.out.println("Informações do carro atualizadas no banco de dados");
        }else{
            System.out.println("Erro: Não foi possível atualizar as informções no banco de dados");
        }
    }

    public void delete(){
        Carro carro = new Carro();
        System.out.println("Informe o id do carro");
        carro.setIdcarro(in.nextLine());
        if(dao.delete(carro)){
            System.out.println("carro deletado do banco de dados");
        }else{
            System.out.println("Erro: Não foi deletar as informções no banco de dados");
        }
    }
}

