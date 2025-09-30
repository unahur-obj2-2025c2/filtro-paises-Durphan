package ar.edu.unahur.obj2.filters;

import java.util.List;

public abstract class FiltroCompuesto implements IFiltro {
    protected List<IFiltro> filtros;

    protected FiltroCompuesto(List<IFiltro> filtros) {
        this.filtros = filtros;
    }

    public void addFiltro(IFiltro filtro) {
        filtros.add(filtro);
    }

    @Override
    public IFiltro and(IFiltro otroFiltro) {
        return new FiltroAnd(this, otroFiltro);
    }

    @Override
    public IFiltro or(IFiltro otroFiltro) {
        return new FiltroOr(this, otroFiltro);
    }
}
