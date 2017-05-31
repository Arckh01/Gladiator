package packglad;

public class Arme {
    /**
     * @attribute
     */
    private Integer attaque;

    /**
     * @attribute
     */
    private Integer defense;

    /**
     * @attribute
     */
    private Integer ida;

    /**
     * @attribute
     */
    private String nom;

    public Arme(String nom, Integer attaque, Integer defense, Integer ida) {
        this.nom = nom;
        if(attaque > 0)
            this.attaque =attaque;
        if(defense >0)
            this.defense = defense;
        this.ida = ida;
    }

    public void setAttaque(Integer attaque) {
        this.attaque = attaque;
    }

    public Integer getAttaque() {
        return attaque;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getIda() {
        return ida;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
