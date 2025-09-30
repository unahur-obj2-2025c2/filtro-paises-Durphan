package ar.edu.unahur.obj2.filters;

import java.util.List;

import ar.edu.unahur.obj2.model.Pais;

public class FiltroOr extends FiltroCompuesto {
    public FiltroOr(List<IFiltro> filtros) {
        super(filtros);
    }

    public FiltroOr(IFiltro filtro1, IFiltro filtro2) {
        super(List.of(filtro1, filtro2));
    }

    @Override
    public boolean cumple(Pais pais) {
        return filtros.stream().anyMatch(filtro -> filtro.cumple(pais));
    }

    @Override
    public IFiltro and(IFiltro otroFiltro) {
        return new FiltroAnd(this, otroFiltro);
    }
}
