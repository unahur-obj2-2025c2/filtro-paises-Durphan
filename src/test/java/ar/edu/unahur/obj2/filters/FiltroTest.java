package ar.edu.unahur.obj2.filters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.model.Pais;
import ar.edu.unahur.obj2.service.IPaisService;
import ar.edu.unahur.obj2.service.PaisService;

class FiltroTest {
    IPaisService paisService = new PaisService();
    List<Pais> paises;

    @BeforeEach
    void init() {
        paises = paisService.getPaises();
    }

    @Test
    void recibeListaDePaises() {
        assertNotNull(paises);
    }

    @Test
    void fltrarPaisPorNombre() {
        IFiltro filtro = new FiltroNombre("Argentina");
        List<Pais> paisesFiltrados = paises.stream().filter(filtro::cumple).toList();
        assertEquals(1, paisesFiltrados.size());
        assertEquals("Argentina", paisesFiltrados.get(0).getNombre());
    }

    @Test
    void filtrarPaisPorCapital() {
        IFiltro filtro = new FiltroCapital("Buenos Aires");
        List<Pais> paisesFiltrados = paises.stream().filter(filtro::cumple).toList();
        assertEquals(1, paisesFiltrados.size());
        assertEquals("Argentina", paisesFiltrados.get(0).getNombre());
    }

    @Test
    void filtrarPaisPorIdioma() {
        IFiltro filtro = new FiltroIdioma("spanish");
        List<Pais> paisesFiltrados = paises.stream().filter(filtro::cumple).toList();
        assertEquals(24, paisesFiltrados.size());
        assertTrue(paisesFiltrados.stream().flatMap(p -> p.getIdiomas().stream())
                .anyMatch(idioma -> idioma.equalsIgnoreCase("spanish")));
    }

    @Test
    void filtrarPaisPorRegion() {
        IFiltro filtro = new FiltroRegion("Americas");
        List<Pais> paisesFiltrados = paises.stream().filter(filtro::cumple).toList();
        assertEquals(57, paisesFiltrados.size());
        assertTrue(paisesFiltrados.stream().allMatch(p -> p.getRegion().equalsIgnoreCase("Americas")));
    }

    @Test
    void japonEsUnaIsla() {
        IFiltro filtro = new FiltroIsla();
        List<Pais> paisesFiltrados = paises.stream().filter(filtro::cumple).toList();
        assertEquals(85, paisesFiltrados.size());
        assertTrue(paisesFiltrados.stream().anyMatch(pais -> pais.getNombre().equals("Japan")));
    }

    @Test
    void filtrarPorPoblacionMenor() {
        IFiltro filtro = new FiltroPoblacionMenor(1000000);
        List<Pais> paisesFiltrados = paises.stream().filter(filtro::cumple).toList();
        assertEquals(90, paisesFiltrados.size());
        assertTrue(paisesFiltrados.stream().allMatch(pais -> pais.getPoblacion() < 1000000));
    }

    @Test
    void filtrarPaisPorArea() {
        IFiltro filtro = new FiltroArea(1000000);
        List<Pais> paisesFiltrados = paises.stream().filter(filtro::cumple).toList();
        assertEquals(31, paisesFiltrados.size());
        assertTrue(paisesFiltrados.stream().allMatch(pais -> pais.getArea() >= 1000000));
    }

    @Test
    void filtrarPaisPorNombreYCapital() {
        IFiltro filtro = new FiltroNombre("Argentina").and(new FiltroCapital("Buenos Aires"));
        List<Pais> paisesFiltrados = paises.stream().filter(filtro::cumple).toList();
        assertEquals(1, paisesFiltrados.size());
        assertEquals("Argentina", paisesFiltrados.get(0).getNombre());
        assertEquals("Buenos Aires", paisesFiltrados.get(0).getCapital());
    }

    @Test
    void filtrarPaisPorNombreOCapital() {
        IFiltro filtro = new FiltroNombre("Argentina").or(new FiltroCapital("Ottawa"));
        List<Pais> paisesFiltrados = paises.stream().filter(filtro::cumple).toList();
        assertEquals(2, paisesFiltrados.size());
        assertTrue(paisesFiltrados.stream().anyMatch(pais -> pais.getNombre().equals("Argentina")));
        assertTrue(paisesFiltrados.stream().anyMatch(pais -> pais.getCapital().equals("Ottawa")));
    }

}
