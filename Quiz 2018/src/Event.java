import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Event {
    protected String title = "";
    protected String date = "";
    protected String description = "";
    protected List<Person> people = new ArrayList<>();

    public Event(String title) { this.title = title; }

    public Event(String title, String date) { this.title = title; this.date = date; }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public Event(Event e) {
        this.title = e.getTitle();
        this.date = e.getDate();
        this.description = e.getDescription();
    }


    public String getTitle() {
        return this.title;
    }
    public String getDate() {
        return this.date;
    }
    public String getDescription() {
        return this.description;
    }
    public List<Person> getPeople() { return this.people; }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }
    public void setDate(String date) { this.date = date; }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.title + " is a " + this.description + " and will be held at " + this.date + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Event)) return false;

        return ((Event) o).title == this.title
                && ((Event) o).date == this.date
                && ((Event) o).description == this.description;
    }

    public void addPerson(Person p) {
        if(!this.people.contains(p))
            this.people.add(p);
    }

    public int getAudienceCount() { return this.people.size(); }

    public void addEvent(Event e){
        for(Person person : e.getPeople())
            this.addPerson(person);
    }

    /*@Override
    public int hashCode() { return Objects.hash(this.title, this.date, this.description); }*/
}