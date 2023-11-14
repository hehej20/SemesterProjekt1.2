/* Main class for launching the game
 */

import java.util.ArrayList;
import java.util.Scanner;


class Game {
  static Room room    = new Room();
  static PointSystem pointSystem = new PointSystem();
  static ArrayList<String> inventory = new ArrayList<>();
  static Context  context  = new Context(room.getEntry());
  static Command  fallback = new CommandUnknown();
  static Registry registry = new Registry(context, fallback);
  static Scanner  scanner  = new Scanner(System.in);
  static Trash trash = new Trash();
  private Room entry;




  private static void initRegistry () {
    registry.register("quit", new CommandExit());
    registry.register("gå", new CommandGo());
    registry.register("help", new CommandHelp(registry));
    //Ikke helt sikker på at nedenstående skal bruges endnu
    //registry.register("tag", new CommandGrabItem());
    //registry.register("sorter", new CommandSortTrash());
  }

  public Room startRoom, beach, ocean, oil, plasticIsland;
  private void createRooms(){

    startRoom = new Room();

    beach = new Room();

    ocean = new Room();

    oil = new Room();

    plasticIsland = new Room();

    entry.addEdge("frem", startRoom);

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
