public class SommaPariArrayTIZIANO {

    public static void main(String[] args) {
        int somma = 0 ; 
        int[] numeri = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : numeri) {
            if (i%2==0) {
                System.out.println("il numero " + i + " è pari ed è aggiunto alla somma \n");
                somma += i;
                System.out.println("la somma è " + somma + "\n");
            } else {
                System.out.println("il numero " + i + " è dispari e non è aggiunto alla somma \n");
            }
        }
    }
}