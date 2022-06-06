package homework2;
import java.util.ArrayList;


public class IntPipe extends BlackOrWhiteNode<String> implements Simulatable <String> {
	private ArrayList<Integer> enterQueue = new ArrayList<>();
	private ArrayList<Integer> readyQueue = new ArrayList<>();
	
	// Abstraction Function:
	// IntegerPipe is a black node in the graph that transfers the inputs to the output
	
	// Rep. invariant:
	// field from BlackOrWhiteNode isBlack = true
	
    private void checkRep()
    {
		assert this.isBlack() == true;
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
	public ArrayList<Integer> getEnterQueue() {
		checkRep();
		return this.enterQueue;
	}
	
	/**
	 * @returns ready works queue
	 */	
	public ArrayList<Integer> getReadyQueue() {
		checkRep();
		return this.readyQueue;
	}
	
	
	/**
	 * @modifies this
	 * @effects removes and returns the first element in readyQueue
	 */	
	public Integer popReadyQueue() {
		if (readyQueue.size() == 0){

		}
			//TODO add exception
		
		Integer res = readyQueue.get(0);
		readyQueue.remove(0);
		checkRep();
		return res;
	}
	
	/**
	 * @modifies this
	 * @effects add a work object to the queue of this pipe
	 */	
	public void addToEnterQueue(Integer newWork) {
		enterQueue.add(newWork);
		checkRep();
	}
	
	
	/**
	 * @effects Simulates this pipe in a the graph graph_.
	 *			Transfers all elements in entry queue to the ready queue.
	 */	
	public void simulate(BipartiteGraph<String> graph_)
	{
		for (Integer i = 0; i < enterQueue.size(); i++) { 
            readyQueue.add(enterQueue.get(i));
        }
		enterQueue.clear();
		
	}
	
}
