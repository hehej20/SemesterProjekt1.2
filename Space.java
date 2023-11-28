/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.HashMap;
import java.util.Set;

class Space extends Node {
  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  private String taskDescription;

  private String rewardMessage;

  private Tasks tasks = new Tasks(taskDescription, rewardMessage);

  private HashMap<String, Tasks> taskMessages = new HashMap<>();

  private Room room;
  public Space (String name) {
    super(name);

  }
  
  public void welcome () {
    System.out.println("Du er nu ved "+name);
    Set<String> exits = edges.keySet();
    System.out.println("Mulige veje at gå er:");
    for (String exit: exits) {
      System.out.println(" - "+exit);
    }
    this.getRoom().printItems();
  }
  public void goodbye () {
  }
  public void addExit(String direction, Space destination) {
    addEdge(direction, destination);
    }
  
  @Override
  public Space followEdge (String direction) {
    return (Space) (super.followEdge(direction));
  }

  public void Welcome() {
  }
}
