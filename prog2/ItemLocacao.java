public abstract class ItemLocacao {
    protected int id;
    protected String marca;
    protected String modelo;
    protected int anoFabricacao;
    protected double valorDiariaBase;
    
    public ItemLocacao(int id, String marca, String modelo) { 
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = 0;
        this.valorDiariaBase = 50.0;
    }
    
    public ItemLocacao(int id, String marca, String modelo, int anoFabricacao, double valorDiariaBase) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.valorDiariaBase = valorDiariaBase;
    }
    
    public abstract String getTipoItem();
    
    public int getId() { return id; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAnoFabricacao() { return anoFabricacao; }
    public double getValorDiariaBase() { return valorDiariaBase; }
    
    public void setMarca(String marca) { this.marca = marca; }
    public void setValorDiariaBase(double valorDiariaBase) { this.valorDiariaBase = valorDiariaBase; }

    @Override
    public String toString() {
        return "ID: " + id + ", Marca: " + marca + ", Modelo: " + modelo + 
               ", Ano: " + anoFabricacao + ", Diária Base: R$" + String.format("%.2f", valorDiariaBase);
    }
}