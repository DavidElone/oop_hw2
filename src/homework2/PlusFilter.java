package homework2;
import java.util.ArrayList;


public class PlusFilter extends BlackOrWhiteNode<E> implements Simulatable <E> {
	private ArrayList<int> resultsQueue = new ArrayList<int>();
	
	// Abstraction Function:
	// PlusFilter is a white node in the graph that adds numbers from input pipes
	
	// Rep. invariant:
	// field from BlackOrWhiteNode isBlack = false
	// has one output edge
	// has zero or more input edges
	
    private void checkRep()
    {
		assert this.isBlack == false;
		ArrayList<Edge<String>> myEdges = this.getEdges();
		assert myEdges.size() > 0;
		
		int singleExit = 0;
		for (int i = 0; i < myEdges.size(); i++) { 			
			if (myEdges.get(i).getParent().getLabel() == this.getLabel()) //this is the parent
				singleExit++;							
		}
		
		assert singleExit == 1;
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
            Node parent = myEdges.get(i).getParent();
			if (parent.getLabel() == this.getLabel()) //this is the parent. we want only edges that *enter* this
				continue;
			
			IntPipe parentP = (IntPipe)(parent);
			
			if (parentP.getReadyQueue().size() == 0)
				continue;
			
			sum += parentP.popReadyQueue();
        }
		
		addToResultsQueue(sum);
		checkRep();
		
	}
	
}
