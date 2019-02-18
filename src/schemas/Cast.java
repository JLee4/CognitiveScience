package schemas;

import java.util.ArrayList;
import java.util.List;

public class Cast {

    private CastMember director;
    private List<CastMember> producers;
    private List<CastMember> actors;
    private List<CastMember> productionStaff;
    private List<CastMember> corporateStaff;

    public Cast(CastMember director) {
        this.director = director;
        this.producers = new ArrayList<>();
        this.actors = new ArrayList<>();
        this.productionStaff = new ArrayList<>();
        this.corporateStaff = new ArrayList<>();
    }

    public CastMember getDirector() {
        return director;
    }

    public void setDirector(CastMember director) {
        this.director = director;
    }

    public List<CastMember> getProducers() {
        return producers;
    }

    public void addProducer(CastMember producer) {
        this.producers.add(producer);
    }

    public List<CastMember> getActors() {
        return actors;
    }

    public void addActor(CastMember actor) {
        this.actors.add(actor);
    }

    public List<CastMember> getProductionStaff() {
        return productionStaff;
    }

    public void addProductionStaff(CastMember productionStaff) {
        this.productionStaff.add(productionStaff);
    }

    public List<CastMember> getCorporateStaff() {
        return corporateStaff;
    }

    public void addCorporateStaff(CastMember corporateStaff) {
        this.corporateStaff.add(corporateStaff);
    }
}
