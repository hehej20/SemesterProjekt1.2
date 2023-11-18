/* import java.util.HashMap;

public class Tasks {
    private String taskDescription;
    private String rewardMessage;

     private int timers = 30;
     private int taskCount;
    // static boolean timeUp = false;

    // initialize the timer.


    // constructor
    public Tasks (String taskDescription, String rewardMessage) {
        this.taskDescription = taskDescription;
        this.rewardMessage = rewardMessage;
        }

    // metode til at tilføje navn på rummet + beskeder til HashMap
    public void addTasksToMap(HashMap<String, Tasks> taskMessages) {
        taskMessages.put("stranden", new Tasks("Åh nej! Alle skildpaddeungerne kan ikke komme ned til vandet for alt det skrald", "Tak for hjælpen!"));
    }


    public String getTaskDescription () {
        return taskDescription;
    }


    public static String getTaskDescriptionByKey(String key, HashMap<String, Tasks> taskMessages) {
        Tasks task = taskMessages.get(key);
        if (task != null) {
            return task.getTaskDescription();
        } else {
            return "Der er ingen opgaveer her";
        }
    }

    // Kaldes når opgaven er udført
    public String taskComplete () {
            // taskCount stiger når en task er complete
            taskCount++;
            return rewardMessage;
    }


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
                    taskComplete();
                    timer.cancel();
                    // timeUp = true;
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
        System.out.println("total point = " + Game.pointSystem.getPoints());


    }

}
*/