package ar.edu.unahur.obj2.filters;

public abstract class Filtro implements IFiltro {
    @Override
    public IFiltro and(IFiltro otroFiltro) {
        return new FiltroAnd(this, otroFiltro);
    }

    @Override
    public IFiltro or(IFiltro otroFiltro) {
        return new FiltroOr(this, otroFiltro);
    }
}
