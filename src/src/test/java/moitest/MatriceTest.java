package moitest;

import moi.Voiture;
import bintaservice.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatriceTest {

    private service service;
    private ArrayList<Voiture> listev;
    private Voiture v1;
    private Voiture v2;
    private Voiture v3;
    private Voiture v4;
    private Voiture v5;
    private Voiture v6;

    @BeforeEach
    void setUp() {
        service = new service();
        listev= new ArrayList<>();
        v1 = new Voiture("Tesla", 5000);
        v2 = new Voiture("BMW", 7000);
        v3 = new Voiture("Audi", 8000);
        v4 = new Voiture("Mercedes", 10000);
        v5 = new Voiture("Renault", 4000);
        v6 = new Voiture("Peugeot", 6000);
    }

    @Test
    void testAjouter() {
        service.ajouter(v1);
        listev.add((v1));
        assertEquals(1, service.getListeVoiture().size());
        assertEquals(v1, service.getListeVoiture().get(0));
    }

    @Test
    void testPrix() {
        service.ajouter(v1);
        service.ajouter(v2);
        assertEquals(12000, service.prix());
    }

    @Test
    void testPrixAvecRemise() {
        service.ajouter(v1);
        service.ajouter(v2);
        service.ajouter(v3);
        service.ajouter(v4);
        service.ajouter(v5); // 5 voitures -> 5% de remise
        assertEquals(34000 - (0.05 * 34000), service.prix());
        service.ajouter(v6); // 6 voitures -> toujours 5% de remise
        assertEquals(40000 - (0.05 * 40000), service.prix());
    }

    @Test
    void testPrixAvecRemiseMaximale() {
        // Ajout de nombreuses voitures pour atteindre la remise maximale
        for (int i = 0; i < 25; i++) {
            service.ajouter(new Voiture("Voiture" + i, 10000));
        }
        assertEquals((250000 - 20000), service.prix());
    }

    @Test
    void testPrixSansVoiture() {
        assertThrows(ArithmeticException.class, () -> service.prix());
    }

    // Ajoute trois voitures avec un prix de 0 vérifie si une exception
    // est levée lorsque toutes les voitures ont un prix de 0.
    @Test
    void testCas1() {
        service.ajouter(new Voiture("Cas1_Voiture1", 0));
        service.ajouter(new Voiture("Cas1_Voiture2", 0));
        service.ajouter(new Voiture("Cas1_Voiture3", 0));
        int zero=0;
        assertEquals(zero, service.prix());
    }

    // Ajoute trois voitures avec un prix de 3 vérifie que la méthode
    // prix retourne correctement la somme des prix sans remise.
    @Test
    void testCas2() {
        service.ajouter(new Voiture("Cas2_Voiture1", 3));
        service.ajouter(new Voiture("Cas2_Voiture2", 3));
        service.ajouter(new Voiture("Cas2_Voiture3", 3));
        assertEquals(9, service.prix());
    }

    // Ajoute trois voitures où deux ont un prix de 0 et une a un prix de 4
    // vérifie le comportement lorsque certaines voitures ont un prix de 0.
    @Test
    void testCas3() {
        service.ajouter(new Voiture("Cas3_Voiture1", 0));
        service.ajouter(new Voiture("Cas3_Voiture2", 4));
        service.ajouter(new Voiture("Cas3_Voiture3", 0));
        assertEquals(4, service.prix());
    }

    // Vérifie la somme totale sans remise.
    @Test
    void testCas4() {
        service.ajouter(new Voiture("Cas4_Voiture1", 3000));
        service.ajouter(new Voiture("Cas4_Voiture2", 8000));
        service.ajouter(new Voiture("Cas4_Voiture3", 3000));
        assertEquals(14000, service.prix());
    }

    @Test
    void testCas5() {
        service.ajouter(new Voiture("Cas5_Voiture1", 5000));
        service.ajouter(new Voiture("Cas5_Voiture2", 8000));
        service.ajouter(new Voiture("Cas5_Voiture3", 5000));
        assertEquals(18000, service.prix());
    }

    // Vérifie que la somme est correcte même avec un prix nul.
    @Test
    void testCas6() {
        service.ajouter(new Voiture("Cas6_Voiture1", 0));
        service.ajouter(new Voiture("Cas6_Voiture2", 5000));
        service.ajouter(new Voiture("Cas6_Voiture3", 6000));
        assertEquals(11000, service.prix());
    }

    @Test
    void testCas7() {
        service.ajouter(new Voiture("Cas7_Voiture1", 3000));
        service.ajouter(new Voiture("Cas7_Voiture2", 8000));
        service.ajouter(new Voiture("Cas7_Voiture3", 4000));
        assertEquals(15000, service.prix());
    }

    @Test
    void testCas8() {
        service.ajouter(new Voiture("Cas8_Voiture1", 3000));
        service.ajouter(new Voiture("Cas8_Voiture2", 4000));
        service.ajouter(new Voiture("Cas8_Voiture3", 5000));
        assertEquals(12000, service.prix());
    }

    // Nouveau test : Prix négatif
    @Test
    void testVoiturePrixNegatif() {
        service.ajouter(new Voiture("VoiturePrixNegatif", -1000));
        assertThrows(ArithmeticException.class, () -> service.prix());
    }

    // Nouveau test : Ajout voiture avec prix nul
    @Test
    void testAjoutVoiturePrixNul() {
        service.ajouter(new Voiture("VoiturePrixNul", 0));
        assertEquals(0, service.getListeVoiture().get(0).getPrix());
    }

    // Nouveau test : Ajout de la même voiture plusieurs fois
    @Test
    void testAjoutMemeVoiturePlusieursFois() {
        service.ajouter(v1);
        service.ajouter(v1);
        assertEquals(2, service.getListeVoiture().size());
        assertEquals(v1, service.getListeVoiture().get(0));
        assertEquals(v1, service.getListeVoiture().get(1));
    }

    // Nouveau test : État initial de service
    @Test
    void testEtatInitialService() {
        assertEquals(0, service.getListeVoiture().size());
    }

    @Test
    void testReste(){
        v1.getMarque();
        listev.add(v2);

        assertEquals(v1.getMarque(),"Tesla");
        v1.setMarque("Binta");
        v1.setPrix(100000);
        v1.toString();
        service.toString();
        service.setListeVoiture(listev);
    }
}