package es29;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Persona mario = new Persona("mario", "a150");
        Esame esame1 = new EsameRadiologico("32451", "radiologico", 3, "GAMBA rotta", true, 4);
        Esame esame2 = new EsameSangue("52534", "sangue", 2, "pazienteDiabetico", true, 230);
        // EsameRadiologico esame3 = new EsameRadiologico("32451", "radiologico", 3, "GAMBA rotta", true, 4);
        // EsameSangue esame4 = new EsameSangue("52534", "sangue", 2, "pazienteDiabetico", true, 230);
        // EsameRadiologico esame5 = new EsameRadiologico("32451", "radiologico", 3, "GAMBA rotta", true, 4);
        // EsameSangue esame6 = new EsameSangue("52534", "sangue", 2, "pazienteDiabetico", true, 230);
        // EsameRadiologico esame7 = new EsameRadiologico("32451", "radiologico", 3, "GAMBA rotta", true, 4);
        // EsameSangue esame8 = new EsameSangue("52534", "sangue", 2, "pazienteDiabetico", true, 230);
        // EsameRadiologico esame9 = new EsameRadiologico("32451", "radiologico", 3, "GAMBA rotta", true, 4);
        // EsameSangue esame10 = new EsameSangue("52534", "sangue", 2, "pazienteDiabetico", true, 230);

        mario.addEsame(esame1);
        mario.addEsame(esame2);
        mario.visualizzaDettagliEsame();

        Scanner tastiera = new Scanner(System.in);
        System.out.println("digita id esame da cercare");
        String idEsameDaCercare = tastiera.nextLine();
        mario.cercaEsame(idEsameDaCercare);
        tastiera.close();
    }
}
