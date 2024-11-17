package shared.observable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

abstract class Observable implements Serializable {
    private final List<IObserver> observers;

    public Observable() {
        observers = new ArrayList<>();
    }

    public final void register(IObserver observer){
        observers.add(observer);
    };

    public final void unregister(IObserver observer){
        observers.remove(observer);
    };

    public final void update() {
        List<IObserver> altList = new ArrayList<>(observers);

        for (IObserver observer: altList) {
            observer.update(this);
        }
    }
}
