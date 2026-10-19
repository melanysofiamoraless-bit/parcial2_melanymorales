package modelos;

public class ModeloRNN extends Modelo {
    private int numCapas;

    public ModeloRNN(String nombre, int maxEpocas, int numCapas) {
        super(nombre, maxEpocas);
        this.numCapas = numCapas;
    }

    public int getNumCapas() {
        return numCapas;
    }

    @Override
    public double entrenar(Object d) {
        registrarEpoca(10);
        return mejorLoss();
    }
}