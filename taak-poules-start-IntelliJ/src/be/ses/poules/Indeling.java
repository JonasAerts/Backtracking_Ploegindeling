/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ses.poules;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

// effectief backtracking toepassen

/**
 *
 * @author u0002531
 */
public class Indeling {
    private ArrayList<Ploeg> ploegen;
    private ArrayList<Land> landen;
    private ArrayList<Poule> poules;
    private ArrayList<Ploeg> geplaatst = new ArrayList<Ploeg>();

    private Indeling(int aantalPoules) {
        poules = new ArrayList<>();
        for (int i=0; i<aantalPoules; i++) {
            poules.add(new Poule());
        }
    }
    
    public Indeling(ArrayList<Ploeg> ploegen, ArrayList<Land> landen, int aantalPoules) {
        this(aantalPoules);
        this.ploegen = ploegen;
        this.landen = landen;
    }

    public void SetPouleSizes(){
        for (int x = 0 ; x < poules.size();x++){
            if (x < ploegen.size()%poules.size()){
                poules.get(x).SetmaxAantal((ploegen.size()/poules.size())+1);
            } else {
                poules.get(x).SetmaxAantal(ploegen.size()/poules.size());
            }
        }
    }


    public void backtracking(){
        int pouleindex = 0;
        int ploegindex = 0;
        while (geplaatst.size() < ploegen.size()){
            if (pouleindex == poules.size()){
                System.out.println("ploeg " + ploegindex + " out of bounds / haal de vorige uit zijn poule");
            }
            else {System.out.println("ik check ploeg"+ploegindex+" in poule "+ pouleindex);}
            if (pouleindex == poules.size() && ploegindex == 0 ){
                System.out.println("geen oplossing gevonden");
                break;
            }
            else if (pouleindex < poules.size()){
                if (poules.get(pouleindex).getAantal() == 0){
                    poules.get(pouleindex).voegtoe(ploegen.get(ploegindex));
                    geplaatst.add(ploegen.get(ploegindex));
                    //System.out.println("poule " + pouleindex + " was leeg, ploeg " + ploegindex + " toegevoegd");
                    ploegindex ++;
                    pouleindex = 0;
                } else if (poules.get(pouleindex).compatibel(ploegen.get(ploegindex))){
                    poules.get(pouleindex).voegtoe(ploegen.get(ploegindex));
                    ploegen.get(ploegindex).geplaatst = TRUE;
                    geplaatst.add(ploegen.get(ploegindex));
                    System.out.println("ploeg " + ploegindex+" geplaatsts in poule "+pouleindex);
                    ploegindex++;
                    pouleindex = 0;
                }else {
                    System.out.println("Ploeg " + ploegindex + " was niet compatibel in poule "+ pouleindex);
                    pouleindex++;
                }
                //System.out.println("er zijn "+geplaatst.size()+" ploegen geplaatsts");
            } else {
                ploegindex --;
                geplaatst.remove(ploegen.get(ploegindex));
                pouleindex = FindPloeginPoules(ploegen.get(ploegindex));
                poules.get(pouleindex).verwijder(ploegen.get(ploegindex));
                System.out.println("ploeg " + ploegindex + " verwijderd uit poule "+ pouleindex);
                pouleindex++;
                System.out.println("poule met 1 omhoog : " + pouleindex);
            }
        }
    }
    public int FindPloeginPoules(Ploeg p){
        int index = 0;
        for(int y = 0 ; y <= this.poules.size()-1; y++){
            for (Ploeg x : this.poules.get(y).getPloegen()){
                if (p == x)
                index = y;
            }
        }
        return index ;
    }

    public int getAantalPloegen() {
        return ploegen.size();
    }
    
    public Indeling(ArrayList<String> namenLand, ArrayList<Integer> maxima, 
                    ArrayList<ArrayList<String>> incompatibel, ArrayList<Integer> aantallen, int aantalPoules) {
        this(aantalPoules);
        ploegen = new ArrayList<>();
        landen = new ArrayList<>();
        
        
        for (int i = 0; i<namenLand.size(); i++) {
            String naam = namenLand.get(i);
            Land l = new Land(naam, maxima.get(i));
            landen.add(l);
            for (int j=1; j<aantallen.get(i)+1; j++) {
                ploegen.add(new Ploeg(naam+j, l));                
            }
        }
        
        for (int i = 0; i<incompatibel.size(); i++) {
            ArrayList<Land> incompat = new ArrayList<>();
            for (String landNaam : incompatibel.get(i)) {
                Optional<Land> land = getLandOpNaam(landNaam);
                if (land.isPresent()) {
                    incompat.add(land.get());
                }
            }
            landen.get(i).setIncompatibel(incompat);
        }        

        //Collections.reverse(ploegen);
    }

    public Optional<Land> getLandOpNaam(String naam) {
        for (Land l : landen) {
           if (l.getNaam().equals(naam)) {
               return Optional.of(l);
           }    
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "Indeling{" + "ploegen=" + ploegen + ", landen=" + landen + ", poules=" + poules + '}';
    }

    /**
     * @return the ploegen
     */
    public ArrayList<Ploeg> getPloegen() {
        return ploegen;
    }

    /**
     * @return the landen
     */
    public ArrayList<Land> getLanden() {
        return landen;
    }

    /**
     * @return the poules
     */
    public ArrayList<Poule> getPoules() {
        return poules;
    }

    
}
