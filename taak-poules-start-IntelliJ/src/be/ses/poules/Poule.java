/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ses.poules;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

// hulpfuncties bij steken

/**
 *
 * @author u0002531
 */
public class Poule {
    private ArrayList<Ploeg> ploegen;
    int maxaantal = 0;
    public Poule() {
        ploegen = new ArrayList<>();
    }

    /**
     * @return the ploegen
     */
    public ArrayList<Ploeg> getPloegen() {
        return ploegen;
    }

    public void voegtoe(Ploeg p) {
        ploegen.add(p);
    }
    
    public void verwijder(Ploeg p) {
        ploegen.remove(p);
    }
    
    public int getAantal() {
        return ploegen.size();
    }


    public boolean compatibel(Ploeg ploeg) {
        boolean compatibel = TRUE;
        //System.out.println("is er een incompatibel land in poule :"+IncompatibelLandInPoule(ploeg));
        //System.out.println("er zijn al te veel van deze landen in deze poule returns :"+(aantalPloegenVanLandInPoule(ploeg) >= ploeg.getLand().getMaxAantal()));

        if (aantalPloegenVanLandInPoule(ploeg) >= ploeg.getLand().getMaxAantal() || IncompatibelLandInPoule(ploeg) == TRUE || this.ploegen.size() >= this.maxaantal){
            compatibel = FALSE;
        }
        //System.out.println("compatibel returns : " + compatibel);
        return compatibel;
    }
    public void SetmaxAantal(int aantal){
        this.maxaantal = aantal;
    }
    public int aantalPloegenVanLandInPoule(Ploeg ploeg){
        //System.out.println(ploeg.getLand().getNaam() + " mag slechts " + ploeg.getLand().getMaxAantal() + " in dezelfde poule hebben");
        int counter = 0;
        for (Ploeg p : this.ploegen)
        {
            if(p.getLand() == ploeg.getLand())
            {
                counter ++ ;
            }
        }
        return counter ;
    }
    public boolean IncompatibelLandInPoule(Ploeg CheckPloeg){
        Land PloegLand = CheckPloeg.getLand();
        ArrayList<Land> IncompatibelCheckPloeg= PloegLand.getIncompatibel();
        boolean aanwezig = FALSE ;
        for (Ploeg p : this.ploegen){
            for (Land l1 : IncompatibelCheckPloeg){
                if (l1 == p.getLand()){
                    aanwezig = TRUE;
                }
            }
            for (Land l2 : p.getLand().getIncompatibel()){
                if (l2 == CheckPloeg.getLand()){
                    aanwezig = TRUE;
                }
            }

        }
        return aanwezig;
    }

    @Override
    public String toString() {
        return "Poule{" + "ploegen=" + ploegen + '}';
    }
    
}
