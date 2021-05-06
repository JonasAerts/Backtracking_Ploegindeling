/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ses.poules;

import java.util.ArrayList;

/**
 *
 * @author u0002531
 */
public class Land {
    private String naam;
    private int maxAantal;
    private ArrayList<Land> incompatibel;

    public Land(String naam, int maxAantal) {
        this.naam = naam;
        this.maxAantal = maxAantal;

    }

    public Land(String naam, int maxAantal, ArrayList<Land> incompatibel) {
        this.naam = naam;
        this.maxAantal = maxAantal;
        this.incompatibel = incompatibel;
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @return the maxAantal
     */
    public int getMaxAantal() {
        return maxAantal;
    }

    /**
     * @return the incompatibel
     */
    public ArrayList<Land> getIncompatibel() {
        return incompatibel;
    }

    /**
     * @param incompatibel the incompatibel to set
     */
    public void setIncompatibel(ArrayList<Land> incompatibel) {
        this.incompatibel = incompatibel;
    }

    @Override
    public String toString() {
        return "Land{" + "naam=" + naam + ", maxAantal=" + maxAantal + ", incompatibel=" + incompatibel + '}';
    }
    
}
