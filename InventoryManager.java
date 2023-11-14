//importere de packages der skal bruges
import java.util.ArrayList;


//definition af player klassen. Inventory er en hashmap hvor keys er strings.
//string key er item navnet(olie etc) og integer er antallet af items for hvert key.
public class InventoryManager {
    private String item;
    private int quantity;


    static ArrayList<String> inventory = new ArrayList<>();
    static Trash trash = new Trash();


    //Initialiser inventory som et nyt hashmap(et tomt) når en player objekt er lavet.
    public InventoryManager() {
        this.item = item;
        this.quantity = quantity;
    }
    public ArrayList<String> getInventory() {
        return inventory;
    }
    public void addItem(String name, int quantity) {
        this.item = name;
        this.quantity = quantity;
    }
    public static void main (String [] args) {
        inventory.add("plastik");
        inventory.add("plastik");
        inventory.add("plastik");
        inventory.add("metal");
        inventory.add("olie");
        trash.sortTrash();
    }
}





