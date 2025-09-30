package ar.edu.unahur.obj2.filters;

import ar.edu.unahur.obj2.model.Pais;

public class FiltroIsla extends Filtro {
    @Override
    public boolean cumple(Pais pais) {
        return pais.esIsla();
    }

}
