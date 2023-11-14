/* Main class for launching the game
 */

import java.util.ArrayList;
import java.util.Scanner;

class Game {
  static World    world    = new World();
  static PointSystem pointSystem = new PointSystem();
  static ArrayList<String> inventory = new ArrayList<>();
  static Context  context  = new Context(world.getEntry());
  static Command  fallback = new CommandUnknown();
  static Registry registry = new Registry(context, fallback);
  static Scanner  scanner  = new Scanner(System.in);
  static Trash trash = new Trash();

  private static void initRegistry () {
    registry.register("quit", new CommandExit());
    registry.register("gå", new CommandGo());
    registry.register("help", new CommandHelp(registry));
    //Ikke helt sikker på at nedenstående skal bruges endnu
    //registry.register("tag", new CommandGrabItem());
    //registry.register("sorter", new CommandSortTrash());
  }
  
  public static void main (String args[]) {
    System.out.println("Velkommen til stranden! Hjælp skildpadden med opgaverne og sorter skrald for at få point :)");
    
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
