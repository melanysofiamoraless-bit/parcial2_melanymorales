package plataforma;

import modelos.*;

public class Experimento {
    private String id;
    private Modelo modelo;

    public Experimento(String id, String tipoModelo, int maxEpocas) {
        this.id = id;

        if (tipoModelo.equals("CNN")) {
            this.modelo = new ModeloCNN("CNN", maxEpocas, 16);
        } else if (tipoModelo.equals("RNN")) {
            this.modelo = new ModeloRNN("RNN", maxEpocas, 2);
        } else if (tipoModelo.equals("REGRESION")) {
            this.modelo = new ModeloRegresion("Regresion", maxEpocas, 1);
        } else {
            this.modelo = null;
        }
    }

    public String getId() {
        return id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public double ejecutar(Object d) {
        if (modelo != null) {
            return modelo.entrenar(d);
        }
        return 0.0;
    }
}