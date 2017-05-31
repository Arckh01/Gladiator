package packglad;

import java.util.ArrayList;
import java.util.Collection;

public class GestionArme {
    /**
     * @attribute
     */
    private static Integer prochainIda=1;

    /**
     * @associates <{uml.Arme}>
     */
    private static Collection toutesLesArmes;

    public static Arme getArme(Integer ida) {
        ArrayList<Arme> alArme = new ArrayList(toutesLesArmes);
        Arme res = alArme.get(0);
        for(Arme a : alArme) 
        {
            if(a.getIda() == ida) 
            {
                res = a;
            }
        }
        return res;
    }

    public static Collection listerArmes() {
        return GestionArme.toutesLesArmes;      
    }

    public static Arme nouvelleArme(String Nom, Integer Atq, Integer Def) {
       
        Arme res = new Arme(Nom,Atq,Def,GestionArme.prochainIda);
        GestionArme.toutesLesArmes.add(res);
        GestionArme.prochainIda++;
        
        return res;
        
    }

    public static Boolean supprimer(Integer ida) {
        ArrayList<Arme> alArme = new ArrayList(toutesLesArmes);
        Boolean res = false;
        
        for(Arme a : alArme) 
        {
            if(a.getIda()== ida) 
            {
                GestionArme.toutesLesArmes.remove(a);
                res = true;
            }
        }
        return res;
    }
}
