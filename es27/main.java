public class main {
    public static void main(String[] args) {
        Leone leone = new Leone("emanuele");

        String specie = leone.getSpecieAnimale();
        String ordine = leone.getOrdineAnimale();
        String nomeProprio = leone.getNomeProprioAnimale();
        leone.print();
        System.out.println("/n fatto nella classe " + specie + " " + ordine+ " " + nomeProprio);
    }

}
