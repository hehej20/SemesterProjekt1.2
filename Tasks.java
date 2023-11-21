import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Tasks {
    private String taskDescription;
    private String rewardMessage;

    private PointSystem pointSystem = new PointSystem();

    private int timers = 30;

    private boolean timeUp = false;
    private int taskCount;

    private HashMap<String, Tasks> taskMessages = new HashMap<>();

    // initialize the timer.

    /*Skriv det her i main
    Tasks.addTasksToMap();
    Tasks.getTaskDescriptionByKey("stranden"); */

    // constructor
    public Tasks (String taskDescription, String rewardMessage) {
        this.taskDescription = taskDescription;
        this.rewardMessage = rewardMessage;
        }

    // metode til at tilføje navn på rummet + beskeder til HashMap
    public void addTasksToMap(String key, Tasks tasks) {
        taskMessages.put("stranden", new Tasks("Åh nej! Alle skildpaddeungerne kan ikke komme ned til vandet for alt det skrald, hjælp dem sikkert ned i vandet ved at fjerne skraldet", "Tak for hjælpen!"));
        taskMessages.put("sorteringsrum", new Tasks("Sorter dit skrald, så det bliver genbrugt og ikke ender på stranden igen", ""))
    }


    public String getTaskDescriptionByKey(String key) {
        Tasks task = taskMessages.get(key);
        if (task != null) {
            return task.taskDescription;
        } else {
            return "Der er ingen opgaver her";
        }
    }

    public String getRewardMessageByKey(String key) {
        Tasks task = taskMessages.get(key);
        if (task != null && task != sorteringsrum) {
            taskMessages.remove(key);
            taskCount++;
            return task.rewardMessage;
        } else {
            return "";
        }
    }


    // det her er en tråd
    public void startTimer (){
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                timers--;
                if (timers != 0) {
                    System.out.print("Du har " + timers + " sekunder tilbage");
                }
                if (timers == 0){
                    System.out.println("Time is up! :)");
                    getRewardMessageByKey("oil");
                    timer.cancel();
                    timeUp = true;
                }
            }
        };
        timer.schedule(task,0,1000);

    }


    public int getTaskCount() {
        return taskCount;
    }


    public void endGame() {
        // alle tasks er complete. Task counter.
        System.out.println("Game Completed! WELL DONE!");
        System.out.println("total point = " + pointSystem.getPoints());


    }

}
