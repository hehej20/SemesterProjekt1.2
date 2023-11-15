/* public class Tasks extends Room {
    String taskDescription;
    String rewardMsg;
    private int timers = 30;
    private int taskCount;
    static boolean timeUp = false;

    Tasks (String taskDescription, String rewardMsg)
    HashMap<String, Room> taskDescription = new HashMap()

    public Tasks (String taskDescription, String rewardMsg, String description) {
        super(description);
        // super(String description, String rewardMsg);
        // initialize the timer as needed.
        this.taskDescription = taskDescription;
        this.rewardMsg = rewardMsg;
        if (getRoomName().equals("oil")) {
            startTimer();
        }
    }


    public String getTaskDescription() {
        return taskDescription;
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
*/