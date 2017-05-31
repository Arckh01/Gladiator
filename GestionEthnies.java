package packglad;

import java.util.ArrayList;
import java.util.Collection;

public class GestionEthnies {
    /**
     * @attribute
     */
    private static Integer prochainIde= 1;

    /**
     * @associates <{uml.Ethnie}>
     */
    private static Collection toutesLesEthnies;

    public static Ethnie nouvelleEtnie(String nom) {
        Ethnie res = new Ethnie(nom,GestionEthnies.prochainIde);
        GestionEthnies.prochainIde++;
        GestionEthnies.toutesLesEthnies.add(res);
        return res;
    }

    public static Ethnie getEthnie(Integer ide) {
        ArrayList<Ethnie> alEthnie = new ArrayList(GestionEthnies.toutesLesEthnies);
        Ethnie res = alEthnie.get(0);
        for(Ethnie e : alEthnie) 
        {
            if(e.getIde() == ide) 
            {
                res = e;
            }
        }
        return res;
    }

    public static Boolean supprimer(Integer ide) {
        ArrayList<Ethnie> alEthnie = new ArrayList(GestionEthnies.toutesLesEthnies);
        Boolean res = false;
        for(Ethnie e : alEthnie) 
        {
            if(e.getIde() == ide) 
            {
                res = true;
                GestionEthnies.toutesLesEthnies.remove(e);
            }
        }
        
        return res;
    }

    public static Collection listerEthnies() {
        return GestionEthnies.toutesLesEthnies;
    }
}
