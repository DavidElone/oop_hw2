package homework2;
import java.util.ArrayList;


public class GCDFilter extends FilterNode<Integer>{
	private ArrayList<Integer> resultsQueue = new ArrayList<>();//will contain a and b in that order
	// Abstraction Function:
	// PlusFilter is a white node in the graph that 
	
	// Rep. invariant:
	// field from BlackOrWhiteNode isBlack = false


	/**
	 * @effects checks the edges of the GCD filter - 2 inputs "a", "b", 3 outputs - "a", "b", "gcd"
	 * @throws
	 */
    private void checkValidGCDFilter()  {
		assert this.isBlack() == false;
		ArrayList<DirectedEdge<String>> myEdges = this.getEdges();
		assert myEdges.size() == 5;
		int a = 0, b = 0, gcd = 0;
		for (int i = 0; i < myEdges.size(); i++) {
			if (myEdges.get(i).getLabel() == "a") a++;
			if (myEdges.get(i).getLabel() == "b") b++;
			if (myEdges.get(i).getLabel() == "gcd") gcd++;
		}

		assert a == 2;
		assert b == 2;
		assert gcd == 1;

    }
	
	/**
     * @modifies this
     * @effects Constructs a new PlusFilter with color = balck
     */
	public GCDFilter(String label)   {
		super(label, false);
		checkRep();
	}
	
	/**
	 * @returns results Queue
	 */	
	public ArrayList<Integer> getResultsQueue() {
		return this.resultsQueue;
	}
	
	/**
	 * @modifies this
	 * @effects add a result to the queue of this Filter
	 */	
	public void addToResultsQueue(int newWork) {
		resultsQueue.add(newWork);
	}
	
	/**
	 * @effects Simulates this Filter in a the graph graph_.
	 */	
	public void simulate(BipartiteGraph<String> graph_) throws  NoChildException  {
		checkValidGCDFilter();
		IntPipe pipeNodeA =  (IntPipe) graph_.getNodes().get(graph_.getChildByEdgeLabel(this.getLabel(), "a"));
		IntPipe pipeNodeB = (IntPipe) graph_.getNodes().get(graph_.getChildByEdgeLabel(this.getLabel(), "b"));
		IntPipe pipeNodeGCD = (IntPipe) graph_.getNodes().get(graph_.getChildByEdgeLabel(this.getLabel(), "gcd"));
		Integer a = this.getInputs().get("a");
		Integer b = this.getInputs().get("b");
		if (b == 0) {
			pipeNodeGCD.addToQueue(a);

		} else if (a < b) {
			pipeNodeA.addToQueue(b);
			pipeNodeB.addToQueue(a);
		} else {
			pipeNodeA.addToQueue(b);
			pipeNodeB.addToQueue(a%b);
		}
		this.clearInputs();
		
	}
	private void checkRep(){
		assert this.getResultsQueue() != null : "input of filter is null";
	}
	
}
