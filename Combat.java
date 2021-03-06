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
            System.out.println("Voici mes armes : ");
            for(Arme a : alArme) 
            {               
                System.out.print(a.getNom()+ " ");
            }
        }
    }

    public static void finCombat() {
        ArrayList<Ethnie> alEthnie = new ArrayList(GestionEthnies.listerEthnies());
        ArrayList<Gladiateur> alGlad = new ArrayList(GestionGladiateur.listerGladiateurs());
        int score = 0;
        String EthnieGagnante = "";
        for(Ethnie e : alEthnie) 
        {
            if(Combat.getScore(e) > score )
            {
                score = Combat.getScore(e);
                EthnieGagnante = e.getNom();
            }
            
        }
        System.out.println("Le gagnant est l'�quipe "+EthnieGagnante+ " avec "+score+" point(s)");
        for(Gladiateur g : alGlad)
        {
            System.out.println(g.rapport());
        }
        
        
    }

    public static Integer getScore(Ethnie e) {
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
