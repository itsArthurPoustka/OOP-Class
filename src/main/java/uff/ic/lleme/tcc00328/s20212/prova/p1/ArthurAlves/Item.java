package uff.ic.lleme.tcc00328.s20212.prova.p1.ArthurAlves;

public class Item {
    
    private Prato pratoPedido;
    private Integer qtdDoPrato;
    
    public Item(Prato pratoPedido, Integer qtdDoPrato){
        this.pratoPedido = pratoPedido;
        this.qtdDoPrato = qtdDoPrato;
    }
    
    /**
     * @return the pratoPedido
     */
    public Prato getPratoPedido() {
        return pratoPedido;
    }

    /**
     * @param pratoPedido the pratoPedido to set
     */
    public void setPratoPedido(Prato pratoPedido) {
        this.pratoPedido = pratoPedido;
    }

    /**
     * @return the qtdDoPrato
     */
    public Integer getQtdDoPrato() {
        return qtdDoPrato;
    }

    /**
     * @param qtdDoPrato the qtdDoPrato to set
     */
    public void setQtdDoPrato(Integer qtdDoPrato) {
        this.qtdDoPrato = qtdDoPrato;
    }
}
