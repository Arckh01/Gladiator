package packglad;

import java.util.Collection;

public class Mirmillon extends Gladiateur {
    /**
     * @attribute
     */
    private Integer poids;

    /**
     * @attribute
     */
    private static Integer c_poidsMax;

    /**
     * @associates <{uml.Gladiateur}>
     */
    private static Collection c_tappeurs;

    /**
     * @associates <{uml.Arme}>
     */
    private static Collection c_equipable;

    public static void c_autoriserArme(Arme Arme) {
    }

    public void Mirmillion(String nom, Integer poids, Integer idg, Integer force) {
    }

    public Collection getAssaillant() {
    }

    public String rapport() {
    }

    public static void c_interdireArme(Arme Arme) {
    }

    public void subirCoup(Gladiateur assaillant, Integer puissance) {
    }
}
