import personas.Persona1;
import personas.Persona2;
import personas.Persona3;
import personas.Persona4;
import schemas.User;

import static java.lang.System.exit;

public class ChooseStreamedMovie {

    private static User user;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.print("When you run this, you must input a <number> corresponding to a persona." +
                    "\nExample: \"java ChooseStreamedMovie 1\" for running the task with Persona1");
            exit(0);
        }
        if (args[0].equals("1")) {

        } else if (args[0].equals("2")) {

        } else if (args[0].equals("3")) {

        } else if (args[0].equals("4")) {

        } else {
            System.out.println("You must input a valid number as an argument.");
            exit(0);
        }
    }
}
