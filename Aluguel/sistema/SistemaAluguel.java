package sistema;
import dao.VDList;
import Tipos.*;
import java.util.List;

public class SistemaAluguel {
private VDList dao;                   

public SistemaAluguel() { dao = new VDList(); }

public void cadastrar(Veiculo v) { dao.insert(v); }


public void alugar(int id) throws IndisponivelException {
Veiculo v = dao.select(id);
if (v == null) throw new IndisponivelException("Veiculo nao encontrado!");
if (!v.isDisponivel()) throw new IndisponivelException("Veiculo ja esta alugado!");
v.setDisponivel(false);
}


public List<Veiculo> listar() { return dao.getAll(); }
}
