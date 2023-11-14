import java.util.Timer;
import java.util.TimerTask;

public class Tasks {
    String description;
    String rewardMsg;
    boolean isComplete = false;
    private int timers;
    private int trashCount;
    private int taskCount;


    public Tasks (String description, String rewardMsg) {
        // initialize the taskCount, trashCount and timer as needed.
        this.description = description;
        this.rewardMsg = rewardMsg;
        taskCount = 0 ;
        trashCount = 0;
        timers = 30;
    }

    public String getTaskMessage() {
        if (isComplete) return "\nOpgave: " + rewardMsg;
        else return "\nOpgave: " + description;
    }

    public String getDescription() {
        return description;
    }
    public void taskComplete () {
        // Kaldes når opgaven er udført
        if (trashCount == 10 ) {
            // taskCount stiger når en task er complete
            taskCount++;
            // trashCount resets when task is complete
            trashCount = 0;

        }
        isComplete = true;
    }

    public void trashCollected () {
        // When player collects trash, call this method to increment trashCount
        trashCount++;
    }

    public void startTimer (){
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                timers--;
                if (timers == 0){
                    System.out.println("Time is up! :)");
                    taskComplete();
                    timer.cancel();

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
