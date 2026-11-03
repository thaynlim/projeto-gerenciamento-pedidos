package cardapio;

public class ComBaconExtra implements ItensCardapio{
        private ItensCardapio iC;
        public ComBaconExtra (ItensCardapio iC){
            this.iC = iC;
        }
        @Override
        public String getDescricao(){
            return iC.getDescricao() + " + bacon extra";
        }
        @Override
        public double getPreco(){
            return iC.getPreco() + 6.00;
        }
    }

