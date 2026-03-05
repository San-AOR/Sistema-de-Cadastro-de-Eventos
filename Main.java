import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CADASTRO DE USUÁRIO ===");
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        Usuario usuario = new Usuario(nome, email, telefone);
        SistemaEventos sistema = new SistemaEventos();

        // Evento fixo da Feira EcoSolidária
        Evento feira = new Evento(
                "Feira EcoSolidária",
                "Rua Ângela Mirella, 500 - Parque Dom José - Barueri",
                "Sustentabilidade",
                "Venda de orgânicos e artesanato sustentável.",
                LocalDate.now().plusDays(1),
                LocalTime.of(10, 0),
                LocalTime.of(14, 0)
        );
        sistema.cadastrarEvento(feira);

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Listar eventos");
            System.out.println("2 - Confirmar participação");
            System.out.println("3 - Ver meus eventos");
            System.out.println("4 - Cancelar participação");
            System.out.println("5 - Cadastrar novo evento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    sistema.listarEventos();
                    break;

                case 2:
                    List<Evento> lista = sistema.getListaEventos();
                    if (lista.isEmpty()) {
                        System.out.println("Não há eventos cadastrados.");
                        break;
                    }

                    System.out.println("\n=== SELECIONE O EVENTO PARA PARTICIPAR ===");
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println((i + 1) + " - " + lista.get(i).getNome());
                    }
                    System.out.print("Número do evento: ");
                    int escolha = sc.nextInt();
                    sc.nextLine();

                    if (escolha >= 1 && escolha <= lista.size()) {
                        usuario.confirmarEvento(lista.get(escolha - 1));
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    System.out.println("\n=== MEUS EVENTOS CONFIRMADOS ===");
                    if (usuario.getEventosConfirmados().isEmpty()) {
                        System.out.println("Nenhum evento confirmado.");
                    } else {
                        for (Evento e : usuario.getEventosConfirmados()) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 4:
                    List<Evento> confirmados = usuario.getEventosConfirmados();
                    if (confirmados.isEmpty()) {
                        System.out.println("Você não confirmou nenhum evento.");
                        break;
                    }

                    System.out.println("\n=== SELECIONE O EVENTO PARA CANCELAR ===");
                    for (int i = 0; i < confirmados.size(); i++) {
                        System.out.println((i + 1) + " - " + confirmados.get(i).getNome());
                    }
                    System.out.print("Número do evento: ");
                    int cancel = sc.nextInt();
                    sc.nextLine();

                    if (cancel >= 1 && cancel <= confirmados.size()) {
                        usuario.cancelarEvento(confirmados.get(cancel - 1));
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 5:
                    System.out.println("Nome do evento:");
                    String nomeEvento = sc.nextLine();

                    System.out.println("Endereço:");
                    String endereco = sc.nextLine();

                    System.out.println("Categoria:");
                    String categoria = sc.nextLine();

                    System.out.println("Descrição:");
                    String descricao = sc.nextLine();

                    System.out.println("Data (AAAA-MM-DD):");
                    LocalDate data = LocalDate.parse(sc.nextLine());

                    System.out.println("Hora início (HH:MM):");
                    LocalTime horaInicio = LocalTime.parse(sc.nextLine());

                    System.out.println("Hora fim (HH:MM):");
                    LocalTime horaFim = LocalTime.parse(sc.nextLine());

                    Evento novoEvento = new Evento(
                            nomeEvento, endereco, categoria,
                            descricao, data, horaInicio, horaFim
                    );

                    sistema.cadastrarEvento(novoEvento);
                    System.out.println("Evento cadastrado com sucesso!");
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
