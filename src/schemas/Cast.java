package schemas;

import java.util.ArrayList;
import java.util.List;

public class Cast {

    private Director director;
    private List<CastMember> producers;
    private List<Actor> actors;

    public Cast(Director director) {
        this.director = director;
        this.producers = new ArrayList<>();
        this.actors = new ArrayList<>();
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<CastMember> getProducers() {
        return producers;
    }

    public void addProducer(CastMember producer) {
        this.producers.add(producer);
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }
}
