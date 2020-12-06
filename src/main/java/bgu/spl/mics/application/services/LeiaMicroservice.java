package main.java.bgu.spl.mics.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import main.java.bgu.spl.mics.Event;
import main.java.bgu.spl.mics.Message;
import main.java.bgu.spl.mics.MessageBusImpl;
import main.java.bgu.spl.mics.MicroService;
import main.java.bgu.spl.mics.application.messages.AttackEvent;
import main.java.bgu.spl.mics.application.messages.DeactivationBroadcast;
import main.java.bgu.spl.mics.application.messages.DeathStarDestroyed;
import main.java.bgu.spl.mics.application.passiveObjects.Attack;

/**
 * LeiaMicroservices Initialized with Attack objects, and sends them as  {@link AttackEvent}.
 * This class may not hold references for objects which it is not responsible for:
 * {@link AttackEvent}.
 *
 * You can add private fields and public methods to this class.
 * You MAY change constructor signatures and even add new public constructors.
 */
public class LeiaMicroservice extends MicroService {
	private Attack[] attacks;
    public LeiaMicroservice(Attack[] attacks) {
        super("Leia");
		this.attacks = attacks;
    }

    @Override
    protected void initialize() throws ExecutionException, InterruptedException {
        subscribeBroadcast(DeathStarDestroyed.class,(DeathStarDestroyed d)->{
            this.terminate();
        });
        AttackEvent r = new AttackEvent(new Attack(new ArrayList<>(),12));
        MessageBusImpl m = MessageBusImpl.getMessageBusImpl();
        for (int i = 0; i < attacks.length; i++) {
            System.out.println("Lea sent att " + i);
            AttackEvent e = new AttackEvent(attacks[i]);


        }
        for (int i = 0; i < attacks.length; i++) {


        }
        sendBroadcast(new DeactivationBroadcast() );
    }
}
