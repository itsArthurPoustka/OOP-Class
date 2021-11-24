package uff.ic.lleme.tcc00328.s20212.prova.p1.ArthurAlves;

public class Pedido {
    
    private Item[] itens;
    
    public Pedido(int qtdDeItens){
        this.itens = new Item[qtdDeItens];
    }
    
    /**
     * @return the itens
     */
    public Item[] getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(Item[] itens) {
        this.itens = itens;
    }
}
