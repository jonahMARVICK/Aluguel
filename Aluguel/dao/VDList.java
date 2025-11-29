package dao;
import Tipos.Veiculo;
import java.util.*;

public class VDList implements VeiculoDao {
private List<Veiculo> lista = new ArrayList<>();


@Override
public boolean insert(Veiculo v) { return lista.add(v); }


@Override
public boolean update(Veiculo v) {
for (int i = 0; i < lista.size(); i++) {
if (lista.get(i).getId() == v.getId()) {
lista.set(i, v);
return true;
}
}
return false;
}


@Override
public boolean delete(int id) { return lista.removeIf(v -> v.getId() == id); }


@Override
public Veiculo select(int id) {
for (Veiculo v : lista) if (v.getId() == id) return v;
return null;
}


public List<Veiculo> getAll() { return lista; }
}