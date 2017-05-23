package packglad;

import java.util.Collection;

public class GestionGladiateur {
    /**
     * @attribute
     */
    private static Integer prochainIdg;

    /**
     * @associates <{uml.Retiaire}>
     */
    private static Collection tousLesRetiaires;

    /**
     * @associates <{uml.Gladiateur}>
     */
    private static Collection tousLesGladiateurs;

    /**
     * @associates <{uml.Mirmillon}>
     */
    private static Collection tousLesMirmillons;

    public static Mirmillon nouveauMirmillon(String Nom, Integer Poirds) {
    }

    public static Retiaire nouveauRetiaire(String Nom, Integer Agilite) {
    }


    public static Collection listerMirmillons() {
    }

    public static Collection listerGladiateurs() {
    }

    public static Collection listerRetiaires() {
    }

    public static Boolean supprimerGladiateur(Integer idg) {
    }

    public static void getGladiateur(Integer idg) {
    }

    public static Collection listerGladiateurs(Ethnie e) {
    }
}
