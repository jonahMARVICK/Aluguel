package Tipos;

public class Van extends Veiculo {
private int assentos;

public Van(int id, String marca, String modelo, int ano, double preco, String cambio, int assentos) {
super(id, marca, modelo, ano, preco, cambio);
this.assentos = assentos;
}

public int getAssentos() { return assentos; }

@Override
public String getTipo() { return "Vanm"; }

}