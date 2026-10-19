package servicios;

import modelos.Modelo;

public class MetricaEvaluacion {
    public double calcular(Modelo modelo, String nombreMetrica) {
        if (modelo == null) {
            return 0.0;
        }
        if (modelo.mejorLoss() == Integer.MAX_VALUE) {
            return 0.0;
        }
        return 100.0 / (1.0 + modelo.mejorLoss());
    }
}