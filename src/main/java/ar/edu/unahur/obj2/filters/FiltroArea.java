package ar.edu.unahur.obj2.filters;

import ar.edu.unahur.obj2.model.Pais;

public class FiltroArea extends Filtro {
    private int area;

    public FiltroArea(int area) {
        this.area = area;
    }

    @Override
    public boolean cumple(Pais pais) {
        Integer paisArea = pais.getArea();
        return paisArea != null && paisArea >= area;
    }

}
