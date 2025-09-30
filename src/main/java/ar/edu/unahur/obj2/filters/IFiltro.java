package ar.edu.unahur.obj2.filters;

import ar.edu.unahur.obj2.model.Pais;

public interface IFiltro {
    boolean cumple(Pais pais);

    IFiltro and(IFiltro otroFiltro);

    IFiltro or(IFiltro otroFiltro);
}
