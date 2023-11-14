/* World class for modeling the entire in-game world
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Room extends Space {
Space entry = new Space("Start Room");
  private String description;

  private HashMap<String, Room> exits;
  private HashMap<String, Item> items;

  //Constructor som tager et string som argument. Laver Room objekt med en beskrivelse
  //og et exit hashmap som indeholder en string som referer til room objekter som spilleren can gå ind i.
  public Room(){
    super();
    this.description = description;
    exits = new HashMap<String, Room>();
    items = new HashMap<String, Item>();
  }



  //metode som mapper exits med direction til næste room. Ved at kalde denne metode can det defineres hvilket exit
  //som Room har, ved at give direction til det næste room og et roomobjekt.
  public void setExit(String direction, Room neighbor){
    exits.put(direction, neighbor);
  }

  //getter metode til description
  public String getShortDescription(){
    return description;
  }

  //getter metod til description
  public String getLongDescription(){
    return "Du er ved " +  description + ".\n" + getExitString();
  }

  //getter method for telling the player what exits that are currently available
  private String getExitString() {
    String returnString = "udgang:";
    Set<String> keys = exits.keySet();
    for (String exit : keys) {
      returnString += " " + exit;
    }
    return returnString;
  }

  //getter method for getting the exit directions. Used in "Game" in the goRoom method.
  public Room getExit(String direction) {
    return exits.get(direction);
  }

  //adds item-object to items-array in a given room
  public void addItem(String description, Item item) {
    items.put(description, item);
  }
  //removes item-object from items-array in a given room
  public void removeItem(Item item) {
    items.remove(item);
  }


  //runs the getName() method from item-class to return the name-attribute of the item
  public String getName(Item item) {
    return item.getName();
  }

  //fetches the item-array in the given room
  public HashMap<String, Item> getItems() {
    return items;
  }

  //sets an item in a given room array to another item
  public void setItems(HashMap<String, Item> items) {
    this.items = items;
  }
  //prints out the items in a given room by getting the items name-attributes and adding these to a string (by using concat) which is returned
  public String printItems(HashMap items) {
    String itemstring = new String();
    if (this.items.isEmpty()) {
      System.out.println("Du har samlet alt skrald her, Flot!.");
    } else {
      System.out.println("I dette rum er der følgende skrald: ");
      Iterator iter = items.entrySet().iterator();
      while (iter.hasNext()) {
        HashMap.Entry entry = (HashMap.Entry) iter.next();
        itemstring = itemstring.concat(entry.getKey().toString() + " ");
      }
    }
    return itemstring;
  }

  /*class Room {
    Space entry;

    Room() {
      Space startRoom = new Space("Strand\n - Du høre en skildpadde råbe efter hjælp");
      Space beachTurtle = new Space("Strand\n - en skildpadde sidder fast i skrald");
      Space trashSort = new Space("Sorteringsrum");
      Space beachTrash = new Space("Strand fyldt med skrald");
      Space ocean = new Space("Hav med skrald\n - flotte koraller er viklet ind i skrald");
      Space oilRig = new Space("Boreplatform hav\n - havet er forurenet af olie og skrald");
      Space plasticIslands = new Space("Hav med store plastikøer");
      Space endRoom = new Space("Flot ren strand\n - Skildpadde takker dig for din gode indsats og hjælp");


      startRoom.addEdge("fremad", beachTurtle);
      beachTurtle.addEdge("skraldespande", trashSort);
      beachTurtle.addEdge("fremad", beachTrash);
      beachTurtle.addEdge("hav", ocean);
      beachTurtle.addEdge("fremad", beachTrash);
      beachTrash.addEdge("skraldespande", trashSort);
      beachTrash.addEdge("fremad", beachTrash);
      beachTrash.addEdge("hav", ocean);
      beachTrash.addEdge("tilbage", beachTurtle);
      beachTrash.addEdge("fremad", endRoom);
      trashSort.addEdge("strand", beachTrash);
      ocean.addEdge("venstre", plasticIslands);
      ocean.addEdge("fremad", oilRig);
      ocean.addEdge("strand", beachTrash);
      oilRig.addEdge("tilbage", ocean);
      plasticIslands.addEdge("tilbage", ocean);
      endRoom.addEdge("tilbage", beachTrash);

      this.entry = startRoom;

    }*/


    Space getEntry() {
      return entry;
    }
  }

