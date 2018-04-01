
package memorymenagment;
import java.util.HashMap;
import java.util.Map;

public class Memory {

	private int size;
	private Map<Integer, Boolean> memory;

	public Memory(int size) {
		this.size = size;
		memory = new HashMap<>();

		for (int i = 0; i < size; i++) {
			memory.put(i, true);
		}
		memory.replace(3, false);
		memory.replace(5, false);
	}

	/**
	 * Allocates a memory block of given size and with given strategy.
	 *
	 * @param size
	 *            the size in bytes
	 * @param fit
	 *            0 = first fit, 1 = best fit
	 *
	 * @return a memory block, null, if problems
	 *
	 */
	public Block allocate(int size, int fit) {
		Block block = null;
		boolean full = false;
		switch (fit) {
		case 0:
			for (int i = 0; i < memory.size(); i++) {
				for (int j = 0; j < size; j++) {
					if (!memory.get(j + i)) {
						i = j + i;
						full = true;
						break;
					}
					if (!full && j == size - 1) {
						for (int ii = i; ii < size + i; ii++) {
							memory.replace(ii, false);
						}
						block = new Block(i, size);
						return block;
					}
				}
				full = false;
			}

			break;
		case 1:
			break;
		}

		return block;
	}

	/**
	 * Deallocates a memory block.
	 *
	 * @param block
	 *            a memory block
	 * 
	 * @return true, if successful
	 *
	 */
	public boolean deallocate(Block block) {

		// ToDo:
		return true;
	}

	/**
	 * Returns the free memory size in bytes.
	 *
	 * @return the number of free bytes
	 *
	 */
	public int getFree() {
		return 0;
	}

	public void print() {
		for (Map.Entry<Integer, Boolean> entry : memory.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

}
