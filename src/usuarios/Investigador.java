package usuarios;

import plataforma.Experimento;
import java.util.ArrayList;

public class Investigador {
    private String nombre;
    private ArrayList<Experimento> experimentos;

    public Investigador(String nombre) {
        this.nombre = nombre;
        this.experimentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Experimento> getExperimentos() {
        return experimentos;
    }

    public void asociarExperimento(Experimento e) {
        if (e != null) {
            boolean yaExiste = false;
            for (int i = 0; i < experimentos.size(); i++) {
                if (experimentos.get(i) == e) {
                    yaExiste = true;
                }
            }
            if (!yaExiste) {
                experimentos.add(e);
            }
        }
    }
}