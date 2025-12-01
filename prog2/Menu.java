import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    
    private static VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcao = -1;
        
        System.out.println("Sistema de Locação de Veículos");
        
        do {
            try {
                exibirMenu();
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt();
                sc.nextLine();
                
                switch (opcao) {
                    case 1: inserirVeiculo(); break;
                    case 2: alterarVeiculo(); break;
                    case 3: consultarVeiculo(); break;
                    case 4: excluirVeiculo(); break;
                    case 5: alugarVeiculo(); break; 
                    case 6: listarVeiculos(); break;
                    case 0: System.out.println("Encerrando o sistema..."); break;
                    default: System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nERRO: Entrada inválida. Digite um número para a opção.");
                sc.nextLine();
                opcao = -1;
            } catch (Exception e) {
                System.out.println("\nERRO inesperado: " + e.getMessage());
            }
            
            
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("1. Inserir Novo Veículo");     
        System.out.println("2. Alterar Detalhes do Veículo");     
        System.out.println("3. Consultar Veículo por ID");
        System.out.println("4. Excluir Veículo por ID");  
        System.out.println("5. Realizar Aluguel"); 
        System.out.println("6. Listar Todos os Veículos");
        System.out.println("0. Sair");
    }

    private static void listarVeiculos() {
        System.out.println("\nVEÍCULOS CADASTRADOS");
        List<Veiculo> veiculos = veiculoDAO.selectAll();
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        veiculos.forEach(System.out::println);
    }
    
    private static void inserirVeiculo() {
        System.out.println("\nINSERIR NOVO VEÍCULO");
        try {
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            System.out.print("Modelo: ");
            String modelo = sc.nextLine();
            System.out.print("Ano de Fabricação: ");
            int ano = sc.nextInt();
            sc.nextLine();
            System.out.print("Placa: ");
            String placa = sc.nextLine();
            System.out.print("Número de Passageiros: ");
            int passageiros = sc.nextInt();
            sc.nextLine();
            System.out.print("Cor: ");
            String cor = sc.nextLine();
            System.out.print("Diária Base (Ex: 100.00): ");
            double diariaBase = sc.nextDouble();
            sc.nextLine();
            
            System.out.println("\n Categoria");
            System.out.println("1. ECONOMICO");
            System.out.println("2. INTERMEDIARIO");
            System.out.println("3. LUXO");
            int catOpcao = sc.nextInt();
            sc.nextLine();
            
            Veiculo.CategoriaVeiculo categoria;
            switch (catOpcao) {
                case 1:
                    categoria = Veiculo.CategoriaVeiculo.ECONOMICO;
                    break;
                case 2:
                    categoria = Veiculo.CategoriaVeiculo.INTERMEDIARIO;
                    break;
                case 3:
                    categoria = Veiculo.CategoriaVeiculo.LUXO;
                    break;
                default:
                    throw new DominioException("Opção de categoria inválida.");
            }
            
            if (passageiros <= 0 || diariaBase <= 0) { 
                throw new DominioException("Passageiros e Diária Base devem ser valores positivos!");
            }
            
            Veiculo novoVeiculo = new Veiculo(0, marca, modelo, ano, diariaBase, placa, passageiros, cor, categoria);
            
            if (veiculoDAO.insert(novoVeiculo)) {
                System.out.println("\nVeículo inserido com sucesso! ID: " + novoVeiculo.getId() + " | Categoria: " + categoria);
            } else {
                System.out.println("\nFalha ao inserir o veículo.");
            }
        } catch (DominioException e) {
            System.err.println("ERRO de Domínio: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("ERRO de entrada. Certifique-se de digitar números onde solicitado.");
            sc.nextLine();
        }
    }

    private static void alterarVeiculo() {
        System.out.println("\n ALTERAR VEÍCULO");
        System.out.print("ID do Veículo a alterar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Veiculo veiculo = veiculoDAO.select(id);
        if (veiculo == null) {
            System.out.println("Veículo com ID " + id + " não encontrado.");
            return;
        }

        System.out.println("Veículo atual: " + veiculo);
        System.out.print("Nova Placa (deixe em branco para manter '" + veiculo.getPlaca() + "'): ");
        String novaPlaca = sc.nextLine();
        if (!novaPlaca.isEmpty()) {
            veiculo.setPlaca(novaPlaca);
        }

        if (veiculoDAO.update(veiculo)) {
            System.out.println("Veículo alterado com sucesso!");
        } else {
            System.out.println("Falha ao alterar o veículo.");
        }
    }

    private static void consultarVeiculo() {
        System.out.println("\nCONSULTAR VEÍCULO");
        System.out.print("ID do Veículo a consultar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Veiculo veiculo = veiculoDAO.select(id);
        if (veiculo != null) {
            System.out.println("\nDETALHES DO VEÍCULO");
            System.out.println(veiculo);
        } else {
            System.out.println("Veículo com ID " + id + " não encontrado.");
        }
    }

    private static void excluirVeiculo() {
        System.out.println("\nEXCLUIR VEÍCULO");
        System.out.print("ID do Veículo a excluir: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (veiculoDAO.delete(id)) {
            System.out.println(" Veículo com ID " + id + " excluído com sucesso!");
        } else {
            System.out.println(" Veículo com ID " + id + " não encontrado ou falha na exclusão.");
        }
    }

    private static void alugarVeiculo() {
        System.out.println("\nREALIZAR ALUGUEL");
        System.out.print("ID do Veículo a alugar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Veiculo veiculo = veiculoDAO.select(id);
        try {
            if (veiculo == null) {
                throw new DominioException("Veículo não encontrado.");
            }
            if (veiculo.isAlugado()) {
                throw new DominioException("O veículo '" + veiculo.getModelo() + "' já está alugado.");
            }

            double diariaFinal = veiculo.calcularDiariaBase();
            veiculo.setAlugado(true);

            if (veiculoDAO.update(veiculo)) {
                System.out.println("\nAluguel de '" + veiculo.getModelo() + "' realizado com sucesso!");
                System.out.println("   Categoria: " + veiculo.getCategoria());
                System.out.println("   Valor da diária (com taxa): R$" + String.format("%.2f", diariaFinal));
            } else {
                throw new DominioException("Falha ao atualizar o status de aluguel.");
            }
        } catch (DominioException e) {
            System.err.println("ERRO de Aluguel: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("ERRO de entrada. Certifique-se de digitar um ID numérico.");
            sc.nextLine();
        }
    }
}