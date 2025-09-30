package ar.edu.unahur.obj2.filters;

import java.util.List;

import ar.edu.unahur.obj2.model.Pais;

public class FiltroAnd extends FiltroCompuesto {
    public FiltroAnd(List<IFiltro> filtros) {
        super(filtros);
    }

    public FiltroAnd(IFiltro filtro1, IFiltro filtro2) {
        super(List.of(filtro1, filtro2));
    }

    @Override
    public boolean cumple(Pais pais) {
        return filtros.stream().allMatch(filtro -> filtro.cumple(pais));
    }

    @Override
    public IFiltro or(IFiltro otroFiltro) {
        return new FiltroOr(List.of(this, otroFiltro));
    }

}
