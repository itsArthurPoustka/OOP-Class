
package uff.ic.lleme.tcc00328.s20212.exercicio.exercicio2;

import java.util.Scanner;

public class ArthurAlves {
    
    public static void main(String[] args) {
        // declarando variaveis
        Scanner leitor = new Scanner(System.in);
        int tam;
        double resultado = 0;
        
        // lendo o tamanho
        System.out.println("Digite o tamanho da matriz quadrada.");
        tam = leitor.nextInt();
        
        // declarando a matriz e lendo 
        float[][] matriz_quadrada = new float[tam][tam];
        
        for (int i = 0; i < tam; i++){
            for (int j = 0; j < tam; j++){
                System.out.println("Escreva o proximo elemento.");
                matriz_quadrada[i][j] =  leitor.nextFloat();
            }  
        }
          
        resultado = determinante(matriz_quadrada);
        System.out.printf("Resultado final: %g", resultado);
        
    }
    
    public static double determinante(float[][] A){
        double det_acumulado = 0;
        
        if (A.length == 1){
            // menor matriz possivel
            return A[0][0];
        }
        else{
            for (int t = 0; t < A.length; t++){
                // implementacao da formula de la place
                det_acumulado += A[0][t]*Math.pow(-1, t+2)*determinante(submatriz(A, 0, t));             
            }
        }
        return det_acumulado;
    }
    
    public static float[][] submatriz(float[][] A, int i, int j){
        
        int tam_atual = A.length;
        float[][] matriz_retorno = new float[tam_atual-1][tam_atual-1]; 
        int lin = 0;
        int col = 0;
        
        for (int z = 0; z < tam_atual; z++){
            col = 0;
            // se a linha for a escolhida, pula
            if (z == i){
                    continue;
                }
 
            for (int x = 0; x < tam_atual; x++){
                // se a coluna for a escolhida, pula 
                if (x == j){
                    continue;
                }
                
                matriz_retorno[lin][col] = A[z][x];
                col++; // att a coluna  
            }      
            lin++; // att a linha
        }  
        return matriz_retorno;
    }
}
