package ui;
import javax.swing.*;
import java.awt.*;
import sistema.SistemaAluguel;
import Tipos.*;

public class TelaMain extends JFrame {
    private SistemaAluguel sistema = new SistemaAluguel();
private JTextArea area;


public TelaMain() {
setTitle("Sistema de Aluguel de Veiculos");
setSize(600, 400);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());


JPanel topo = new JPanel();
JButton btnCadastrar = new JButton("Cadastrar Carro Exemplo");
JButton btnListar = new JButton("Listar Veículos");
JButton btnAlugar = new JButton("Alugar ID 1");


topo.add(btnCadastrar);
topo.add(btnListar);
topo.add(btnAlugar);
add(topo, BorderLayout.NORTH);


area = new JTextArea();
add(new JScrollPane(area), BorderLayout.CENTER);


btnCadastrar.addActionListener(e -> {
sistema.cadastrar(new Carro(1, "Fiat", "Uno", 2010, 120, "manual", 4));
area.append("Carro cadastrado!\n");
});


btnListar.addActionListener(e -> {
area.append("Veiculos \n");
for (Veiculo v : sistema.listar()) {
area.append(v.toString() + " | Disponivel=" + v.isDisponivel() + "\n");
}
});


btnAlugar.addActionListener(e -> {
try {
sistema.alugar(1);
area.append("Veiculo alugado!\n");
} catch (Exception ex) {
area.append("ERROR: " + ex.getMessage() + "\n");
}
});
}
}