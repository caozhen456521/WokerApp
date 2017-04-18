package com.qingzu.observerPattem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */

public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void noifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }

    }
}

