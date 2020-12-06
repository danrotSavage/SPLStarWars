package main.java.bgu.spl.mics.application.messages;
import main.java.bgu.spl.mics.Event;
import main.java.bgu.spl.mics.application.passiveObjects.Attack;

public class AttackEvent implements Event<Attack> {
    public Attack getAttack() {
        return attack;
    }

    private Attack attack;

	public AttackEvent(Attack a){
	    attack=a;
    }



}
