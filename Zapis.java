package cz.itnetwork;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Zapis {
    private Databaze databaze;

    public Zapis(Databaze databaze) {
        this.databaze = databaze;
    }

    public void pridatOsobu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Zadejte jméno osoby: ");
        String jmeno = scanner.nextLine();
        System.out.print("Zadejte příjmení osoby: ");
        String prijmeni = scanner.nextLine();
        System.out.print("Zadejte věk osoby: ");
        int vek = scanner.nextInt();
        scanner.nextLine(); // Pro vyčištění bufferu
        System.out.print("Zadejte telefonní číslo osoby: ");
        String telefonniCislo = scanner.nextLine();

        Clovek novaOsoba = new Clovek(jmeno, prijmeni, vek, telefonniCislo);
        databaze.pridatOsobu(novaOsoba);

        System.out.println("Osoba byla úspěšně přidána.");
    }

    public void zobrazitVsechnyOsoby() {
        List<Clovek> vsechnyOsoby = databaze.getSeznamOsob();

        if (vsechnyOsoby.isEmpty()) {
            System.out.println("V seznamu nejsou žádné osoby.");
            return;
        }

        System.out.println("Seznam všech osob:");
        for (Clovek osoba : vsechnyOsoby) {
            System.out.println(osoba);
        }
    }

    public void vyhledatOsobu(String hledaneJmeno, String hledanePrijmeni) {
        List<Clovek> nalezeniLide = databaze.vyhledatOsoby(hledaneJmeno, hledanePrijmeni);

        if (nalezeniLide.isEmpty()) {
            System.out.println("Osoba s tímto jménem a příjmením nebyla nalezena.");
            return;
        }

        System.out.println("Nalezené osoby:");
        for (Clovek osoba : nalezeniLide) {
            System.out.println(osoba);
        }
    }
}
