package cardapio;

public class ComCheddar implements ItensCardapio{
    private ItensCardapio iC;
    public ComCheddar (ItensCardapio iC){
        this.iC = iC;
    }
    @Override
    public String getDescricao(){
        return iC.getDescricao() + " + cheddar";
    }
    @Override
    public double getPreco(){
        return iC.getPreco() + 4.00;
    }
}
