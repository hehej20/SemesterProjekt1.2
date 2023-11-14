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

//Her lægges ting i inventory. 2 parametre: 'item'=navnet af item
//og 'quantity'=hvor mange der lægges derind af det givne item.
//Den tjekker om 'item' allerede eksistere i inventory, for så at increase quantity eller lave en ny entry derinde
    /*public void addItemToInventory(String item, int quantity) {
        if (inventory.containsKey(item)) {
            int currentQuantity = inventory.get(item);
            inventory.put(item, currentQuantity + quantity);
        } else {
            inventory.put(item, quantity);
        }
    }

    //denne metode kan fjerne ting fra inventory.
//Den tjekker om item er i inventory og om quantity er større eller lig med den nuværende quantity=fjern item helt
//Ellers decreaser then quantity for item.
    public void removeItemFromInventory(String item, int quantity) {
        if (inventory.containsKey(item)) {
            int currentQuantity = inventory.get(item);
            if (currentQuantity - quantity <= 0) {
                inventory.remove(item);
            } else {
                inventory.put(item, currentQuantity - quantity);
            }
        }
    }

    //Printer players inventory. Den iterere gennem items i inventory og printer navn og quantity.
    public void displayInventory() {
        System.out.println("Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

} */
//MAIN. Opretter player objekt og ligger items i players inventory, diplayer inventory
//fjerner item og displayer den opdaterede inventory

//import java.util.ArrayList;
//public class InventoryManager {
//private List<InventoryItem> inventory;

   /* public InventoryManager() {
        inventory = new ArrayList<>();
    }

    public void addItemToInventory(String itemName, int quantity) {
        // Check if the item already exists in the inventory
        for (InventoryItem item : inventory) {
            if (item.getName().equals(itemName)) {
                // If it exists, increase the quantity
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        // If the item doesn't exist, create a new item and add it to the inventory
        InventoryItem newItem = new InventoryItem(itemName, quantity);
        inventory.add(newItem);
    }

    public void removeItemFromInventory(String itemName, int quantity) {
        for (InventoryItem item : inventory) {
            if (item.getName().equals(itemName)) {
                int currentQuantity = item.getQuantity();
                if (currentQuantity - quantity <= 0) {
                    // If the quantity becomes zero or negative, remove the item from the inventory
                    inventory.remove(item);
                } else {
                    // Otherwise, decrease the quantity
                    item.setQuantity(currentQuantity - quantity);
                }
                return;
            }
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (InventoryItem item : inventory) {
            System.out.println(item.getName() + ": " + item.getQuantity());
        }
    }

    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItemToInventory("Metal", 1);
        inventoryManager.addItemToInventory("Toxic Waste", 4);
        inventoryManager.addItemToInventory("Plastic", 3);
        inventoryManager.addItemToInventory("Oil", 5);

        inventoryManager.displayInventory();

        inventoryManager.removeItemFromInventory("Oil", 2);

        inventoryManager.displayInventory();
    }
}

class InventoryItem {
    private String name;
    private int quantity;

    public InventoryItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}



/*public class Inventory {
    public List<Trash> items = new ArrayList<>();


    //construktor som kan initialisere inventory
    public Inventory() {
    }

    //Læg items ind i inventory
    public void addItem(Trash item) {
        items.add(item);
    }

    //fjern ting fra inventory
    public void removeItem(Trash item) {
        items.remove(item);
    }

    public void display() {
        System.out.println("\n\nInventory: ");
        if (items.isEmpty()) {
            System.out.println("tomt");
            return;
        }
        HashMap<String, Integer> inventoryItemCount = new HashMap<>();
        for (Trash item : items) {
            if (!inventoryItemCount.containsKey(item.getType())) {
                inventoryItemCount.put(item.getType(), 1);
            } else {
                inventoryItemCount.replace(item.getType(), inventoryItemCount.get(item.getType()) + 1);
            }
        }
        for (String key : inventoryItemCount.keySet()) {
            System.out.println(" > " + key + " - " + inventoryItemCount.get(key));
        }
    }

    //print inventory
   // public void display(){
        //System.out.println("Inventory: ");
        //for (Trash item : items){
            //System.out.println("-> "+item.Trash()) //ved fandme ikke lige hvad jeg gør her tbh
        //}
    // Kan man ikke bare get. inventory her?

        public ArrayList<Trash> getInventory () {
        //get.inventory og måske have noget visuelt til det også
       return inventory;
    }
     */

//}

    /*public List<Trash> getItems() {
        return items;
    }

}*/



