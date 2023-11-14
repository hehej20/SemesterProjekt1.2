/* World class for modeling the entire in-game world
 */

class World {
  Space entry;
  
  World () {
    Space startRoom = new Space("Strand\n - Du høre en skildpadde råbe efter hjælp");
    Space beachTurtle = new Space("Strand\n - en skildpadde sidder fast i skrald");
    Space trashSort = new Space("Sorteringsrum");
    Space beachTrash = new Space("Strand fyldt med skrald");
    Space ocean = new Space("Hav med skrald\n - flotte koraller er viklet ind i skrald");
    Space oilRig = new Space("Bordeplatform hav\n - havet er forurenet af olie og skrald");
    Space plasticIslands = new Space("Hav med store plastikøer");
    Space endRoom = new Space("Flot ren strand\n - Skildpadde takker dig for din gode indsats og hjælp");


    startRoom.addEdge("fremmad", beachTurtle);
    beachTurtle.addEdge("skraldespande", trashSort);
    beachTurtle.addEdge("fremmad", beachTrash);
    beachTurtle.addEdge("hav", ocean);
    beachTurtle.addEdge("fremmad", beachTrash);
    beachTrash.addEdge("skraldespande", trashSort);
    beachTrash.addEdge("fremmad", beachTrash);
    beachTrash.addEdge("hav", ocean);
    beachTrash.addEdge("tilbage", beachTurtle);
    beachTrash.addEdge("fremmad", endRoom);
    trashSort.addEdge("strand", beachTrash);
    ocean.addEdge("venstre", plasticIslands);
    ocean.addEdge("fremmad", oilRig);
    ocean.addEdge("strand", beachTrash);
    oilRig.addEdge("tilbage", ocean);
    plasticIslands.addEdge("tilbage", ocean);
    endRoom.addEdge("tilbage", beachTrash);

    this.entry = startRoom;

  }
  
  Space getEntry () {
    return entry;
  }
}

