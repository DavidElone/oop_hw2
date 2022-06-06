package homework2;
import java.util.ArrayList;


public class PlusFilter extends BlackOrWhiteNode<String> implements Simulatable <String> {
	private ArrayList<Integer> resultsQueue = new ArrayList<>();
	
	// Abstraction Function:
	// PlusFilter is a white node in the graph that adds numbers from input pipes
	
	// Rep. invariant:
	// field from BlackOrWhiteNode isBlack = false
	// has one output edge
	// has zero or more input edges


	/**
	 * @modifies this
	 * @effects Constructs a new PlusFilter with color = white
	 */
	PlusFilter(String label) throws NoParentException {
		super(label, false);
		System.out.println("Creating PlusFilter");
		checkRep();

	}

	

	
	/**
	 * @returns results Queue
	 */	
	public ArrayList<Integer> getResultsQueue() throws NoParentException {
		checkRep();
		return this.resultsQueue;
	}
	
	/**
	 * @modifies this
	 * @effects add a result to the queue of this Filter
	 */	
	public void addToResultsQueue(int newWork) throws NoParentException {
		resultsQueue.add(newWork);
		checkRep();
	}
	
	/**
	 * @effects Simulates this Filter in a the graph graph_.
	 */	
	public void simulate(BipartiteGraph<String> graph_) throws NoParentException {
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

	/**
	 * @effects Check that the rep invariant is true.
	 */
	private void checkRep() throws NoParentException {
		System.out.println("this is black ? "+ this.isBlack() );
		assert this.isBlack() == false;

		ArrayList<Edge<String>> myEdges = this.getEdges();
		System.out.println("myEdgesSize is" + myEdges.size());
		assert myEdges.size() >= 0;

		int numOfExit = 0;
		for (int i = 0; i < myEdges.size(); i++) {
			if (myEdges.get(i).getParent().getLabel() == this.getLabel()) //this is the parent
				numOfExit++;
		}

		assert numOfExit <= 1;//TODO changed from ==1 to <= talk to Tali about it
	}
}
