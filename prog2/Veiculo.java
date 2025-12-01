public class Veiculo extends ItemLocacao implements Tarifavel {
    private String placa;
    private int numPassageiros;
    private String cor;
    private boolean alugado;
    private CategoriaVeiculo categoria; 
    
    public enum CategoriaVeiculo {
        ECONOMICO, INTERMEDIARIO, LUXO
    }

    public Veiculo(int id, String marca, String modelo, int ano, double diariaBase, String placa, int passageiros, String cor, CategoriaVeiculo categoria) {
        super(id, marca, modelo, ano, diariaBase);
        this.placa = placa;
        this.numPassageiros = passageiros;
        this.cor = cor;
        this.alugado = false;
        this.categoria = categoria;
    }
    
    @Override
    public String getTipoItem() {
        return "Carro (" + categoria.toString() + ")";
    }

    @Override
    public double calcularDiariaBase() {
        double fator = 1.0;
        switch (this.categoria) {
            case INTERMEDIARIO:
                fator = 1.25;
                break;
            case LUXO:
                fator = 1.75;
                break;
            default:
                fator = 1.0;
        }
        return this.valorDiariaBase * fator;
    }
    
    public String getPlaca() { return placa; }
    public int getNumPassageiros() { return numPassageiros; }
    public String getCor() { return cor; }
    public boolean isAlugado() { return alugado; }
    public CategoriaVeiculo getCategoria() { return categoria; }

    public void setPlaca(String placa) { this.placa = placa; }
    public void setAlugado(boolean alugado) { this.alugado = alugado; }

    @Override
    public String toString() {
        return super.toString() + ", Placa: " + placa + ", Passag.: " + numPassageiros + 
               ", Categoria: " + categoria + ", Alugado: " + (alugado ? "Sim" : "Não") +
               ", Diária Final: R$" + String.format("%.2f", calcularDiariaBase());
    }
}