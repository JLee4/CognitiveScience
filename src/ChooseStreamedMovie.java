import personas.Persona1;
import personas.Persona2;
import personas.Persona3;
import personas.Persona4;

import static java.lang.System.exit;

public class ChooseStreamedMovie {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.print("When you run this, you must input a <number> corresponding to a persona." +
                    "\nExample: \"java ChooseStreamedMovie 1\" for running the task with Personas");
            exit(0);
        }

        // This if-else block populates the system with objects corresponding to whichever persona the user chooses.
        // Then the executive takes over and runs through the simulated task.
        if (args[0].equals("1")) {
            Executive.initializePersona1();
        } else if (args[0].equals("2")) {
            Executive.initializePersona2();
        } else if (args[0].equals("3")) {
            Executive.initializePersona3();
        } else if (args[0].equals("4")) {
            Executive.initializePersona4();
        } else {
            System.out.println("You must input a valid number from 1 to 4 as an argument.");
            exit(0);
        }
    }
}
