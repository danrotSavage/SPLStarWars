package main.java.bgu.spl.mics.application.messages;

import main.java.bgu.spl.mics.Event;

public class DeactivationEvent implements Event<Integer> {
    public Integer getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Integer i) {
        this.sleepTime = i;
    }

    private Integer sleepTime;


}
