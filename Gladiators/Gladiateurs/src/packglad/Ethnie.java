package packglad;

import java.util.ArrayList;

public class Ethnie {
    /**
     * @attribute
     */
    private Integer ide;

    /**
     * @attribute
     */
    private String nom;

    public Ethnie(String Nom, Integer ide) {
        this.nom =Nom;
        this.ide = ide;
    }

    public Integer getIde() {
        return ide;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }


}
