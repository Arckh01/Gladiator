package packglad;

import java.util.Collection;

public class Retiaire extends Gladiateur {
    /**
     * @attribute
     */
    private static Integer c_agiliteMax;

    /**
     * @attribute
     */
    private Integer agilite;

    /**
     * @attribute
     */
    private static Integer c_forceDefaut;

    /**
     * @associates <{uml.Arme}>
     */
    private static Collection c_equipable;

    public Retiaire(String nom, Integer Agilite, Integer idg) {
    }

    public String getTypeGladiateur() {
    }

    public void subirCoup(Gladiateur assaillant, Integer puissance) {
    }

    public static void c_interdireArme(Arme Arme) {
    }

    public String rapport() {
    }

    public static void c_autoriserArme(Arme Arme) {
    }
}
