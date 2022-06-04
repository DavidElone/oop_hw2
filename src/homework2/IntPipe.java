package homework2;
import java.util.ArrayList;


public class IntPipe extends BlackOrWhiteNode<E> implements Simulatable <E> {
	private ArrayList<int> enterQueue = new ArrayList<int>();
	private ArrayList<int> readyQueue = new ArrayList<int>();
	
	// Abstraction Function:
	// IntPipe is a black node in the graph that transfers the inputs to the output
	
	// Rep. invariant:
	// field from BlackOrWhiteNode isBlack = true
	
    private void checkRep()
    {
		assert this.isBlack == true;
    }
	
	/**
     * @modifies this
     * @effects Constructs a new Pipe with color = black
     */
	public IntPipe(String label) {
		super(label, true);
		checkRep();
		
	}
	
	/**
	 * @returns enter works queue
	 */	
	public ArrayList<int> getEnterQueue() {
		checkRep();
		return this.enterQueue;
	}
	
	/**
	 * @returns ready works queue
	 */	
	public ArrayList<int> getReadyQueue() {
		checkRep();
		return this.readyQueue;
	}
	
	
	/**
	 * @modifies this
	 * @effects removes and returns the first element in readyQueue
	 */	
	public int popReadyQueue() {
		if (readyQueue.size() == 0)
			//TODO add exception
		
		int res = readyQueue.get(0);
		readyQueue.remove(0);
		checkRep();
		return res;
	}
	
	/**
	 * @modifies this
	 * @effects add a work object to the queue of this pipe
	 */	
	public void addToEnterQueue(int newWork) {
		enterQueue.add(newWork);
		checkRep();
	}
	
	
	/**
	 * @effects Simulates this pipe in a the graph graph_.
	 *			Transfers all elements in entry queue to the ready queue.
	 */	
	public void simulate(BipartiteGraph<E> graph_) 
	{
		for (int i = 0; i < enterQueue.size(); i++) { 
            readyQueue.add(enterQueue.get(i));
        }
		enterQueue.clear();
		
	}
	
}
