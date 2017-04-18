package com.qingzu.observerPattem;

import com.qingzu.observerPattem.Subject;

/**
 * Created by Administrator on 2017/4/18.
 */

public class ApplicationSubject extends Subject {
    public void exit() {
        noifyObservers();
    }
}
