import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private List<Evento> eventosConfirmados;

    public Usuario(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.eventosConfirmados = new ArrayList<>();
    }
    public void confirmarEvento(Evento evento) {
        eventosConfirmados.add(evento);
        System.out.println("Presença confirmada no evento: " + evento.getNome());
    }
    public void cancelarEvento(Evento evento) {
        eventosConfirmados.remove(evento);
        System.out.println("Participação cancelada no evento: " + evento.getNome());
    }

    public List<Evento> getEventosConfirmados() {
        return eventosConfirmados;
    }
}