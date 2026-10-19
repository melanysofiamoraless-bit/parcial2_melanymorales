package plataforma;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    private String nombre;
    private ArrayList<Experimento> experimentos;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.experimentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Experimento> getExperimentos() {
        return experimentos;
    }

    public void agregarExperimento(Experimento e) {
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

    public List<String> reporteMejorLoss() {
        List<String> reporte = new ArrayList<>();
        for (int i = 0; i < experimentos.size(); i++) {
            Experimento e = experimentos.get(i);
            int mejor = 0;
            if (e.getModelo() != null) {
                mejor = e.getModelo().mejorLoss();
            }
            reporte.add(e.getId() + ": " + mejor);
        }
        return reporte;
    }
}