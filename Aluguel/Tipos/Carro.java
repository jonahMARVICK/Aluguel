package Tipos;

public class Carro extends Veiculo {
private int numeroPortas;

public Carro(int id, String marca, String modelo, int ano, double preco, String cambio, int numeroPortas) {
super(id, marca, modelo, ano, preco, cambio);
this.numeroPortas = numeroPortas;
}

public int getNumeroPortas() { return numeroPortas; }

@Override
public String getTipo() { return "Carro"; }


}