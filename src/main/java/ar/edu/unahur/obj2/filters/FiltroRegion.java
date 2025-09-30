package ar.edu.unahur.obj2.filters;

import ar.edu.unahur.obj2.model.Pais;

public class FiltroRegion extends Filtro {
    private String region;

    public FiltroRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean cumple(Pais pais) {
        return pais.getRegion().equals(region);
    }

}
