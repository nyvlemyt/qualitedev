package moitest;
import moi.*;
import bintaservice.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestTout {

    private service service;
    private Voiture voiture1;
    private Voiture voiture2;
    private Voiture voiture3;
    private Voiture voiture4;
    private Voiture voiture5;
    private Voiture voiture6;
    private Voiture voitureTest;

    @BeforeEach
    void setUp() {
        service = new service();
        voiture1 = new Voiture("Bugatti", 10000);
        voiture2 = new Voiture("Ferrari", 20000);
        voiture3 = new Voiture("Lamborghini", 30000);
        voiture4 = new Voiture("Rolls-Royce", 40000);
        voiture5 = new Voiture("Bentley", 50000);
        voiture6 = new Voiture("Aston Martin", 60000);
        voitureTest = new Voiture("Porsche", 15000);
    }

    @Test
    void testAjouter() {
        service.ajouter(voiture1);
        assertEquals(1, service.getListeVoiture().size());
        assertTrue(service.getListeVoiture().contains(voiture1));
    }



    @Test
    void testPrixListeVide() {
        assertThrows(ArithmeticException.class, () -> {
            service.prix();
        });
    }

    @Test
    void testPrixSansRemise() {
        service.ajouter(voiture1);
        service.ajouter(voiture2);
        service.ajouter(voiture3);
        service.ajouter(voiture4);
        assertEquals(100000, service.prix());
    }

    @Test
    void testPrixAvecRemise() {
        service.ajouter(voiture1);
        service.ajouter(voiture2);
        service.ajouter(voiture3);
        service.ajouter(voiture4);
        service.ajouter(voiture5);
        assertEquals(142500, service.prix());
    }

    @Test
    void testPrixAvecRemiseMaximale() {
        service.ajouter(voiture1);
        service.ajouter(voiture2);
        service.ajouter(voiture3);
        service.ajouter(voiture4);
        service.ajouter(voiture5);
        service.ajouter(voiture6);
        assertEquals(199500, service.prix());
    }

    @Test
    void testSetListeVoiture() {
        ArrayList<Voiture> maListe = new ArrayList<>();
        maListe.add(voiture1);
        service.setListeVoiture(maListe);
        assertEquals(1, service.getListeVoiture().size());
        assertTrue(service.getListeVoiture().contains(voiture1));
    }

    @Test
    void testToStringService() {
        service.ajouter(voiture1);
        String s = "service{listeVoiture=[Voiture{marque='Bugatti', prix=10000.0}]}";
        assertEquals(s, service.toString());
    }


    @Test
    void testGetMarqueVoiture() {
        assertEquals("Porsche", voitureTest.getMarque());
    }

    @Test
    void testGetPrixVoiture() {
        assertEquals(15000, voitureTest.getPrix());
    }

    @Test
    void testSetMarqueVoiture() {
        voitureTest.setMarque("NouvelleMarque");
        assertEquals("NouvelleMarque", voitureTest.getMarque());
    }

    @Test
    void testSetPrixVoiture() {
        voitureTest.setPrix(20000);
        assertEquals(20000, voitureTest.getPrix());
    }

    @Test
    void testToStringVoiture() {
        String s = "Voiture{marque='Porsche', prix=15000.0}";
        assertEquals(s, voitureTest.toString());
    }

}
