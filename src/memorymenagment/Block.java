package memorymenagment;

public class Block {

	private int start;
	private int size;

	public Block(int start, int size) {
		this.start = start;
		this.size = size;
	}

	public int getStart() {
		return start;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "[" + start + "," + size + "]";
	}
	
	

}
