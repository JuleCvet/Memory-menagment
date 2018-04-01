package memorymenagment;
public class Main {

	public static void main(String[] args) {

//		Block block = new Block(200, 20);
//		System.out.println(block);
		
		Memory m1 = new Memory(17);
		
		m1.allocate(4, 0);
		m1.print();

		
	}

}
