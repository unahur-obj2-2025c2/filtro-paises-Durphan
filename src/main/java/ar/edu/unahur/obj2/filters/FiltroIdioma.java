package ar.edu.unahur.obj2.filters;

import ar.edu.unahur.obj2.model.Pais;

public class FiltroIdioma extends Filtro {
    private String idioma;

    public FiltroIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public boolean cumple(Pais pais) {
        return pais.getIdiomas().stream().anyMatch(idiomaPais -> idiomaPais.equalsIgnoreCase(idioma));
    }

}
