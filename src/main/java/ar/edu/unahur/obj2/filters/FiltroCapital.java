package ar.edu.unahur.obj2.filters;

import ar.edu.unahur.obj2.model.Pais;

public class FiltroCapital extends Filtro {
    private String nombreCapital;

    public FiltroCapital(String nombreCapital) {
        this.nombreCapital = nombreCapital;
    }

    @Override
    public boolean cumple(Pais pais) {
        String paisCapital = pais.getCapital();
        return paisCapital != null && paisCapital.equalsIgnoreCase(nombreCapital);
    }
}
