/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ses.poules;

import java.util.Objects;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
/**
 *
 * @author u0002531
 */
public class Ploeg {
    private String naam;
    private Land land;
    public boolean geplaatst;

    public Ploeg(String naam, Land land) {
        this.naam = naam;
        this.land = land;
        this.geplaatst = FALSE;
    }


    
    
    @Override
    public String toString() {
        return "Ploeg{" + "naam=" + naam + ", land=" + land.getNaam() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.naam);
        hash = 29 * hash + Objects.hashCode(this.land);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ploeg other = (Ploeg) obj;
        if (!Objects.equals(this.naam, other.naam)) {
            return false;
        }
        if (!Objects.equals(this.land, other.land)) {
            return false;
        }
        return true;
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @return the land
     */
    public Land getLand() {
        return land;
    }
    
    
}
