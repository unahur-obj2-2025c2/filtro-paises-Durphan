package ar.edu.unahur.obj2.filters;

import ar.edu.unahur.obj2.model.Pais;

public class FiltroPoblacionMenor extends Filtro {
    private int poblacionMaxima;

    public FiltroPoblacionMenor(int poblacionMaxima) {
        this.poblacionMaxima = poblacionMaxima;
    }

    @Override
    public boolean cumple(Pais pais) {
        return pais.getPoblacion() < poblacionMaxima;
    }

}
