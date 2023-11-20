/* Main class for launching the game


import java.util.ArrayList;
import java.util.Scanner;


class Game {
  static Room room    = new Room("description");
  static PointSystem pointSystem = new PointSystem();
  static ArrayList<String> inventory = new ArrayList<>();
  static Context  context  = new Context(room.getEntry());
  static Command  fallback = new CommandUnknown();
  static Registry registry = new Registry(context, fallback);
  static Scanner  scanner  = new Scanner(System.in);
  static Trash trash = new Trash();
  private Room entry;
  private Room currentRoom;




  private static void initRegistry () {
    registry.register("quit", new CommandExit());
    registry.register("gå", new CommandGo());
    registry.register("help", new CommandHelp(registry));
    //Ikke helt sikker på at nedenstående skal bruges endnu
    //registry.register("tag", new CommandGrabItem());
    //registry.register("sorter", new CommandSortTrash());
  }

  public Room startRoom, beach, ocean, oil, plasticIsland;
  private void createRooms(String description){

    startRoom = new Room("start rum");

    beach = new Room("stranden");

    ocean = new Room("havet");

    oil = new Room("olie og giftig affald flyder ud i havet");

    plasticIsland = new Room("plastik 'øer' ude i havet");


    entry.addEdge("frem", startRoom);
    entry.setExit("frem", startRoom);

    startRoom.setExit("frem", beach);



    beach.setExit("frem", ocean);
    beach.setExit("venstre", oil);
    beach.setExit("tilbage", startRoom);

    ocean.setExit("frem", plasticIsland);
    ocean.setExit("tilbage", beach);


    oil.setExit("tilbage", beach);

    plasticIsland.setExit("tilbage", ocean);

    //beach items instantiated
    Item plastik = new Item("plastik","en plastik flaske");
    Item metal = new Item("metal", "en metal dåse");

    //add items to beach
    beach.addItem("plastik", plastik);
    beach.addItem("metal", metal);

    //Ocean items instantiated
    Item ocplastik = new Item("plastik", "en plastik flaske");
    Item ocmetal = new Item("metal", "en metal dåse");

    //add items to ocean
    ocean.addItem("plastik", plastik);
    ocean.addItem("metal", metal);
currentRoom = entry;
  }
  public static void main (String args[]) {
    System.out.println("Velkommen til stranden! Hjælp skildpadden med opgaverne og sorter skrald for at få point :)\n Du kan skrive gå+lokation for at bevæge dig rundt!");


    initRegistry();
    context.getCurrent().welcome();

    inventory.add("plastik");
    inventory.add("metal");
    inventory.add("giftigt affald");
    inventory.add("plastik");
    inventory.add("metal");
    inventory.add("metal");

    trash.sortTrash();

    while (context.isDone()==false) {
      System.out.print("> ");
      String line = scanner.nextLine();
      registry.dispatch(line);
    }
    System.out.println("Game Over 😥");

  }
}
 */

import java.util.Scanner;

class Game {
  private Room entry;
  private PointSystem pointSystem = new PointSystem();
  private Room currentRoom;
  //private ArrayList<String> inventory;
  private Context context;
  private Command fallback;
  private Registry registry;
  private Scanner scanner;

  public static InventoryManager inventory = new InventoryManager();
  public Game() {
    entry = new Room("Description"); // Initialisering af Entry
    //inventory = new ArrayList<>();
    context = new Context(entry);
    fallback = new CommandUnknown();
    registry = new Registry(context, fallback);
    scanner = new Scanner(System.in);

    createRooms();
    initRegistry();

    context.getCurrent().Welcome();
    String[] startInventory = {"plastik", "metal", "giftigt affald", "plastik", "metal", "metal"};
    for (String item : startInventory) {
      inventory.addItem(item);
    }
   // Trash trash = new Trash();
    //trash.sortTrash();//Skal først kaldes i sorteringsrummet

    while (!context.isDone()) {
      System.out.print("> ");
      String line = scanner.nextLine();
      registry.dispatch(line);
    }
    System.out.println("Game Over 😥");
  }

  private void initRegistry() {
    registry.register("quit", new CommandExit());
    registry.register("gå", new CommandGo());
    registry.register("help", new CommandHelp(registry));
    //Ikke helt sikker på at nedenstående skal bruges endnu
    registry.register("tag", new CommandGrabItem());
    //registry.register("sorter", new CommandSortTrash());
  }

  private void createRooms() {
    Room startRoom = new Room("Start Room");
    entry.addEdge("frem", startRoom);

    Room beach = new Room("stranden");
    Room ocean = new Room("havet");
    Room oil = new Room("olie og giftigt affald flyder i havet");
    Room plasticIsland = new Room("plastik 'øer' ude i havet");
    Room sorteringsRum = new Room("sorteringsrum");

    startRoom.addEdge("frem", beach);

    beach.addEdge("frem", ocean);
    beach.addEdge("venstre", oil);
    beach.addEdge("tilbage", startRoom);

    ocean.addEdge("frem", plasticIsland);
    ocean.addEdge("tilbage", beach);

    oil.addEdge("tilbage", beach);

    plasticIsland.addEdge("tilbage", ocean);
    plasticIsland.addEdge("frem", sorteringsRum);


    // beach items instantiated
    Item plastik = new Item("plastik", "en plastik flaske");
    Item metal = new Item("metal", "en metal dåse");

    // add items to beach
    beach.addItem("plastik", plastik);
    beach.addItem("metal", metal);

    // Ocean items instantiated
    Item ocPlastik = new Item("plastik", "en plastik flaske");
    Item ocMetal = new Item("metal", "en metal dåse");

    // add items to ocean
    ocean.addItem("plastik", ocPlastik);
    ocean.addItem("metal", ocMetal);

    currentRoom = entry;
  }
  public static void main(String args[]) {
    System.out.println("Velkommen til stranden! Hjælp skildpadden med opgaverne og sorter skrald for at få point :)\n Du kan skrive gå+lokation for at bevæge dig rundt!");
    new Game();
  }
}
