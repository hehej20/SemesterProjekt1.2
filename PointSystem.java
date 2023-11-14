public class PointSystem {
    private static final int POINTS_PER_CORRECT_SORT = 2; //Constant bruget til repræsentere værdien for hvert korrekt sortede affald.
    private int points; //Instance variable til at holde styr på antal point samlet for player.

    public PointSystem() { //constructor for PointSystem
        points = 0;
    }

    public void sortTrashCorrect () { //Methode der bruges til at opdatere points samlet af player.
        points += POINTS_PER_CORRECT_SORT; //Når affaldet er sorteret korrekt, så stiger points variablen med 'points_per_correct_sort'
    }

    public int getPoints() {//Metode brugt til at få adgang til det aktuelle antal point.
        return points;
    }

    public static void main(String[] args) { //Main metode til at teste funktionaliteten af 'Pointsystem'
        PointSystem pointSystem = new PointSystem(); //Opretter en instance for 'PointSystem' klassen.

        pointSystem.sortTrashCorrect(); //Sorter affaldet korrekt for at øge det indsamlet point.

        System.out.println("Current Points: " + pointSystem.getPoints()); //Print the nuværende antal point playeren har.
    }
}