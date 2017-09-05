package data_generator1;

import java.sql.Date;
import java.util.Random;

public class generator {
	
	//interval for new sample in ms
	private int interval; 
	//maximal deviation from interval
	private int deviationPercentage = 5;
	//time
	private int time = 0;
	//start price
	private float price = 1;
	
	private boolean stop;
	private Random rand;

	
	//infinite loop for generating data
	private void infiniteLoopOfData() throws InterruptedException {
		//interval is not static - is deviated little bit
		int delta = 0;
		
		rand = new Random();
		
		while(!stop) {
			Thread.sleep(interval - delta);
			//calcualte time
			time = time + (interval - delta);
			//calculate next delta deviation
			delta = rand.nextInt(interval/100*deviationPercentage);
			
			price = price + (rand.nextFloat() * (rand.nextBoolean() ? 1 : -1));
			
			System.out.println("("+(time)+")"+price);
		}
	}
	
	public generator() throws InterruptedException {
		// TODO Auto-generated constructor stub
		
		//default interval
		interval = 1000;
		
		//pause is enabled at beginning
		stop = false;
	
		//start generating
		infiniteLoopOfData();
	}
	
	public static void main(String args[]) {
        try {
			new generator();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	

}
