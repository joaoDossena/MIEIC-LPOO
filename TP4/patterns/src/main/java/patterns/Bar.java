package patterns;

import java.util.ArrayList;
import java.util.List;

public abstract class Bar
{
    protected List<BarObserver> observers;
    protected boolean happyHour;

    public Bar() { this.happyHour = false; this.observers = new ArrayList<>(); }

    public abstract boolean isHappyHour();
    public abstract void startHappyHour();
    public abstract void endHappyHour();

    public void addObserver(BarObserver observer) { observers.add(observer); }

    public void removeObserver(BarObserver observer) { observers.remove(observer); }

    public void notifyObservers()
    {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }


}
