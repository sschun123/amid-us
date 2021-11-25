import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    private int numTasks;
    private int taskSpeed;
    private boolean isTasksFinished = false;

    public BlueAstronaut(String name) {
        this(name, 15, 6, 10);
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public boolean getIsTasksFinished() {
        return isTasksFinished;
    }

    public void setIsTasksFinished(boolean finished) {
        isTasksFinished = finished;
    }

    public int getNumTasks() {
        return this.numTasks;
    }

    public int getTaskSpeed() {
        return this.taskSpeed;
    }

    public void setNumTasks(int numTasks) {
        if (numTasks < 0) {
            this.numTasks = 0;
            return;
        }
        this.numTasks = numTasks;
    }

    @Override
    public void completeTask() {
        // TODO Auto-generated method stub
        if (this.isFrozen()) {
            return;
        }

        if (this.getTaskSpeed() > 20) {
            this.setNumTasks(this.getNumTasks() - 2);
        } else {
            this.setNumTasks(this.getNumTasks() - 1);
        }

        if (this.getNumTasks() == 0 && !getIsTasksFinished()) { // HOW TO CHECK FIRST TIME?!
            System.out.println("I have completed all my tasks");
            this.setIsTasksFinished(true);
            this.setSusLevel((int) (this.getSusLevel() + this.getSusLevel() * .5));
        }
    }

    public boolean equals (Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut blueAstronaut = (BlueAstronaut) o;
            if (
                this.getName().equals(blueAstronaut.getName()) &&
                this.getSusLevel() == blueAstronaut.getSusLevel() &&
                this.isFrozen() == blueAstronaut.isFrozen() &&
                this.getNumTasks() == blueAstronaut.getNumTasks() &&
                this.getTaskSpeed() == blueAstronaut.getTaskSpeed()
            ) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String frozenString = this.isFrozen() ? "frozen" : "not frozen";
        String formatted = String.format("My name is %s, and I have a susLevel of %d. I am currently %s. I have %d left over.", this.getName(), this.getSusLevel(), frozenString, this.getNumTasks());
        if (this.getSusLevel() > 15) {
            return formatted.toUpperCase();
        }
        return formatted;
    }
    
    @Override
    public void emergencyMeeting() {
        if (this.isFrozen()) {
            return;
        }
        Player[] allPlayers = getPlayers();
        Arrays.sort(allPlayers);
        Player mostSus = allPlayers[allPlayers.length - 1];
        int i = allPlayers.length - 1;

        while (i >= 0) {
            mostSus = allPlayers[i];
            if (!mostSus.isFrozen() && !mostSus.equals(this)) {
                if (mostSus.compareTo(allPlayers[i - 1]) == 0) {
                    break;
                }
                mostSus.setFrozen(true);
                break;
            }
            i--;
        }
        
        gameOver();
    }
}
