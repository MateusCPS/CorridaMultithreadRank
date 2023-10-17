package RaceCondition;

public class Rank{
	
	int size, rankPosition;
	int[] rank;
	
	public Rank(int _size) {
		size = _size;
		rank = new int[size];
	}
	
	public void SetRank(int id) 
	{
		this.rank[this.rankPosition] = id;
		this.rankPosition++;
	}
	
	public void GetRank() {
		for(int i = 0; i < size; i++) {
			System.out.println("Na posicao " + i + " ficou o Carro " + rank[i]);
		}
	}
	
}
