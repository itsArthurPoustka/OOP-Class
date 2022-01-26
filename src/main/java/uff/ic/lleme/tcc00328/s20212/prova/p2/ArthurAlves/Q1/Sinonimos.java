package uff.ic.lleme.tcc00328.s20212.prova.p2.ArthurAlves.Q1;

import java.util.ArrayList;
import java.util.List;

public class Sinonimos {
    
    public String significado;
    public List<Palavra> ListaDePalavras = new ArrayList<>();
    
    public Sinonimos(String significado){
        this.significado = significado;
    }
    
    public Sinonimos(){
        
    }
    
    /**
     * @return the significado
     */
    public String getSignificado() {
        return significado;
    }

    /**
     * @param significado the significado to set
     */
    public void setSignificado(String significado) {
        this.significado = significado;
    }
    
    public void setPalavra(Palavra palavra){
        this.ListaDePalavras.add(palavra);
    }
    
    public Palavra getPalavra(int indice){
        return ListaDePalavras.get(indice);
    }
}
