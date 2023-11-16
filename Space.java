/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.Set;

class Space extends Node {
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
