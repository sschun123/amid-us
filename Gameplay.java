public class Gameplay {
    public static void main(String[] args) {
        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);


        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut sus = new RedAstronaut("Suspicious Person", 100, "expert");

        // 1
        liam.sabotage(bob);
        // 2
        liam.freeze(sus);
        // 3
        liam.freeze(albert);
        // 4
        albert.emergencyMeeting();
        // 5
        sus.emergencyMeeting();
        // 6
        bob.emergencyMeeting();
        // 7
        heath.completeTask();
        // 8
        heath.completeTask();
        // 9
        heath.completeTask();
        // 10
        liam.freeze(angel);
        // 11
        liam.sabotage(bob);
        liam.sabotage(bob);
        // 12
        liam.freeze(bob);
        // 13
        angel.emergencyMeeting();
    }
}
