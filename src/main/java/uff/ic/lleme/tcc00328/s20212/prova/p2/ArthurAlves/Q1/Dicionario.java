package uff.ic.lleme.tcc00328.s20212.prova.p2.ArthurAlves.Q1;

import java.util.ArrayList;
import java.util.List;


public class Dicionario {
    public List<Palavra> listaDePalavras = new ArrayList<>();
    
    public Dicionario(){
        
    }   
    
    public void adicionaPalavra(String grafia, String[] significadosAtual){
        Palavra palavraAtual = new Palavra();
        palavraAtual.setGrafia(grafia);
        
        for (String significadoAtual : significadosAtual) {
            // para todos os significados novos
            boolean achou = false;
            for (int j = 0; j < this.listaDePalavras.size(); j++){  // para cada palavra no dic
                for (int c = 0; c < this.listaDePalavras.get(j).getQtdSignificados(); c++){ // para cada significado da palavra no dic
                    if (this.listaDePalavras.get(j).getSignificado(c).equals(significadosAtual[j])){  // confere se ja existe o significado
                        Sinonimos sinonimoAtual = listaDePalavras.get(j).getSinonimos(c);
                        sinonimoAtual.setPalavra(palavraAtual); // guarda a palavra na lista de sinonimos com o mesmo significado
                        palavraAtual.setSinonimo(sinonimoAtual); // linka a palavra com o sinonimo 
                        achou = true;
                        break;
                    }
                    if (achou)
                        break;
                }
            }
            if (!achou) {
                palavraAtual.criaNovoSinonimo(significadoAtual);
            }
        }
        this.listaDePalavras.add(palavraAtual);
        
    }
    
    
    public void mostraPalavras(){ 
        for (int i = 0; i < this.listaDePalavras.size(); i++){ // para o tamanho do dicionario
            System.out.println(this.listaDePalavras.get(i).grafia);  // printa a palavra da vez
            for (int j = 0; j < this.listaDePalavras.get(i).getQtdSignificados(); j++){ // para cada significado dessa palavra 
                System.out.println(this.listaDePalavras.get(i).getSignificado(j)); // printa o significado
            }
        System.out.printf("\n"); // quebra a linha 
        }
        
    }
    
    public Palavra getPalavraAtual(int indice){
        return this.listaDePalavras.get(indice);
    }

}
