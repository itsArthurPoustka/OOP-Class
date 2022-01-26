package uff.ic.lleme.tcc00328.s20212.prova.p2.ArthurAlves.Q1;

import java.util.ArrayList;
import java.util.List;

public class Palavra {
    
    public String fonetica;
    public String grafia;
    public List<Sinonimos> listaDeSinonimos = new ArrayList<>();
    
    public Palavra(String fonetica, String grafia){
        this.fonetica = fonetica;
        this.grafia = grafia;
    }
    public Palavra(){
        
    }
    public int getQtdSignificados(){
        return this.listaDeSinonimos.size();
    }
    
    /**
     * @return the fonetica
     */
    public String getFonetica() {
        return fonetica;
    }

    /**
     * @param fonetica the fonetica to set
     */
    public void setFonetica(String fonetica) {
        this.fonetica = fonetica;
    }

    /**
     * @return the grafia
     */
    public String getGrafia() {
        return grafia;
    }

    /**
     * @param grafia the grafia to set
     */
    public void setGrafia(String grafia) {
        this.grafia = grafia;
    }
    
    public String getSignificado(int indice){
        return this.listaDeSinonimos.get(indice).getSignificado();
    }

    public Sinonimos getSinonimos(int indice){
        return this.listaDeSinonimos.get(indice);
    }
    public void criaNovoSinonimo(String significadoAtual){
        Sinonimos sinonimoNovo = new Sinonimos(significadoAtual);
        this.listaDeSinonimos.add(sinonimoNovo);
    }
    public void setSinonimo(Sinonimos sinonimoAtual){
        this.listaDeSinonimos.add(sinonimoAtual);
    }
}
