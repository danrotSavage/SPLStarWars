package main.java.bgu.spl.mics.application.passiveObjects;


import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Passive object representing the resource manager.
 * <p>
 * This class must be implemented as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add ONLY private methods and fields to this class.
 */
public class Ewoks {

     private static  Ewoks ewoks;

     private Ewok[] ewokArray;

     private Ewoks(int count)
     {
         ewokArray=new Ewok[count];
         for (int i=0;i<count;i++){
             ewokArray[i]=new Ewok(i);
         }
     }

     public static synchronized Ewoks getEwoks(int count){
         if(ewoks==null){
             ewoks=new Ewoks(count);
         }
         return ewoks;
     }
     public static synchronized Ewoks getEwoks() {
        return ewoks;
     }



     public synchronized void fetchEwok(List<Integer> count){
        for (int i=0;i<count.size();i++){
            while (!ewokArray[count.get(i)].isAvailable()){
               try {
                   this.wait();
                   i=0;
               }catch (InterruptedException e){}
            }
        }
        for (int i=0;i<count.size();i++) {
            ewokArray[count.get(i)].acquire();
        }



     }
}
