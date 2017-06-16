package packglad;

import java.util.ArrayList;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FacadeTest {
    public FacadeTest() {
    }
    
    private int ide;
    
    @Before
    public void setUp(){
        Facade.lancerJeu();
            
        
    }

    /**
     * @see Facade#lancerJeu()
     */
    @Test
    public void testLancerJeu() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#lancerJeuDEssai()
     */
    @Test
    public void testLancerJeuDEssai() {
        fail("Unimplemented");
    }

    
    //1.a creer Retiaire
    /**
     * @see Facade#creerRetiaire(String,Integer,Integer)
     */
    @Test
    public void testCreerRetiaire() {        
        ide = Facade.creerEthnie("Russe"); 
        int idRetiaire = Facade.creerRetiaire("Romain", 50, ide); 
        int idMirmillon = Facade.creerMirmillon("Banane", 50, ide);
       
       
        assertThat("Facade.agiliteRetiaire : agilité mal initilalisé", Facade.agiliteRetiaire(idRetiaire),is(50));
        assertThat("Facade.NomduGladiateur : nom mal initilalisé",Facade.nomDuGladiateur(idRetiaire),is("Romain"));
        assertThat("Facade.creerRetiaire : idg mal initilalisé",idRetiaire,is(1));

    }
    //2.a creerMirmillon
    /**
     * @see Facade#creerMirmillon(String,Integer,Integer)
     */
    @Test
    public void testCreerMirmillon() {
        ide = Facade.creerEthnie("Russe"); 
        int idRetiaire = Facade.creerRetiaire("Romain", 50, ide); 
        int idMirmillon = Facade.creerMirmillon("Banane", 50, ide);
        //assertThat("Facade.poidsMirmillon : poid mal initilalisé", Facade.poidsMirmillon(idMirmillon),is(50));
        assertThat("Facade.nomDuGladiateur : nom mal initilalisé",Facade.nomDuGladiateur(idMirmillon),is("Banane"));
        assertThat("Facade.creerMirmillon : id mal initilalisé",idMirmillon,is(2));
    }
    //3.a listerGladiateursDEthnie
    /**
     * @see Facade#listerGladiateursDEthnie(Integer)
     */
    @Test
    public void testListerGladiateursDEthnie() {
        ide = Facade.creerEthnie("Russe"); 
        int idRetiaire = Facade.creerRetiaire("Romain", 50, ide); 
        int idMirmillon = Facade.creerMirmillon("Banane", 50, ide);
        assertThat("GestionGladiateur.getGladiateur(idRetiaire).getEthnie().getIde() : ide mal initilalisé", GestionGladiateur.getGladiateur(idRetiaire).getEthnie().getIde(),is(1));
    }
    //4.a Gestion des identifiants
    @Test
    public void testidg() {
        ide = Facade.creerEthnie("Russe"); 
        for(int i = 1 ;i<=10;i++)
        {
            assertThat("Facade.creerRetiaire Nr "+i+" : idg mal initialisé",Facade.creerRetiaire("Clone", 30, 1),is(i));
        }
                                
    }
    //4.b Gestion des identifiants
    @Test
    public void testCreerGladiatueurErreur() {
        ide = Facade.creerEthnie("Russe"); 
        Facade.creerRetiaire("Potators l'ultime", 10000, null);
        assertThat("Facade.creerRetiaire : idg mal initialisé",Facade.creerRetiaire("Potators le retour", 10000, 1),is(1));
    }
    //5.a listerTousGladiateurs
    /**
     * @see Facade#listerTousGladiateurs()
     */
    @Test
    public void testListerTousGladiateurs() {        
        ide = Facade.creerEthnie("Russe"); 
        assertThat("Facade.listerTousGladiateurs().size() : Liste mal rempli",Facade.listerTousGladiateurs().size(),is(0));       
    }
    //5.b listerTousGladiateurs
    /**
     * @see Facade#listerTousGladiateurs()
     */
    @Test
    public void testListerTousGladiateurs2() { 
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerRetiaire("truc",10,1);
        assertThat("Facade.listerTousGladiateurs().size() : Liste mal remplie",Facade.listerTousGladiateurs().size(),is(1));
        assertThat("Facade.listerTousGladiateurs().contains() : Liste mal remplie",Facade.listerTousGladiateurs().contains(idg),is(true));
        
    }
    //5.c listerTousGladiateurs
    /**
     * @see Facade#listerTousGladiateurs()
     */
    @Test
    public void testListerTousGladiateurs3() { 
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerRetiaire("truc",10,1);
        int idg2 = Facade.creerRetiaire("machin",15,1);
        assertThat("Facade.listerTousGladiateurs().size() : Liste mal remplie",Facade.listerTousGladiateurs().size(),is(2));
        assertThat("Facade.listerTousGladiateurs().contains() : Liste mal remplie",Facade.listerTousGladiateurs().contains(idg),is(true));
        assertThat("Facade.listerTousGladiateurs().contains() : Liste mal remplie",Facade.listerTousGladiateurs().contains(idg2),is(true));
        
    }
    //6.a creerUneArme
    /**
     * @see Facade#creerUneArme(String,Integer,Integer)
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreerUneArme() {
        //nom vide
       Facade.creerUneArme("", 10, 10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreerUneArme2() {
        //nom null
       Facade.creerUneArme(null, 10, 10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreerUneArme3() {
        //attaque negative
       Facade.creerUneArme("Clavier", -10, 10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreerUneArme4() {
        //attaque null
       Facade.creerUneArme("Clavier", null, 10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreerUneArme5() {
        //defense negative
       Facade.creerUneArme("Clavier", 10, -10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreerUneArme6() {
        //defense null
       Facade.creerUneArme("Clavier", 10, null);
    }
    //6.b creerUneArme
    @Test(expected = IllegalArgumentException.class)
    public void testCreerUneArme7() {
        
       Facade.creerUneArme("Clavier", 10, 10);
       Facade.creerUneArme("Clavier", 10, 10);
    }
    //7.a listerArmesDispoMirmillon
    /**
     * @see Facade#listerArmesDispoMirmillon()
     */
    @Test
    public void testListerArmesDispoMirmillon() {
       assertThat("Facade.listerArmesDispoMirmillon() : liste mal rempli", Facade.listerArmesDispoMirmillon().size(),is(0));
    }
    //7.b listerArmesDispoMirmillon
    /**
     * @see Facade#listerArmesDispoMirmillon()
     */
    @Test
    public void testListerArmesDispoMirmillon2() {
      int ida = Facade.creerUneArme("Banane", 10, 0);
      Facade.autoriserArmeAuxMirmillons(ida);
        assertThat("Facade.listerArmesDispoMirmillon() : liste mal rempli", Facade.listerArmesDispoMirmillon().size(),is(1));
        assertThat("Facade.listerArmesDispoMirmillon() : liste mal rempli", Facade.listerArmesDispoMirmillon().contains(ida),is(true));
    }
    //7.c listerArmesDispoMirmillon/listerArmesDispoRetiaire
    /**
     * @see Facade#listerArmesDispoMirmillon()
     */
    @Test
    public void testListerArmesDispoMirmillonEtListerArmesDispoRetiaire() {
      int ida = Facade.creerUneArme("Banane", 10, 0);
      Facade.autoriserArmeAuxMirmillons(ida);
      Facade.autoriserArmeAuxRetiaires(ida);
      assertThat("Facade.listerArmesDispoMirmillon() : liste mal rempli", Facade.listerArmesDispoMirmillon().size(),is(1));
      assertThat("Facade.listerArmesDispoMirmillon() : liste mal rempli", Facade.listerArmesDispoMirmillon().contains(ida),is(true));
      assertThat("Facade.listerArmesDispoRetiaire() : liste mal rempli", Facade.listerArmesDispoRetiaire().size(),is(1));
      assertThat("Facade.listerArmesDispoRetiaire() : liste mal rempli", Facade.listerArmesDispoRetiaire().contains(ida),is(true));
    }
    //8.a donnerUneArme, declarerArmes
    /**
     * @see Facade#donnerUneArme(Integer,Integer)
     */
    @Test(expected = NoSuchElementException.class)
    public void testDonnerUneArme() {
        ide = Facade.creerEthnie("Russe"); 
        Facade.creerRetiaire("truc",10,1);
        Facade.donnerUneArme(0, 1);
    }
    /**
     * @see Facade#donnerUneArme(Integer,Integer)
     */
    @Test(expected = NoSuchElementException.class)
    public void testDonnerUneArme2() {
        Facade.creerUneArme("Banane", 10, 0);
        Facade.donnerUneArme(1, 0);
    }
    /**
     * @see Facade#declarerArmes(Integer)
     */
    @Test(expected = NoSuchElementException.class)
    public void testDeclarerArmes() {
        Facade.declarerArmes(0);
    }
    //8.b donnerUneArme, declarerArmes
    /**
     * @see Facade#donnerUneArme(Integer,Integer)
     */
    @Test
    public void testDonnerUneArme3() {
        ide = Facade.creerEthnie("Russe"); 
        int ida =Facade.creerUneArme("Banane", 10, 0);
        int idg = Facade.creerRetiaire("truc",10,1);
        Facade.donnerUneArme(ida, idg);
        assertThat("Facade.DonnerUneArme : arme non autorisée donnée",Facade.declarerArmes(idg).size(),is(0));
    }
    //8.c donnerUneArme, declarerArmes
    /**
     * @see Facade#donnerUneArme(Integer,Integer)
     */
    @Test
    public void testDonnerUneArme4() {
        ide = Facade.creerEthnie("Russe"); 
        int ida =Facade.creerUneArme("Banane", 10, 0);
        int ida2 = Facade.creerUneArme("glaive", 30, 0);
        int idg = Facade.creerRetiaire("truc",10,1);
        Facade.autoriserArmeAuxRetiaires(ida2);
        Facade.donnerUneArme(ida, idg);
        Facade.donnerUneArme(ida2,idg);
        assertThat("Facade.declarerArmes : Liste mal remplie",Facade.declarerArmes(idg).size(),is(1));
        assertThat("Facade.declarerArmes : Liste mal remplie",Facade.declarerArmes(idg).contains(ida2),is(true));
    }
    //8.d  donnerUneArme, declarerArmes
    /**
     * @see Facade#donnerUneArme(Integer,Integer)
     */
    @Test
    public void testDonnerUneArme5() {
        ide = Facade.creerEthnie("Russe"); 
        int ida =Facade.creerUneArme("Banane", 10, 0);        
        int idg = Facade.creerRetiaire("truc",10,1);
        Facade.autoriserArmeAuxRetiaires(ida);
        
        Facade.donnerUneArme(ida, idg);
        Facade.donnerUneArme(ida,idg);
        assertThat("Facade.declarerArmes : Liste mal remplie",Facade.declarerArmes(idg).size(),is(1));        
    }
    //8.e donnerUneArme, declarerArmes
    /**
     * @see Facade#donnerUneArme(Integer,Integer)
     */
    @Test
    public void testDonnerUneArme6() {
        ide = Facade.creerEthnie("Russe"); 
        int ida =Facade.creerUneArme("Banane", 10, 0);
        int ida2 = Facade.creerUneArme("glaive", 30, 0);
        int idg = Facade.creerRetiaire("truc",10,1);
        Facade.autoriserArmeAuxRetiaires(ida);
        Facade.autoriserArmeAuxRetiaires(ida2);
        Facade.donnerUneArme(ida, idg);
        Facade.donnerUneArme(ida2,idg);
        assertThat("Facade.declarerArmes : Liste mal remplie",Facade.declarerArmes(idg).size(),is(2));
        assertThat("Facade.declarerArmes : Liste mal remplie",Facade.declarerArmes(idg).contains(ida),is(true));
        assertThat("Facade.declarerArmes : Liste mal remplie",Facade.declarerArmes(idg).contains(ida2),is(true));
    }
    //9.a desarmer
    /**
     * @see Facade#desarmer(Integer,Integer)
     */
    @Test(expected = NoSuchElementException.class)
    public void testDesarmer() {
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerRetiaire("truc",10,1);
        Facade.desarmer(idg, 0);
    }
    //9.b desarmer
    /**
     * @see Facade#desarmer(Integer,Integer)
     */
    @Test(expected =  IllegalArgumentException.class)
    public void testDesarmer2() {
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerRetiaire("truc",10,1);
        int ida =Facade.creerUneArme("Banane", 10, 0);
        Facade.desarmer(idg, ida);
    }
    //9.c
    /**
     * @see Facade#desarmer(Integer,Integer)
     */
    @Test
    public void testDesarmer3() {
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerRetiaire("truc",10,1);
        int ida =Facade.creerUneArme("Banane", 10, 0);
        Facade.autoriserArmeAuxRetiaires(ida);
        Facade.donnerUneArme(ida, idg);
        Facade.desarmer(idg, ida);
        assertThat("Facade.desarmer : arme non enlevée",Facade.declarerArmes(idg).size(),is(0));
    }
    //10.a frapper
    /**
     * @see Facade#frapper(Integer,Integer,Integer)
     */
    @Test
    public void testFrapper() {
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerRetiaire("truc",10,1);
        int idg2 = Facade.creerMirmillon("machin", 20, 1);
        int vieInit = Facade.vieGladiateur(idg2);
        int ida =Facade.creerUneArme("Banane", 10, 0);
        Facade.autoriserArmeAuxRetiaires(ida);
        Facade.donnerUneArme(ida, idg);
        Facade.frapper(idg, idg2, ida);
        assertThat("Facade.frapper : vie mal déduite",Facade.vieGladiateur(idg2),is(vieInit - 20));
    }
    //10.b fraper
    /**
     * @see Facade#frapper(Integer,Integer,Integer)
     */
    @Test
    public void testFrapper2() {
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerRetiaire("truc",10,1);
        int idg2 = Facade.creerMirmillon("machin", 20, 1);
        int vieInit = Facade.vieGladiateur(idg);
        int ida =Facade.creerUneArme("Banane", 10, 0);
        Facade.autoriserArmeAuxMirmillons(ida);
        Facade.donnerUneArme(ida, idg2);
        Facade.frapper(idg2, idg, ida);
        assertThat("Facade.frapper : vie mal déduite",Facade.vieGladiateur(idg),is(vieInit - (20-10)));
    }
    //10.c frapper
    /**
     * @see Facade#frapper(Integer,Integer,Integer)
     */
    @Test
    public void testFrapper3() {
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerRetiaire("truc",10,1);
        int idg2 = Facade.creerMirmillon("machin", 20, 1);
        int vieInit = Facade.vieGladiateur(idg2);
        int ida =Facade.creerUneArme("Banane", 10, 0);
        int ida2 =Facade.creerUneArme("Bouclier", 10, 10);
        Facade.autoriserArmeAuxRetiaires(ida);
        Facade.autoriserArmeAuxMirmillons(ida2);
        Facade.donnerUneArme(ida, idg);
        Facade.donnerUneArme(ida2, idg2);
        Facade.frapper(idg, idg2, ida);
        assertThat("Facade.frapper : vie mal déduite",Facade.vieGladiateur(idg2),is(vieInit - (20-10)));
    }
    //10.d frapper
    /**
     * @see Facade#frapper(Integer,Integer,Integer)
     */
    @Test
    public void testFrapper4() {
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerRetiaire("truc",10,1);
        int idg2 = Facade.creerMirmillon("machin", 20, 1);
        int vieInit = Facade.vieGladiateur(idg);
        int ida =Facade.creerUneArme("Banane", 10, 10);
        int ida2 =Facade.creerUneArme("Bouclier", 10, 10);
        Facade.autoriserArmeAuxRetiaires(ida);
        Facade.autoriserArmeAuxMirmillons(ida2);
        Facade.donnerUneArme(ida, idg);
        Facade.donnerUneArme(ida2, idg2);
        Facade.frapper(idg2, idg, ida2);
        assertThat("Facade.frapper : vie mal déduite",Facade.vieGladiateur(idg),is(vieInit ));//car la def du retiare = l'att
    }
    //10.e frapper
    /**
     * @see Facade#frapper(Integer,Integer,Integer)
     */
    @Test
    public void testFrapper5() {
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerRetiaire("truc",30,1);
        int idg2 = Facade.creerMirmillon("machin", 20, 1);
        int vieInit = Facade.vieGladiateur(idg);
        int ida =Facade.creerUneArme("Banane", 10, 10);        
        Facade.autoriserArmeAuxMirmillons(ida);
        Facade.donnerUneArme(ida, idg);        
        Facade.frapper(idg2, idg, ida);
        assertThat("Facade.frapper : vie mal déduite",Facade.vieGladiateur(idg),is(vieInit));
    }
    //10.f frapper
    /**
     * @see Facade#frapper(Integer,Integer,Integer)
     */
    @Test
    public void testFrapper6() {
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerRetiaire("truc",10,1);
        int idg2 = Facade.creerMirmillon("machin", 20, 1);
        int vieInit = Facade.vieGladiateur(idg2);
        int ida =Facade.creerUneArme("Banane", 10, 0);
        int ida2 =Facade.creerUneArme("Bouclier", 100, 10);
        Facade.autoriserArmeAuxRetiaires(ida);
        Facade.autoriserArmeAuxMirmillons(ida2);
        Facade.donnerUneArme(ida, idg);
        Facade.donnerUneArme(ida2, idg2);
        Facade.frapper(idg, idg2, ida);
        assertThat("Facade.frapper : vie mal déduite",Facade.vieGladiateur(idg2),is(vieInit));
    }
    //10.g frapper
    /**
     * @see Facade#frapper(Integer,Integer,Integer)
     */
    @Test
    public void testFrapper7() {
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerMirmillon("machin", 20, 1);
        int vieInit = Facade.vieGladiateur(idg);
        int ida =Facade.creerUneArme("Banane", 10, 0);      
        Facade.autoriserArmeAuxMirmillons(ida);
        Facade.donnerUneArme(ida, idg);        
        Facade.frapper(idg, idg, ida);
        assertThat("Facade.frapper : vie mal déduite",Facade.vieGladiateur(idg),is(vieInit - 20));
    }
    //10.h frapper
    /**
     * @see Facade#frapper(Integer,Integer,Integer)
     */
    @Test
    public void testFrapper8() {
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerMirmillon("machin", 20, 1);
        int idg2 = Facade.creerMirmillon("machin le jumeau", 20, 1);
        int vieInit = Facade.vieGladiateur(idg);
        int ida =Facade.creerUneArme("Banane ultime", 100000000, 0);
        int ida2 =Facade.creerUneArme("Banane du jumeau", 100, 0);
        Facade.autoriserArmeAuxMirmillons(ida);
        Facade.autoriserArmeAuxMirmillons(ida2);
        Facade.donnerUneArme(ida, idg);
        Facade.donnerUneArme(ida2, idg2);
        Facade.frapper(idg, idg2, ida);//pour tuer idg2
        Facade.frapper(idg2, idg, ida);
        assertThat("Facade.frapper : vie mal déduite",Facade.vieGladiateur(idg),is(vieInit ));
    }
    //11.a ListerAgresseurs
    /**
     * @see Facade#listerAgresseurs(Integer)
     */
    @Test(expected = IllegalArgumentException.class)
    public void testListerAgresseurs() {
        ide = Facade.creerEthnie("Russe"); 
       int idg = Facade.creerRetiaire("truc", 20, 1);
       Facade.listerAgresseurs(idg);
    }
    //11.b ListerAgresseurs
    @Test
    public void testListerAgresseurs2() {
        ide = Facade.creerEthnie("Russe"); 
       int idg = Facade.creerMirmillon("truc", 20, 1);
       int idg2 = Facade.creerMirmillon("machin", 20, 1);
       int ida =Facade.creerUneArme("Banane", 10, 0); 
       Facade.autoriserArmeAuxMirmillons(ida);
       Facade.donnerUneArme(ida, idg);
       Facade.frapper(idg, idg2, ida);
       assertThat("Facade.ListerAggresseurs : liste doit etre vide",Facade.listerAgresseurs(idg).size(),is(0));
       assertThat("Facade.ListerAgresseurs : liste doit avoir un agresseur", Facade.listerAgresseurs(idg2).contains(idg),is(true));
    }
    //11.c ListerAgresseurs
    @Test
    public void testListerAgresseurs3() {
        ide = Facade.creerEthnie("Russe"); 
       int idg = Facade.creerMirmillon("truc", 20, 1);
       int idg2 = Facade.creerMirmillon("machin", 20, 1);
       int ida =Facade.creerUneArme("Banane", 10, 0); 
       Facade.autoriserArmeAuxMirmillons(ida);
       Facade.donnerUneArme(ida, idg);
       Facade.frapper(idg, idg2, ida);
       Facade.frapper(idg, idg2, ida);
       Facade.frapper(idg, idg2, ida);       
       assertThat("Facade.ListerAgresseurs : liste doit avoir un agresseur", Facade.listerAgresseurs(idg2).size(),is(1));
    }
    //11.d
    @Test
    public void testListerAgresseurs4() {
        ide = Facade.creerEthnie("Russe"); 
       int idg = Facade.creerMirmillon("truc", 20, 1);       
       int ida =Facade.creerUneArme("Banane", 10, 0); 
       Facade.autoriserArmeAuxMirmillons(ida);
       Facade.donnerUneArme(ida, idg);
       Facade.frapper(idg, idg, ida);       
       assertThat("Facade.ListerAgresseurs : liste doit avoir un agresseur", Facade.listerAgresseurs(idg).contains(idg),is(true));
    }
    //12.a supprimerGlad
    /**
     * @see Facade#supprimerGlad(Integer)
     */
    @Test
    public void testSupprimerGlad() {
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerMirmillon("truc", 20, 1);
        int idg2 = Facade.creerMirmillon("machin", 20, 1);
        Facade.supprimerGlad(idg);
        assertThat("Facade.SupprimerGlad : mauvais changement dans la liste ", Facade.listerTousGladiateurs().size(),is(1));
        Facade.supprimerGlad(idg2);
        assertThat("Facade.SupprimerGlad : mauvais changement dans la liste ", Facade.listerTousGladiateurs().size(),is(0));        
    }
    //12.b supprimerGlad
    /**
     * @see Facade#supprimerGlad(Integer)
     */
    @Test
    public void testSupprimerGlad2() {
        ide = Facade.creerEthnie("Russe"); 
        int idg = Facade.creerMirmillon("truc", 20, 1);
        int idg2 = Facade.creerMirmillon("machin", 20, 1);
        int ida =Facade.creerUneArme("Banane", 10, 0); 
        Facade.autoriserArmeAuxMirmillons(ida);
        Facade.donnerUneArme(ida, idg);
        Facade.frapper(idg, idg2, ida);
        Facade.supprimerGlad(idg);
        assertThat("Facade.supprimerGlad : Aggresseur non supprime",Facade.listerAgresseurs(idg2).contains(idg),is(false));            
    }

   
}
