package uff.ic.lleme.tcc00328.s20212.prova.p2.ArthurAlves.Q2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class MediaMain {
    
    public static double somaAcumulada = 0f;
    
    public static void main(String[] args){
            
            List<Double> valores = new ArrayList<>();

            for(int i = 0; i < 100000; i++){
                valores.add(Math.random() * 10);
            }

            ForkMean fb = new ForkMean(valores, somaAcumulada);
            ForkJoinPool pool = new ForkJoinPool();

            pool.invoke(fb);
            
            System.out.println("A média calculada é: " + ForkMean.getSomaAtual()/valores.size());

        }
    
}

