package main.java.bgu.spl.mics.application.services;

import main.java.bgu.spl.mics.Broadcast;
import main.java.bgu.spl.mics.Callback;
import main.java.bgu.spl.mics.Message;
import main.java.bgu.spl.mics.MicroService;
import main.java.bgu.spl.mics.application.messages.DeactivationBroadcast;
import main.java.bgu.spl.mics.application.messages.DestroyTheSITH;

/**
 * LandoMicroservice
 * You can add private fields and public methods to this class.
 * You MAY change constructor signatures and even add new public constructors.
 */
public class LandoMicroservice  extends MicroService {
    private long sleepTime;
    public LandoMicroservice(long duration) {

        super("Lando");
        sleepTime=duration;
    }



    @Override
    protected void initialize() {
        subscribeBroadcast(DestroyTheSITH.class,(DestroyTheSITH d)->{
            try {
                Thread.sleep(sleepTime);
            }catch (Exception e){}
            terminate();
        });
    }







}
