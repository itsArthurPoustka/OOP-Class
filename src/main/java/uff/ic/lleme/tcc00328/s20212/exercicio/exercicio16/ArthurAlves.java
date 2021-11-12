
package uff.ic.lleme.tcc00328.s20212.exercicio.exercicio16;

public class ArthurAlves {
    public static void main(String[] args) {
        int time_lider;
        int[][] pontos = {
            //PG  J  V  SG  GP
            {10, 8, 3, -4, 12},
            {17, 8, 5, 10, 19},
            {10, 8, 3, -5, 11},
            {11, 8, 3, -1, 15},
            {19, 8, 6, 13, 23}};
        
        time_lider = pega_lider(5, pontos);
        System.out.printf("O numero do time lider eh: %d", time_lider);
    }
    
    public static int pega_lider(int qtd_times, int[][] tabela){
        
        int[] coluna_atual = new int[qtd_times];
        int ind_col_atual = -1;
        int ind_melhor_time = -1;
        
        // roda ate retornar um indice valido
        while (ind_melhor_time == -1){
            ind_col_atual++;
            if (ind_col_atual == 1) // coluna de jogos n importa na questao
                continue;
            coluna_atual = pega_coluna(tabela, ind_col_atual);
            ind_melhor_time = analisa_coluna(coluna_atual);            
        }
        
        return ind_melhor_time;
    }
    
    public static int analisa_coluna(int[] coluna){
        // analisa a coluna e tenta achar o maior elemento e seu indice
        // se tiver elementos iguais, retorna -1 p/ avaliar a proxima 
        int maior_num = -999999, ind_maior = -1;
        
        for (int i = 0; i < coluna.length; i++){
            if (coluna[i] > maior_num){
                maior_num = coluna[i];
                ind_maior = i;
            }
            else if (coluna[i] == maior_num){
                ind_maior = -1;
                break;
            }
        }
        return ind_maior;
    }
    
    public static int[] pega_coluna(int[][] tabela, int index){
        // retorna a coluna para ser analisada
        int dimensao = tabela.length;
        int[] vetor_coluna = new int[dimensao];
        for (int i = 0; i < tabela.length; i++){
            vetor_coluna[i] = tabela[i][index];
        }
        return vetor_coluna;
    }
}
