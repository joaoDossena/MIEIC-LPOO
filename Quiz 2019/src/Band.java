import java.util.ArrayList;
import java.util.List;

public class Band extends Act{
    private List<Artist> artists = new ArrayList<>();

    public Band(String name, String country) { super(name, country); }

    public List<Artist> getArtists() { return artists; }

    public void addArtist(Artist artist)
    {
        if(!(this.artists.contains(artist)))
            this.artists.add(artist);
    }

    public boolean containsArtist(Artist artist) { return this.artists.contains(artist); }

}
