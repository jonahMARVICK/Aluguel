package Tipos;

public abstract class Veiculo {
private int id;
private String marca;
private String modelo;
private int ano;
private double precoDiaria;
private boolean disponivel;
private String cambio;

public Veiculo(int id, String marca, String modelo, int ano, double precoDiaria, String cambio) {
this.id = id;
this.marca = marca;
this.modelo = modelo;
this.ano = ano;
this.precoDiaria = precoDiaria;
this.cambio = cambio;
this.disponivel = true;
}

public abstract String getTipo();

public int getId() { return id; }
public String getMarca() { return marca; }
public String getModelo() { return modelo; }
public int getAno() { return ano; }
public double getPrecoDiaria() { return precoDiaria; }
public boolean isDisponivel() { return disponivel; }
public void setDisponivel(boolean d) { this.disponivel = d; }
public String getCambio() { return cambio; }
public void setCambio(String cambio) { this.cambio = cambio; }

@Override
public String toString() {
return getTipo() + " - " + marca + " " + modelo + " (" + ano + ") R$" + precoDiaria;
}
}