package uff.ic.lleme.tcc00328.s20212.prova.p1.ArthurAlves;

public class Prato {
    
    private String nomeDoPrato;
    private Float precoDoPrato;
    
    public Prato(String nomeDoPrato, Float precoDoPrato){
        this.nomeDoPrato = nomeDoPrato;
        this.precoDoPrato = precoDoPrato;
    }
    /**
     * @return the nomeDoPrato
     */
    public String getNomeDoPrato() {
        return nomeDoPrato;
    }

    /**
     * @param nomeDoPrato the nomeDoPrato to set
     */
    public void setNomeDoPrato(String nomeDoPrato) {
        this.nomeDoPrato = nomeDoPrato;
    }

    /**
     * @return the precoDoPrato
     */
    public Float getPrecoDoPrato() {
        return precoDoPrato;
    }

    /**
     * @param precoDoPrato the precoDoPrato to set
     */
    public void setPrecoDoPrato(Float precoDoPrato) {
        this.precoDoPrato = precoDoPrato;
    }
       
}

