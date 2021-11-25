public class Gameplay {
    public static void main(String[] args) {
        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);

        System.out.println(bob);
        System.out.println(heath);
        System.out.println(albert);
        System.out.println(angel);

        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut sus = new RedAstronaut("Suspicious Person", 100, "expert");

        System.out.println(liam);
        System.out.println(sus);

        System.out.println("GAME START");
        System.out.println("");

        // 1
        System.out.println('1');
        liam.sabotage(bob);
        System.out.println(bob);
        // 2
        System.out.println('2');
        liam.freeze(sus);
        System.out.println(sus);
        // 3
        System.out.println('3');
        liam.freeze(albert);
        System.out.println(liam);
        System.out.println(albert);
        // 4
        System.out.println('4');
        albert.emergencyMeeting();
        // 5
        System.out.println('5');
        sus.emergencyMeeting();
        // 6
        System.out.println('6');
        bob.emergencyMeeting();
        System.out.println(sus);
        // 7
        System.out.println('7');
        heath.completeTask();
        System.out.println(heath);
        // 8
        System.out.println('8');
        heath.completeTask();
        System.out.println(heath);
        // 9
        System.out.println('9');
        heath.completeTask();
        System.out.println(heath);
        // 10
        System.out.println("10");
        liam.freeze(angel);
        System.out.println(angel);
        System.out.println(liam);
        // 11
        System.out.println("11");
        liam.sabotage(bob);
        System.out.println(bob);
        liam.sabotage(bob);
        System.out.println(bob);
        // 12
        System.out.println("12");
        liam.freeze(bob);
        System.out.println(bob);
        // 13
        System.out.println("13");
        angel.emergencyMeeting();
    }
}
