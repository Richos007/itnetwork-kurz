package cz.itnetwork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("__________________");
        System.out.println("Evidence pojiěných");
        System.out.println("==================");
        System.out.println("");
        Databaze databaze = new Databaze();
        Zapis zapis = new Zapis(databaze);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Vyberte si akci: ");
            System.out.println("");
            System.out.println("1 - Přidat pojištěného");
            System.out.println("2 - Zobrazit všechny pojištěné");
            System.out.println("3 - Vyhledat pojiětěného");
            System.out.println("4 - konec");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Pro vyčištění bufferu

            switch (choice) {
                case 1:
                    zapis.pridatOsobu();
                    break;

                case 2:
                    zapis.zobrazitVsechnyOsoby();
                    break;

                case 3:
                    System.out.print("Zadejte jméno osoby: ");
                    String hledaneJmeno = scanner.nextLine();
                    System.out.print("Zadejte příjmení osoby: ");
                    String hledanePrijmeni = scanner.nextLine();
                    zapis.vyhledatOsobu(hledaneJmeno, hledanePrijmeni);
                    break;

                case 4:
                    System.out.println("Ukončuji aplikaci.");
                    return;

                default:
                    System.out.println("Neplatná volba.");
                    break;
            }

            System.out.print("Pro pokračování stiskněte enter ...");
            try {
                System.in.read(); // Čeká na stisk klávesy
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}