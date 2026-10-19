package modelos;

public class ModeloCNN extends Modelo {
    private int numFiltros;

    public ModeloCNN(String nombre, int maxEpocas, int numFiltros) {
        super(nombre, maxEpocas);
        this.numFiltros = numFiltros;
    }

    public int getNumFiltros() {
        return numFiltros;
    }

    @Override
    public double entrenar(Object d) {
        registrarEpoca(10);
        return mejorLoss();
    }
}