package packglad;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Gladiateur {
    /**
     * @attribute
     */
    protected static Integer c_vieInitiale = 200;

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
    private ArrayList<Arme> listeArmes;

    public Gladiateur(String nom, Integer force, Integer idg, Ethnie ethnie) {
        this.nom = nom;
        this.force = force;
        this.idg = idg;
        this.ethnie = ethnie;
        this.vie = Gladiateur.c_vieInitiale;
        this.listeArmes = new ArrayList<Arme>();
    }


    public Collection listerArme() {
        Collection listeArmes = this.listeArmes;
    }

    public abstract static void c_interdireArme(Arme arme);

    public String getEtat() {
        String res = "";
        if(this.vie < 0){
            res = "Mort";
        }
        else if(this.vie < 10){
            res = "Moribond";
        }
        else if(this.vie <= 50){
            res = "Blessé";
        }
        else{
            res = "Bien portant";
        }
        return res;
    }

    public Ethnie getEthnie() {
        return this.ethnie;
    }

    public void recevoirArme(Arme arme) {
        this.listeArmes.add(arme);
    }

    public abstract static void c_autoriserArme(Arme arme);

    public void perdreArme(Arme arme) {
        this.listeArmes.remove(arme);
    }

    public abstract String rapport();

    public String saluer() {
        
    }

    public void frapper(Gladiateur victime, Arme instrument) {
        victime.subirCoup(this, this.force + instrument.getAttaque());
    }

    public static void setC_vieInitiale(Integer c_vieInitiale) {
        Gladiateur.c_vieInitiale = c_vieInitiale;
    }

    public static Integer getC_vieInitiale() {
        return c_vieInitiale;
    }

    public void setVie(Integer vie) {
        this.vie = vie;
    }

    public Integer getVie() {
        return vie;
    }

    public void setIdg(Integer idg) {
        this.idg = idg;
    }

    public Integer getIdg() {
        return idg;
    }

    public void setForce(Integer force) {
        this.force = force;
    }

    public Integer getForce() {
        return force;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setEthnie(Ethnie ethnie) {
        this.ethnie = ethnie;
    }

    public Ethnie getEthnie1() {
        return ethnie;
    }

    public void setC_listeArmes(Collection c_listeArmes) {
        this.c_listeArmes = c_listeArmes;
    }

    public Collection getC_listeArmes() {
        return c_listeArmes;
    }

    public abstract void subirCoup(Gladiateur assaillant, Integer puissance) {
    }
}
