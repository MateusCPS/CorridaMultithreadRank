package RaceCondition;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int nThreads = 5;
		int maxDistance = 10;
		Car[] car = new Car[nThreads];
		Rank rank = new Rank(nThreads);
		
			// TODO Auto-generated method stub
			for(int i = 0; i < nThreads; i++) {
				car[i] = new Car(i, maxDistance, nThreads, rank);
				car[i].start();
			}

			for(int i = 0; i < nThreads; i++) {
				car[i].join();
			}
			rank.GetRank();
		}

}
