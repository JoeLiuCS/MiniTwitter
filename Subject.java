package app;

import java.util.LinkedList;
import java.util.List;


public class Subject {
	private List<Observer> l = new LinkedList<>();
	public void attach(Observer observer) {
        l.add(observer);
    }
    
    public void detach(Observer observer) {
        l.remove(observer);
    }
    protected void notifyObs(){
        for (Observer observer : l){
            observer.update(this);
        }
    }
    
}
