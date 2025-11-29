package Tipos;

public class Caminhonete extends Veiculo {
private double capacidade;
private int assentos;

public Caminhonete(int id, String marca, String modelo, int ano, double preco, String cambio, double capacidade, int assentos) {
super(id, marca, modelo, ano, preco, cambio);
this.capacidade = capacidade;
this.assentos = assentos;
}

public int getAssentos() { return assentos; }
public double getcapacidade() { return capacidade; }

@Override
public String getTipo() { return "Caminhonete"; }

}