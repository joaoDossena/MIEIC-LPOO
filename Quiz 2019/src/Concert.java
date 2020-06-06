import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    private String city;
    private String country;
    private String date;
    private List<Act> acts = new ArrayList<>();
    private int id;

    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
        this.id = 1;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    public List<Act> getActs() {
        return acts;
    }

    public int getId() {
        return id;
    }

    public void incrementId() {
        this.id++;
    }

    public void addAct(Act act)
    {
        if(!(this.acts.contains(act)))
            this.acts.add(act);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(city, concert.city) &&
                Objects.equals(country, concert.country) &&
                Objects.equals(date, concert.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date);
    }

    public boolean isValid(Ticket ticket)
    {
        return this.equals(ticket.getConcert());
    }

    public boolean participates(Artist artist)
    {
        for(Act act : this.acts)
        {
            if(act.getClass() == Band.class)
            {
                Band band = (Band) act;
                if(band.containsArtist(artist)) return true;
            }
            if(act.getClass() == Artist.class)
                if(act.equals(artist)) return true;

        }
        return false;
    }
}
