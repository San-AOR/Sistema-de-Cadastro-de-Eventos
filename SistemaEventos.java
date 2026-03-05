import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SistemaEventos {

    private List<Evento> listaEventos;

    public SistemaEventos() {
        listaEventos = new ArrayList<>();
    }

    public void cadastrarEvento(Evento evento) {
        listaEventos.add(evento);
    }

    public void listarEventos() {
        Collections.sort(listaEventos);

        for (Evento e : listaEventos) {
            System.out.println(e);

            if (e.estaOcorrendoAgora()) {
                System.out.println(">>> ESTE EVENTO ESTÁ OCORRENDO AGORA!");
            }

            if (e.jaOcorreu()) {
                System.out.println(">>> Evento já ocorreu.");
            }
        }
    }

    public List<Evento> getListaEventos() {
        return listaEventos;
        }
    }


