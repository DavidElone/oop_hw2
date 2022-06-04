package homework2;
import java.util.ArrayList;


public class PlusFilter extends BlackOrWhiteNode<E> implements Simulatable <E> {
	private ArrayList<int> resultsQueue = new ArrayList<int>();
	
	// Abstraction Function:
	// PlusFilter is a white node in the graph that adds numbers from input pipes
	
	// Rep. invariant:
	// field from BlackOrWhiteNode isBlack = false
	
    private void checkRep()
    {
		assert this.isBlack == false;
    }
	
	/**
     * @modifies this
     * @effects Constructs a new PlusFilter with color = white
     */
	public PlusFilter(String label) {
		super(label, false);
		checkRep();
		
	}
	
	/**
	 * @returns results Queue
	 */	
	public ArrayList<int> getResultsQueue() {
		checkRep();
		return this.resultsQueue;
	}
	
	/**
	 * @modifies this
	 * @effects add a result to the queue of this Filter
	 */	
	public void addToResultsQueue(int newWork) {
		resultsQueue.add(newWork);
		checkRep();
	}
	
	/**
	 * @effects Simulates this Filter in a the graph graph_.
	 */	
	public void simulate(BipartiteGraph<E> graph_) 
	{
		checkRep();
		int sum = 0;
		ArrayList<Edge<String>> myEdges = this.getEdges();
		
		for (int i = 0; i < myEdges.size(); i++) { 
            IntPipe parent = myEdges.get(i).getParent();
			ArrayList<int> parentRes = parent.getReadyQueue();
			
			if (parentRes.size() == 0)
				continue;
			
			sum = sum + parentRes.get(0);
        }
		
		addToResultsQueue(sum);
		checkRep();
		
	}
	
}
