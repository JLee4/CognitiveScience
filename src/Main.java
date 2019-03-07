import static java.lang.System.exit;

//This class invokes the executive and starts the cognitive task depending on user input
//Essentially, this class is the entry point for the entire project
public class Main {

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            System.out.print("When you run this, you must input a <number> corresponding to a persona." +
                    "\nExample: \"java Main 1\" for running the task with Persona1");
            System.out.println("Run java Main help for list of example commands");
            exit(0);
        }
        if (args[0].equals("help")) {
            System.out.println("Run cognitive task: java Main <PersonaNumber>");
            System.out.println("Run cognitive task with verbose output: java Main <PersonaNumber> -verbose");
            exit(0);
        }
        //Verbose means that the more trivial details like movie attributes and cast member attributes
        boolean isVerbose = false;
        if (args.length == 2 && args[1].equals("-verbose")) {
            isVerbose = true;
        }
        // This if-else block populates the system with objects corresponding to whichever persona the user chooses.
        // Then the executive takes over and runs through the simulated task.
        int personaNum = 0;
        boolean runAll = false;
        if (args[0].equals("all")) {
            runAll = true;
        } else {
            try {
                personaNum = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid persona number, you inputted a non-number");
                exit(0);
            }
        }
        Executive.executive(personaNum, isVerbose, runAll);
    }
}
