/* World class for modeling the entire in-game world
 */

class World {
  Space entry;
  
  World () {
    Space startRoom = new Space("Strand\n - Du høre en skildpadde råbe efter hjælp", 2, new Tasks("", ""));
    Space beachTurtle = new Space("Strand\n - en skildpadde sidder fast i skrald", 4, new Tasks("Hjælp skildpadden ned til vandet ved at fjerne alt skraldet", "Tak for hjælpen! Vidste du:\n - For hvert minut der går bliver der smidt hvad der svarer til en fyldt skraldebil i havet\n - https://wwf.org.au/blogs/plastic-pollution-is-killing-sea-turtles-heres-how/"));
    Space trashSort = new Space("Sorteringsrum", 0, new Tasks("", "Sorter dit skrald i dette rum"));
    Space beachTrash = new Space("Strand fyldt med skrald", 6, new Tasks("Denne strand er fyldt med skrald! gør rent på den forurenede strand", "Lige præcis, godt arbejde!!! - Vidste du:\n - 52% af alle skildpadder har spist plastik\n - 92% af skildpadder som indvikles i kasseret fiskeudstyr dør\n - https://wwf.org.au/blogs/plastic-pollution-is-killing-sea-turtles-heres-how/"));
    Space ocean = new Space("Hav med skrald\n - flotte koraller er viklet ind i skrald", 3, new Tasks("Åhhh nej. De flotte koraller er viklet ind i skrald og fiskeudstyr. Hjælp mig med at gør mit hjem rent", ""));
    Space oilRig = new Space("Bordeplatform hav\n - havet er forurenet af olie og skrald", 4, new Tasks("", ""));
    Space plasticIslands = new Space("Hav med store plastikøer", 4, new Tasks("", ""));
    Space endRoom = new Space("Flot ren strand\n - Skildpadde takker dig for din gode indsats og hjælp", 0, new Tasks("", ""));


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

