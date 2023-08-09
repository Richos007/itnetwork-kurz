package cz.itnetwork;

import java.util.ArrayList;
import java.util.List;

class Databaze {
    private List<Clovek> seznamOsob;

    public Databaze() {
        seznamOsob = new ArrayList<>();
    }

    public void pridatOsobu(Clovek osoba) {
        seznamOsob.add(osoba);
    }

    public List<Clovek> getSeznamOsob() {
        return seznamOsob;
    }

    public List<Clovek> vyhledatOsoby(String hledaneJmeno, String hledanePrijmeni) {
        List<Clovek> nalezeniLide = new ArrayList<>();
        for (Clovek osoba : seznamOsob) {
            if (osoba.getJmeno().startsWith(hledaneJmeno) && osoba.getPrijmeni().startsWith(hledanePrijmeni)) {
                nalezeniLide.add(osoba);
            }
        }
        return nalezeniLide;
    }
}
