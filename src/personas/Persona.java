package personas;

import schemas.User;

public abstract class Persona {

    private static User simulatedUser;

    public static void populate() {

    }

    public static User getSimulatedUser() {
        return simulatedUser;
    }

    public static void setSimulatedUser(User simulatedUser) {
        Persona.simulatedUser = simulatedUser;
    }
}
