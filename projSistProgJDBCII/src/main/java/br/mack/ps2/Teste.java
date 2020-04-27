package br.mack.ps2;

import java.util.*;

public class Teste {
    ProdutoDAO dao;
    Scanner in;

    public Teste(ProdutoDAO dao){
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
        Produto produto = new Produto();

        System.out.println("\n***************");
        System.out.println("*** Novo Produto ***");
        System.out.println("\n***************");

        System.out.println("Informe o id do produto: ");
        produto.setIdproduto(in.nextLine());

        System.out.println("Informe a descricao do produto: ");
        produto.setDescricao(in.nextLine());

        System.out.println("Informe a marca do produto: ");
        produto.setMarca(in.nextLine());

        System.out.println("Digite o preco do produto: ");
        produto.setPreco(in.nextDouble());
        in.nextLine();


        if(dao.create(produto)){
            System.out.println("Informações do produto adicionadas ao banco de dados");
        }else{
            System.out.println("Erro: Não foi possível adicionar as informções no banco de dados");
        }
    }

    private void read(){
        List<Produto> Produto = dao.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Produtos Cadastrados ***");
        System.out.println("***********************************");
        for(Produto produto : Produto) {
            System.out.println(produto);
        }
    }

    private void update(){
        Produto produto = new Produto();
        read();

        System.out.println("Informe o id do produto: ");
        produto.setIdproduto(in.nextLine());

        System.out.println("Atualize a descricao do produto: ");
        produto.setDescricao(in.nextLine());

        System.out.println("Atualize a marca do produto: ");
        produto.setMarca(in.nextLine());

        System.out.println("Atualize o preco do produto: ");
        produto.setPreco(in.nextDouble());

        in.nextLine();


        if(dao.update(produto)){
            System.out.println("Informações do produto atualizadas no banco de dados");
        }else{
            System.out.println("Erro: Não foi possível atualizar as informções no banco de dados");
        }
    }

    public void delete(){
        Produto produto = new Produto();
        System.out.println("Informe o id do produto");
        produto.setIdproduto(in.nextLine());
        if(dao.delete(produto)){
            System.out.println("produto deletado do banco de dados");
        }else{
            System.out.println("Erro: Não foi deletar as informções no banco de dados");
        }
    }
}


