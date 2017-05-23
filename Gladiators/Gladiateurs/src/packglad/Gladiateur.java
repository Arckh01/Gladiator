package packglad;

import java.util.Collection;

public abstract class Gladiateur {
    /**
     * @attribute
     */
    protected static Integer c_vieInitiale;

    /**
     * @attribute
     */
    private Integer vie;

    /**
     * @attribute
     */
    private Integer idg;

    /**
     * @attribute
     */
    private Integer force;

    /**
     * @attribute
     */
    private String nom;
    private Ethnie ethnie;

    /**
     * @associates <{uml.Arme}>
     */
    private Collection c_listeArmes;

    public Gladiateur() {
    }

    public Gladiateur(String nom, Integer force, Integer idg, Ethnie ethnie) {
    }


    public Collection listerArme() {
    }

    public abstract static void c_interdireArme(Arme arme);

    public String getEtat() {
    }

    public Ethnie getEthnie() {
    }

    public void recevoirArme(Arme arme) {
    }

    public abstract static void c_autoriserArme(Arme arme);

    public void perdreArme(Arme arme) {
    }

    public abstract String rapport();

    public String saluer() {
    }

    public void frapper(Gladiateur victime, Gladiateur instrument) {
    }
    public Integer getVie() {
        return vie;
    }
}
