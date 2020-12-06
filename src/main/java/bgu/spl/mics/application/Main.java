package main.java.bgu.spl.mics.application;

import com.google.gson.Gson;
import main.java.bgu.spl.mics.application.passiveObjects.Attack;
import main.java.bgu.spl.mics.application.passiveObjects.Ewok;
import main.java.bgu.spl.mics.application.passiveObjects.Ewoks;
import main.java.bgu.spl.mics.application.services.*;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import java.util.List;

/** This is the Main class of the application. You should parse the input file,
 * create the different components of the application, and run the system.
 * In the end, you should output a JSON.
 */
public class Main {
	public static void main(String[] args) {

		List<Integer> attackList=new LinkedList<>();
		attackList.add(2);
		attackList.add(4);
		Attack a = new Attack(attackList,500);
		Attack b = new Attack(attackList,1000);
		Attack [] attackArray = {a,b};

		C3POMicroservice c3 = new C3POMicroservice();
		LeiaMicroservice lea = new LeiaMicroservice(attackArray);
		HanSoloMicroservice han = new HanSoloMicroservice();
		R2D2Microservice r2 = new R2D2Microservice(2000);
		LandoMicroservice lando = new LandoMicroservice(1000);
		Ewoks.getEwoks(5);

		Thread one = new Thread(lea);
		Thread two = new Thread(c3);
		Thread three = new Thread(han);
		Thread four = new Thread(r2);
		Thread five = new Thread(lando);

		one.start();
		two.start();
		three.start();
		four.start();
		five.start();


		Gson gson=new Gson();
		String json = gson.toJson(new Ewok(2));
		System.out.println(json);
	}
}
