public interface VeiculoDAO {
    boolean insert(Veiculo veiculo);
    boolean update(Veiculo veiculo);
    boolean delete(int id);
    Veiculo select(int id);
    
    java.util.List<Veiculo> selectAll();
}