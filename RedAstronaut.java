import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    private String skill;

    private static String DEFAULT_SKILL = "experienced";
    private static int DEFAULT_SUS_LEVEL = 15;

    public RedAstronaut(String name) {
        this(name, DEFAULT_SUS_LEVEL, DEFAULT_SKILL);
    }
    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase();
    }

    public String getSkill() {
        return skill;
    }

    public String toString() {
        String frozenString = this.isFrozen() ? "frozen" : "not frozen";
        String formatted = String.format("My name is %s, and I have a susLevel of %d. I am currently %s. I am an %s player!", this.getName(), this.getSusLevel(), frozenString, this.getSkill());
        if (this.getSusLevel() > 15) {
            return formatted.toUpperCase();
        }
        return formatted;
    }

    public boolean equals (Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut redAstronaut = (RedAstronaut) o;
            if (
                this.getName().equals(redAstronaut.getName()) &&
                this.getSusLevel() == redAstronaut.getSusLevel() &&
                this.isFrozen() == redAstronaut.isFrozen() &&
                this.getSkill().equals(redAstronaut.getSkill())
            ) {
                return true;
            }
        }
        return false;
    }

    public void sabotage(Player p) {
        if (this.isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }

        if (this.getSusLevel() < 20) {
            p.setSusLevel((int) (p.getSusLevel() + p.getSusLevel() * .5));
        } else {
            p.setSusLevel((int) (p.getSusLevel() + p.getSusLevel() * .25));
        }
    }

    public void freeze(Player p) {
        if (this.isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }

        if (this.compareTo(p) < 0) {
            p.setFrozen(true);
        } else {
            this.setSusLevel(this.getSusLevel() * 2);
        }

        gameOver();
    }

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
