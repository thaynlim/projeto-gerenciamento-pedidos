package cardapio;

public class Lanche implements ItensCardapio {
    private String nome;
    private double preco;
    private boolean queijo = true;
    private boolean alface = true;
    private boolean tomate = true;
    private boolean cebola = true;


    public void setNome (String nome){
        if (nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }
    public void setPreco(double preco){
        if (preco <0){
            throw new IllegalArgumentException("O preço não pode ser negativo");
        }
        this.preco = preco;
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public boolean isQueijo(){
        return queijo;
    }
    public void setQueijo(boolean queijo){
        this.queijo = queijo;
    }
    public boolean isAlface(){
        return alface;
    }
    public void setAlface(boolean alface) {
        this.alface = alface;
    }
    public boolean isTomate() {
        return tomate;
    }
    public void setTomate(boolean tomate) {
        this.tomate = tomate;
    }
    public boolean isCebola() {
        return cebola;
    }
    public void setCebola(boolean cebola) {
        this.cebola = cebola;
    }
    @Override
    public String getDescricao(){
        String descricao = nome;
        if (!queijo) descricao += " sem queijo";
        if (!alface) descricao += " sem alface";
        if (!tomate) descricao += " sem tomate";
        if (!cebola) descricao += " sem cebola";
        return descricao;
    }
    public Lanche (String nome, double preco){
        setNome(nome);
        setPreco(preco);
    }
}
