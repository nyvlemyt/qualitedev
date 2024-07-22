package moitest;
import bintaservice.service;
import moi.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestService {

    private service service;
    private Voiture v1;
    private Voiture v2;
    private Voiture v3;
    private Voiture v4;
    private Voiture v5;
    private Voiture v6;

    @BeforeEach
    void setUp() {
        service = new service();
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


}
