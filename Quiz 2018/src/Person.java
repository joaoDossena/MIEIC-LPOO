import java.util.Objects;

public abstract class Person extends User implements Comparable {
    protected String name = "";
    protected int age = 0;

    public Person(String name) { this.name = name; }
    public Person(String name, int age) { this.name = name; this.age = age; setUsername(this.name + this.age);}

    public String getName() { return this.name; }
    public int getAge() { return this.age; }

    @Override
    public boolean equals(Object o)
    {
        if(o == this) return true;
        if(!(o instanceof Person)) return false;
        Person person = (Person) o;
        return (person.name == this.name);
    }

    /*@Override
    public int hashCode() { return Objects.hash(this.name, this.age); }*/

    @Override
    public int compareTo(Object o)
    {
        Person person = (Person) o;
        return person.getName().compareTo(this.name);
    }
}
