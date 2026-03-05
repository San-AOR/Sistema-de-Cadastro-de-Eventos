import java.time.LocalDate;
import java.time.LocalTime;

public class Evento implements Comparable<Evento> {

    private String nome;
    private String endereco;
    private String categoria;
    private String descricao;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public Evento(String nome, String endereco, String categoria,
                  String descricao, LocalDate data,
                  LocalTime horaInicio, LocalTime horaFim) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.descricao = descricao;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public boolean estaOcorrendoAgora() {
        LocalDate hoje = LocalDate.now();
        LocalTime agora = LocalTime.now();
        return hoje.equals(data) &&
                agora.isAfter(horaInicio) &&
                agora.isBefore(horaFim);
    }

    public boolean jaOcorreu() {
        return LocalDate.now().isAfter(data);
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public int compareTo(Evento outro) {
        return this.data.compareTo(outro.data);
    }

    @Override
    public String toString() {
        return "\nEvento: " + nome +
                "\nCategoria: " + categoria +
                "\nEndereço: " + endereco +
                "\nData: " + data +
                "\nHorário: " + horaInicio + " às " + horaFim +
                "\nDescrição: " + descricao + "\n";
    }
}