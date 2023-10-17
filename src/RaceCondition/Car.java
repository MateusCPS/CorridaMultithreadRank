package RaceCondition;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Car extends Thread{
	int id, vel, dist, traveledDist;
	float accel;
	int finalDistance;
	long finalTime, initialTime;
	boolean alreadFinished = false;
	Random rd = new Random();
	Semaphore sem = new Semaphore(1);
	Rank rank;
 	
	public Car(int _id, int _finalDistance, int _size, Rank _rank) 
	{
		id = _id;
		finalDistance = _finalDistance;
		rank = _rank;
	}
	
	public void run() 
	{
		race();
	}
	
	private void race()
	{
		if(alreadFinished != true) {
			while(traveledDist < finalDistance) {
				initialTime = System.currentTimeMillis();
				RandomAccelerator();
				vel = (int) (vel + (accel * finalTime));
				
				dist = (int) (vel * finalTime);
				traveledDist += dist;
				
				if(traveledDist > 0)
				{
					System.out.println("Carro " + id + " Andou " + dist + "m e ja percorreu: " + traveledDist + "m");
				}
				finalTime += System.currentTimeMillis() - initialTime;
				
				
				if(traveledDist >= finalDistance) {
					System.out.println("Carro " + id + " Chegou ao seu destino");
					this.alreadFinished = true;
					try {
						sem.acquire();
						rank.SetRank(id);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sem.release();
				}
			}
		}
	}
	
	private void RandomAccelerator() 
	{
		this.accel = rd.nextInt(10) + 1;
	}
}
