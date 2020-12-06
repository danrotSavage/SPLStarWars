package main.java.bgu.spl.mics.application.services;

import main.java.bgu.spl.mics.Message;
import main.java.bgu.spl.mics.MicroService;
import main.java.bgu.spl.mics.application.messages.AttackEvent;
import main.java.bgu.spl.mics.application.messages.DeactivationBroadcast;
import main.java.bgu.spl.mics.application.messages.DeactivationEvent;
import main.java.bgu.spl.mics.application.messages.DestroyTheSITH;
import main.java.bgu.spl.mics.application.passiveObjects.Ewoks;

/**
 * R2D2Microservices is in charge of the handling {@link DeactivationEvent}.
 * This class may not hold references for objects which it is not responsible for:
 * {@link DeactivationEvent}.
 *
 * You can add private fields and public methods to this class.
 * You MAY change constructor signatures and even add new public constructors.
 */
public class R2D2Microservice extends MicroService {
    private long sleepTime;
    public R2D2Microservice(long duration) {
        super("R2D2");
        sleepTime=duration;
    }



    @Override
    protected void initialize() {
        subscribeBroadcast(DeactivationBroadcast.class,(DeactivationBroadcast d)->{
            try {
                Thread.sleep(sleepTime);
            }catch (Exception e){}
            sendBroadcast(new DestroyTheSITH());
            terminate();
        });
    }
}
