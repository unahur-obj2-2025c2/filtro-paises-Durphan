package ar.edu.unahur.obj2.filters;

import ar.edu.unahur.obj2.model.Pais;

public class FiltroNombre extends Filtro {
    private String nombre;

    public FiltroNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean cumple(Pais pais) {
        return pais.getNombre().equalsIgnoreCase(nombre);
    }

}
