package main.java.bgu.spl.mics.application.services;

import main.java.bgu.spl.mics.Callback;
import main.java.bgu.spl.mics.Message;
import main.java.bgu.spl.mics.MicroService;
import main.java.bgu.spl.mics.application.messages.AttackEvent;
import main.java.bgu.spl.mics.application.messages.DeactivationBroadcast;
import main.java.bgu.spl.mics.application.passiveObjects.Attack;
import main.java.bgu.spl.mics.application.passiveObjects.Ewoks;


/**
 * C3POMicroservices is in charge of the handling {@link AttackEvent}.
 * This class may not hold references for objects which it is not responsible for:
 * {@link AttackEvent}.
 *
 * You can add private fields and public methods to this class.
 * You MAY change constructor signatures and even add new public constructors.
 */
public class C3POMicroservice extends MicroService {
	Callback callback;
    public C3POMicroservice() {
        super("C3PO");
    }


    @Override
    protected void initialize() {
        subscribeEvent(AttackEvent.class,(AttackEvent attack)-> {
                    System.out.println("C3PO call back called");
            Ewoks e = Ewoks.getEwoks();

            e.fetchEwok(attack.getAttack().getSerials());

            try {
                Thread.sleep((long) attack.getAttack().getDuration());
            }catch (Exception ex){}

            complete(attack,attack.getAttack());
        }
        );
        System.out.println("C3PO was initialized");
        subscribeBroadcast(DeactivationBroadcast.class,(DeactivationBroadcast d)->{
            this.terminate();
        });
    }



}
