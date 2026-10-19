package modelos;

import servicios.MetricaEvaluacion;

public abstract class Modelo {
    private String nombre;
    private int[] lossPorEpoca;
    private int epocaActual;
    private int mejorLossRegistrado;

    public Modelo(String nombre, int maxEpocas) {
        this.nombre = nombre;
        this.lossPorEpoca = new int[maxEpocas];
        this.epocaActual = 0;
        this.mejorLossRegistrado = Integer.MAX_VALUE;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getLossPorEpoca() {
        return lossPorEpoca;
    }

    public int getEpocaActual() {
        return epocaActual;
    }

    public int getMejorLossRegistrado() {
        return mejorLossRegistrado;
    }

    public void registrarEpoca(int loss) {
        if (epocaActual < lossPorEpoca.length) {
            lossPorEpoca[epocaActual] = loss;
            epocaActual = epocaActual + 1;
        }
        if (loss < mejorLossRegistrado) {
            mejorLossRegistrado = loss;
        }
    }

    public int mejorLoss() {
        return mejorLossRegistrado;
    }

    public double calcularMetrica(MetricaEvaluacion m) {
        return m.calcular(this, "accuracy");
    }

    public abstract double entrenar(Object d);
}