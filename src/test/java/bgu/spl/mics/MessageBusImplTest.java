/*package test.java.bgu.spl.mics;

import main.java.bgu.spl.mics.MessageBusImpl;
import main.java.bgu.spl.mics.MicroService;
import main.java.bgu.spl.mics.application.messages.AttackEvent;
import main.java.bgu.spl.mics.application.messages.DeactivationBroadcast;
import main.java.bgu.spl.mics.application.messages.DeactivationEvent;
import main.java.bgu.spl.mics.application.passiveObjects.Attack;
import main.java.bgu.spl.mics.application.passiveObjects.Ewok;
import main.java.bgu.spl.mics.application.services.*;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class MessageBusImplTest {
    private MessageBusImpl m= MessageBusImpl.getMessageBusImpl();

    @BeforeEach
    public void setup(){
        m= m.getMessageBusImpl();
       // m=new MessageBusImpl();
    }


    @Test
    //in this test c3po subscribed to deactivation attackEvent. we created an instance of
    // AttackEvent and sent the event and the end we made sure the event remained the same
    //we checked: subscribeEvent, sendEvent ,register
    public void Event() {
        AttackEvent a=new AttackEvent();
        C3POMicroservice c=new C3POMicroservice();
        m.register(c);
        m.subscribeEvent(AttackEvent.class,c);
        m.sendEvent(a);
        AttackEvent a1;
        try {
            a1 = (AttackEvent) m.awaitMessage(c);
            assertTrue(a.equals(a1));
        }
        catch (InterruptedException e){
            assertTrue(false);
        }
        m.unregister(c);
    }

    @Test
    //in this test lando subscribed to deactivation broadcast. we created an instance of
    // deactivation broadcast and sent th e broadcast and the end we made sure the broadcast remained the same
    //we checked: subscribebroadcast, sendBroadcast ,register
    public void BroadcastOneReceiver() {
        LandoMicroservice L=new LandoMicroservice(1);
        DeactivationBroadcast b=new DeactivationBroadcast();
        m.register(L);
        m.subscribeBroadcast(DeactivationBroadcast.class,L);
        m.sendBroadcast(b);

        DeactivationBroadcast b2;
        try {
             b2 = (DeactivationBroadcast) m.awaitMessage(L);
            assertTrue(b.equals(b2));
        }
        catch (InterruptedException e){
            assertTrue(false);
        }

        m.unregister(L);
    }


    @Test
    //complete resolves the future of deactivation which should trigger the deactivation broadcast,
    //then we make sure that landao received the broadcast
    public void complete(){

        LandoMicroservice L=new LandoMicroservice(1);
        m.register(L);
        m.subscribeBroadcast(DeactivationBroadcast.class,L);
        DeactivationEvent d=new DeactivationEvent();
        m.complete(d,true);

        try {
            DeactivationBroadcast b2 = (DeactivationBroadcast) m.awaitMessage(L);
            assertTrue(true);
        }
        catch (InterruptedException e){
            assertTrue(false);
        }
        m.unregister(L);

    }



    @Test
    public void unregisterWithSubscribed() {
        LandoMicroservice L=new LandoMicroservice(1);
        DeactivationBroadcast b=new DeactivationBroadcast();
        m.register(L);
        m.subscribeBroadcast(DeactivationBroadcast.class,L);
        m.unregister(L);
        m.sendBroadcast(b);

        try {
            m.awaitMessage(L);
            assertTrue(false);
        }
        catch (IllegalStateException e){
            assertTrue(true);
        }
        catch (InterruptedException d){
            assertTrue(false);
        }

    }

    @Test
    public void unregisterWithoutSubscribed() {

        LandoMicroservice L=new LandoMicroservice(1);
        DeactivationBroadcast b=new DeactivationBroadcast();
        m.register(L);
        m.unregister(L);
        m.sendBroadcast(b);

        try {
            m.awaitMessage(L);
        }
        catch (IllegalStateException e){
            assertTrue(true);
        }
        catch (InterruptedException d){
            assertTrue(false);
        }

        fail();
    }




}*/