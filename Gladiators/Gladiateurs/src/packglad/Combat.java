package packglad;

import java.util.ArrayList;
import java.util.Collection;

public class Combat {
    public static void debutCombat() {
        ArrayList<Gladiateur> alGlad = new ArrayList(GestionGladiateur.listerGladiateurs());
        ArrayList<Arme> alArme = new ArrayList();
        
        for(Gladiateur g : alGlad) 
        {
            System.out.println(g.saluer());
            alArme = new ArrayList(g.listerArme());
            for(Arme a : alArme) 
            {
                System.out.println("Voici mes armes : ");
                System.out.print(a.getNom());
            }
        }
    }

    public static void finCombat() {
    }

    public Integer getScore(Ethnie e) {
        ArrayList<Gladiateur> al = new ArrayList(GestionGladiateur.listerGladiateurs(e));
        int score = 0;
        for (Gladiateur g : al) 
        {
            if (g.getVie() > 50)
                score += 10;
            else if (g.getVie() >= 10 )
                score += 5 ;
        }

        return score;
    }

}
