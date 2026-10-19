package modelos;

public class ModeloRegresion extends Modelo {
    private int grado;

    public ModeloRegresion(String nombre, int maxEpocas, int grado) {
        super(nombre, maxEpocas);
        this.grado = grado;
    }

    public int getGrado() {
        return grado;
    }

    @Override
    public double entrenar(Object d) {
        registrarEpoca(10);
        return mejorLoss();
    }
}