package uff.ic.lleme.tcc00328.s20212.prova.p2.ArthurAlves.Q2;

import java.util.ArrayList;
import java.util.List;
import static java.util.concurrent.ForkJoinTask.invokeAll;
import java.util.concurrent.RecursiveAction;

public class ForkMean extends RecursiveAction {

    private int inicio = 0;
    private int fim = 0;
    private static double somaAtual;
    private List<Double> valores = new ArrayList<>();
    protected static int jobSize = 1000;

    public ForkMean(List<Double> valores, double somaAtual) {
        this.valores = valores;
        this.inicio = 0;
        this.fim = valores.size();
        this.somaAtual = somaAtual;
    }

    private ForkMean(List<Double> valores, int inicio, int fim, double somaAtual) {
        this.valores = valores;
        this.inicio = inicio;
        this.fim = fim;
        this.somaAtual = somaAtual;
    }

    protected void computeDirectly() {
        double somaParcial = 0f;
        for (int i = inicio; i < fim; i++) {
            somaParcial += valores.get(i);
        }
        setSomaAtual(getSomaAtual() + somaParcial);
    }

    @Override
    protected void compute() {
        if (fim - inicio < jobSize)
            computeDirectly();
        else {
            int meio = (inicio + fim) / 2;
            invokeAll(new ForkMean(valores, inicio, meio, getSomaAtual()),
                    new ForkMean(valores, meio, fim, getSomaAtual()));
        }
    }

    /**
     * @return the somaAtual
     */
    public static double getSomaAtual() {
        return somaAtual;
    }

    /**
     * @param aSomaAtual the somaAtual to set
     */
    public static void setSomaAtual(double aSomaAtual) {
        somaAtual = aSomaAtual;
    }
}
