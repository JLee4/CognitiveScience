This code project simulates the cognitive task of selecting a movie to watch where the movie is hosted
on a streaming website like Netflix or Hulu.

The output is prints out every decision that is made where the decisions are determined by the characteristics of the
user and their preference for a movie. The printed lines are the internal monologue of a persona we created based
on the data we analyzed from interviews. We created personas to simulate interviewees where their individual
preferences are instantiated in a User object.

Personas are contained in the persona package and named Persona<number>.
Each persona class creates a User object in createUser(). The User object represents the persona's individual preferences.
PopulateMovies contains the instantiation of Film objects that represent a movie/film.
Schemas are contained in the schemas package and represents the mental schemas we created from our analysis.
Finally, the Executive class in the top-level directory is the executive schema that makes decisions based on current state
and the state of the User/persona representation.

Main is an entry point for Java to run and interprets the arguments from the command line.
This has little relevance to the decision-making but we separated it from the overall schema as it is a Java-specific thing.

Instructions:
1) Compile the java files (not necessary if using an IDE that supports running Java)
2) If using an IDE, you select Run Configurations -> add Main.java as the main class -> add program arguments i.e. <Persona Number>
3) Run the Main class with "java Main <Persona Number>" where persona number corresponds to number listed in the persona package.
    (Currently, there is a total of 5 personas.)
3) Or if you want to run all the personas, then run the Main class with "java Main all" or edit the arguments to just "all"
4) If you want to see the pretty printed details of the movies and the user objects,
    run the Main class with "java Main <Persona Number> -verbose" or "java Main all -verbose".
    (if using an IDE, then add " -verbose", this is case sensitive)