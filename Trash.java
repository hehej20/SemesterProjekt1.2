import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Trash {

    // Test fra Nikolai's side
    //private final String trashType;
    //private final String sortCat;



    public Trash(/*String type, String sortCat*/) {
        //this.trashType = type;
        //this.sortCat = sortCat;
    }
    static PointSystem pointSystem = new PointSystem();

    /*public String getType() {
        return trashType;
    }
    public String getSortType() {
        return sortCat;
    }

     */

    //@Override
    //public String toString() {
        //return getType();


    public void sortTrash() {
        ArrayList<String> inventory = Game.inventory.getInventory();
        Collections.shuffle(inventory);
        for (int i = 0; i < inventory.size(); i++) {
            // Opret en scanner for hver opsamlet affald i vores inventory.Array

            //Print: skriv hvilken slags trash det her er
            String input = "metal, plastik, giftigt affald, olie";
            Scanner scanned = new Scanner(System.in).useDelimiter(",");
            String readFromScan = scanned.nextLine();


            // Check for om det er den rigtige affaldstype. If/else statement
            if ("metal".equals(readFromScan) && i >= 0 && i < inventory.size() && "metal".equals(inventory.get(i))) {
                System.out.println("Det er korrekt! Denne affaldstype er metal!");
                System.out.println("Vidste du at 95% af alt metal bliver genbrugt? " +
                        "Derfor er det vigtigt at vi samler det op");
                pointSystem.sortTrashCorrect(); //Kalder sortTrashCorrect, når affaldet er sorteret korrekt.

            } else if (("plastik".equals(readFromScan) && i >= 0 && i < inventory.size() && "plastik".equals(inventory.get(i)))) {
                System.out.println("Det er korrekt! Denne affaldstype er plastik!");
                System.out.println("Vidste du at danskerne er nogen af dem, som producerer mest affald pr. indbygger?" +
                        "\n Derfor er det vigtigt for os alle at gøre en indsats for at rydde op igen");
                pointSystem.sortTrashCorrect(); //Kalder sortTrashCorrect, når affaldet er sorteret korrekt.

            } else if (("giftigt affald".equals(readFromScan) && i >= 0 && i < inventory.size() && "giftigt affald".equals(inventory.get(i)))) {
                System.out.println("Det er korrekt! Denne affaldstype er giftigt affald!");
                System.out.println("Disse giftige sager indkluderer ætsende, kræftfremkaldende, giftigt, brandfarligt eller eksplosivt affald" +
                        "\n Det hører ikke hjemme i naturen, da det virkelig kan have en indvirkning på biodiversiteten");
                pointSystem.sortTrashCorrect(); //Kalder sortTrashCorrect, når affaldet er sorteret korrekt.

            } else if (("olie".equals(readFromScan) && i >= 0 && i < inventory.size() && "olie".equals(inventory.get(i)))) {
                System.out.println("Det er korrekt! Denne affaldstype er olie!");
                System.out.println("Vidste du at olie er hydrofob? Olien frastøder derfor vand og der sker en lagdeling" +
                        "\n Olie er upolær og afskyr vand, derfor kan det ikke opløses");
                pointSystem.sortTrashCorrect(); //Kalder sortTrashCorrect, når affaldet er sorteret korrekt.

            } else {
                System.out.println("Beklager... Det forstod jeg desværre ikke");
                i--;
            }

        }

    }
}