import java.util.Timer;
import java.util.TimerTask;

public class Tasks extends Node{
    String description;
    String rewardMsg;
    boolean isComplete = false;
    private int timers = 30;
    private int taskCount;
    static boolean timeUp = false;


    public Tasks (String description, String rewardMsg) {
        super(name);
        // initialize the taskCount, trashCount and timer as needed.
        this.description = description;
        this.rewardMsg = rewardMsg;
        if (getName().equals("oilRig")) {
            startTimer();
        }
    }


    public String getDescription() {
        return description;
    }


    public void taskComplete () { // Kaldes når opgaven er udført
            // taskCount stiger når en task er complete
            taskCount++;
            System.out.println(rewardMsg);
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
        System.out.println("total point = " + Game.pointSystem.getPoints());


    }

}
