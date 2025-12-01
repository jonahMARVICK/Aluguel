import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoDAOImpl implements VeiculoDAO {
    
    private List<Veiculo> veiculos = new ArrayList<>();
    private int nextId = 1;

    public VeiculoDAOImpl() {
        Veiculo v1 = new Veiculo(nextId++, "Fiat", "Uno", 2018, 80.0, "ABC-1234", 5, "Vermelho", Veiculo.CategoriaVeiculo.ECONOMICO);
        veiculos.add(v1);
        
        Veiculo v2 = new Veiculo(nextId++, "VW", "Jetta", 2023, 150.0, "DEF-5678", 5, "Preto", Veiculo.CategoriaVeiculo.INTERMEDIARIO);
        veiculos.add(v2);
    }

    @Override
    public boolean insert(Veiculo veiculo) {
        veiculo.id = nextId++;
        return veiculos.add(veiculo);
    }

    @Override
    public boolean update(Veiculo veiculoAtualizado) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getId() == veiculoAtualizado.getId()) {
                veiculos.set(i, veiculoAtualizado);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return veiculos.removeIf(v -> v.getId() == id);
    }

    @Override
    public Veiculo select(int id) {
        Optional<Veiculo> veiculo = veiculos.stream().filter(v -> v.getId() == id).findFirst();
        return veiculo.orElse(null);
    }
    
    @Override
    public List<Veiculo> selectAll() {
        return new ArrayList<>(veiculos);
    }
}