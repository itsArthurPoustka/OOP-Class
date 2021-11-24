package uff.ic.lleme.tcc00328.s20212.prova.p1.ArthurAlves;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class GestorRestaurante {
    
    public static Pedido[] vetorDePedidos;
    public static Prato[] vetorDePratos;
    
    public static void main(String[] args) throws IOException {
        
        float valorPedidoAtual;
        // Questao 1
        carregaPratos("src\\main\\java\\uff\\ic\\lleme\\tcc00328\\s20212\\prova\\p1\\ArthurAlves\\ArqDePratos.txt");
        carregaPedidos("src\\main\\java\\uff\\ic\\lleme\\tcc00328\\s20212\\prova\\p1\\ArthurAlves\\ArqDePedidos.txt");
        valorPedidoAtual = valorDaConta(2); //o vetor de pedidos comeca na posicao 0 e termina na posicao 3
        System.out.printf("Valor do Pedido = R$ %g\n", valorPedidoAtual);
        
        // Questao 2
        mostraPercentualPratos();
    }
    
    public static void carregaPratos(String NomeArquivo) throws FileNotFoundException, IOException{
        
        InputStream arquivo = new FileInputStream(NomeArquivo);
        Scanner leitorArq = new Scanner(arquivo);
        int qtdPratosArquivo = contaLinhasArq(NomeArquivo);
        
        Float precoPratoAtual;
        String nomePratoAtual;
        
        Prato[] vetorAtual = new Prato[qtdPratosArquivo];
        
        for (int i = 0; i < qtdPratosArquivo; i++){
            // instancia novos pratos para guardar no vetor de pratos local
            // o formato do arquivo eh preco : nome do prato
            precoPratoAtual =  leitorArq.nextFloat();
            nomePratoAtual = leitorArq.next();
            Prato pratoAtual = new Prato(nomePratoAtual, precoPratoAtual);
            vetorAtual[i] = pratoAtual;
                    
        }
        arquivo.close();
        // sobrescreve o vetor global de pratos
        vetorDePratos = vetorAtual;
    }
    
    public static void carregaPedidos(String NomeArquivo) throws FileNotFoundException, IOException{
        
        InputStream arquivo = new FileInputStream(NomeArquivo);
        Scanner leitorArq = new Scanner(arquivo);
        int qtdLinhasArquivo = contaLinhasArq(NomeArquivo), indexVetorAtual = 0;
        
        Pedido[] vetorAtual = new Pedido[qtdLinhasArquivo]; // vetor para sobrescrever o global
        
        while(leitorArq.hasNext()){
            // o formato do arquivo eh qtd de itens no pedido : prato pedido : qtd do prato pedido
            int qtdPratosAtual = leitorArq.nextInt();
            // instancia o Pedido atual 
            Pedido pedidoAtual = new Pedido(qtdPratosAtual);
            // instancia a lista de itens desse pedido
            Item[] itensAtuais = new Item[qtdPratosAtual];
            
            for (int i = 0;i < qtdPratosAtual;i++){
                String nomePratoAtual = leitorArq.next();
                // pega quantos pratos foram pedidos
                int qtdAtual = leitorArq.nextInt();
                Prato pratoAtual = null;
                // procura o prato no vetor global de pratos 
                for (int j = 0; j < vetorDePratos.length; j++){
                    if (nomePratoAtual.contentEquals(vetorDePratos[j].getNomeDoPrato())){
                        pratoAtual = vetorDePratos[j];
                        break;
                    }
                }              
                itensAtuais[i] = new Item(pratoAtual, qtdAtual);
            }
            
            pedidoAtual.setItens(itensAtuais);
            vetorAtual[indexVetorAtual] = pedidoAtual;
            indexVetorAtual++;
        }
        vetorDePedidos = vetorAtual;
        arquivo.close();
    }
    
    public static int contaLinhasArq(String NomeArquivo) throws IOException{ // conta as linhas dos arquivos 
            
            InputStream arquivo = new FileInputStream(NomeArquivo);
            Scanner leitorArq = new Scanner(arquivo);
            int nLinhas = 0;

            while (leitorArq.hasNext()){
                leitorArq.nextLine();
                nLinhas++;
            }
            arquivo.close();
            return nLinhas;
        }
    public static float valorDaConta(int indexPedido){
        
        float valorAtual = 0;
        
        for (int i = 0; i < vetorDePedidos[indexPedido].getItens().length; i++){
            valorAtual += vetorDePedidos[indexPedido].getItens()[i].getQtdDoPrato() * vetorDePedidos[indexPedido].getItens()[i].getPratoPedido().getPrecoDoPrato();
        }
        
        return valorAtual;
    }
    
    public static void mostraPercentualPratos(){
        float percentualPratoAtual;
        float totalDePratos = 0;
        
        for(int i = 0; i < vetorDePedidos.length; i++){ 
            for (int j = 0; j < vetorDePedidos[i].getItens().length; j++){
                totalDePratos += vetorDePedidos[i].getItens()[j].getQtdDoPrato();
            }
        }
        
        for (int i = 0; i < vetorDePratos.length;i++){
            float qtdPratoAtual = 0; // tive que colocar float pq senao dava 0.0% no resultado final 
            for (int j = 0; j < vetorDePedidos.length; j++){
                for (int k = 0; k < vetorDePedidos[j].getItens().length; k++){
                    if (vetorDePratos[i].getNomeDoPrato().contentEquals(vetorDePedidos[j].getItens()[k].getPratoPedido().getNomeDoPrato())){
                        qtdPratoAtual += vetorDePedidos[j].getItens()[k].getQtdDoPrato();   
                    }
                }
            }
            percentualPratoAtual = (qtdPratoAtual/totalDePratos)*100;
            System.out.println("A porcentagem do prato "+ vetorDePratos[i].getNomeDoPrato() + " é " + percentualPratoAtual + "% do total.");
        }        
    }
}
    
