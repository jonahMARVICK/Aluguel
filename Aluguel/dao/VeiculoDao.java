package dao;
import Tipos.Veiculo;

public interface VeiculoDao {
boolean insert(Veiculo v);
boolean update(Veiculo v);
boolean delete(int id);
Veiculo select(int id);
  
}
