/* Main class for launching the game
 */

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
  private Room currentRoom;




  private static void initRegistry () {
    registry.register("quit", new CommandExit());
    registry.register("gå", new CommandGo());
    registry.register("help", new CommandHelp(registry));
    //Ikke helt sikker på at nedenstående skal bruges endnu
    //registry.register("tag", new CommandGrabItem());
    //registry.register("sorter", new CommandSortTrash());
  }

  public Room entry, startRoom, beach, ocean, oil, plasticIsland;
  private void createRooms(String description){

    entry = new Room("entry");

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
