package schemas;

import java.util.List;

public class GroupMember extends User {

    /**
     * This class is to add group preferences to an overall agent.
     * This object doesn't select movies but only provide preferences to the main agent
     */
    public GroupMember(List<Genre> preferredGenres, int minimumRating, List<Actor> likedActors,
                       List<Book> readBooks, List<Director> likedDirectors) {
        super(null, null, null, null, null, false, null,
                preferredGenres, null, minimumRating, likedActors, readBooks, likedDirectors);
    }
}
