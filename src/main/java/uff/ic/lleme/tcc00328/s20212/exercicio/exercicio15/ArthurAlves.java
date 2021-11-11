
package uff.ic.lleme.tcc00328.s20212.exercicio.exercicio15;

public class ArthurAlves {
    public static void main(String[] args) {
        
        float categorias[] = {0f, 2f, 2.3f, 4.6f, 5.0f, 10f};
        float nums[] = {-1f, 2f, 2.7f, 1f, 0.2f, 4.8f, 4.4f, 8f, 10f};
        float[] vetor_histograma = new float[categorias.length-1];
        
        vetor_histograma = histograma(nums, categorias);
        
        for (int p = 0; p < vetor_histograma.length; p++){
            System.out.println("Categoria "+(p+1)+':');
            System.out.printf("%g por cento do vetor.\n", (vetor_histograma[p]*100));
        } 
    }
    
    public static float[] histograma(float[] numeros, float[] categorias){
        
        int qtd_categs = categorias.length - 1;
        float[] vetor_hist = new float[qtd_categs]; // vetor para retorno
        int categoria_atual;
        // percorre os numeros pegando as categorias relacionadas
        for (int j = 0; j < numeros.length; j++){
            
            categoria_atual = categoria(numeros[j], categorias);
            
            if (categoria_atual == -1)
                continue;
            else{
                vetor_hist[categoria_atual-1] += 1;                
            }    
        }
        // transforma em porcentagem de ocorrencias 
        for (int k = 0; k < qtd_categs; k++){
            
            vetor_hist[k] = vetor_hist[k]/numeros.length;
        }
        
        return vetor_hist;
    }
    
    public static int categoria(float numero, float [] categs){
        
        int tam_vetor = categs.length;
        int categ_atual = 0;
        // checa se esta fora das categorias
        if (numero > categs[tam_vetor-1])
            categ_atual = -1;
        // checa se esta fora das categorias 
        else if (numero < categs[0])
            categ_atual = -1;
        
        else{
            for (int i = 0; i < tam_vetor-1; i++){                
                // checando se eh a ultima categoria
                if ((numero >= categs[tam_vetor-2]) && (numero <= categs[tam_vetor-1])){
                    categ_atual = tam_vetor-1;
                    break;
                // checando se eh uma categoria comum
                }else if((numero >= categs[i]) && (numero < categs[i+1])){
                        categ_atual = i+1;
                        break;
                }
            }
        }
        return categ_atual;
    } 
}
