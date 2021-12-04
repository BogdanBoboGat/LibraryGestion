import java.util.*;

public class PublishingRetailer {
    String ID;
    String name;
    List <IPublishingArtifact> publishingArtifacts;
    List <Country> countries;

    public PublishingRetailer(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.publishingArtifacts = new ArrayList<>();
        this.countries = new ArrayList<>();
    }
}
