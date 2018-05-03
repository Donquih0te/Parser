package donquih0te;

import java.util.ArrayList;
import java.util.List;

public class Changelog implements Observable {

    private List<Observer> observers;
    private String title;
    private String url;

    public Changelog() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach((k) -> k.update(title, url));
    }

    public void setData(String title, String url) {
        this.title = title;
        this.url = url;
        notifyObservers();
    }

}
