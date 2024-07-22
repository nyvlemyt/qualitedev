package moitest;
import moi.Voiture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VoitureTest {
    @Test
    void Test1(){
        Voiture voiture1 = new Voiture("Tesla", 2000.0f);
        assertEquals("Voiture{marque='Tesla', prix=2000.0}", voiture1.toString());
    }
}
