package homework2;
import java.util.ArrayList;


public class GCDFilter extends BlackOrWhiteNode<E> implements Simulatable <E> {
	private ArrayList<int> resultsQueue = new ArrayList<int>();
	private ArrayList<int> aQueue = new ArrayList<int>();
	private ArrayList<int> bQueue = new ArrayList<int>();
	// Abstraction Function:
	// PlusFilter is a white node in the graph that 
	
	// Rep. invariant:
	// field from BlackOrWhiteNode isBlack = false
	// has two input edges named 'a', 'b'
	// has three output edges named 'a', 'b', 'gcd'
	
    private void checkRep()
    {
		assert this.isBlack == false;

		ArrayList<Edge<String>> myEdges = this.getEdges();
		assert myEdges.size() == 5;
		int a = 0, b = 0, gcd = 0;
		for (int i = 0; i < myEdges.size(); i++) { 
            Node parent = myEdges.get(i).getParent();
			
			if (parent.getLabel() == this.getLabel()) { //this is the parent
				if (myEdges.get(i).getLabel() == "a") a++;
				if (myEdges.get(i).getLabel() == "b") b++;
				if (myEdges.get(i).getLabel() == "gcd") gcd++;
			}
			
			else {
				if (myEdges.get(i).getLabel() == "a") a++;
				if (myEdges.get(i).getLabel() == "b") b++;
			}
			
		}
		
		assert a == 2;
		assert b == 2;
		assert gcd == 1;

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
	 * @modifies this
	 * @effects add to the a queue of this Filter
	 */	
	public void addToAQueue(int newWork) {
		aQueue.add(newWork);
		checkRep();
	}
	
	/**
	 * @modifies this
	 * @effects add to the b queue of this Filter
	 */	
	public void addToBQueue(int newWork) {
		bQueue.add(newWork);
		checkRep();
	}
	
	/**
	 * @effects Simulates this Filter in a the graph graph_.
	 */	
	public void simulate(BipartiteGraph<E> graph_) 
	{
		checkRep();
		ArrayList<Edge<String>> myEdges = this.getEdges();
		for (int i = 0; i < myEdges.size(); i++) { 
            Node parent = myEdges.get(i).getParent();
			if (parent.getLabel() == this.getLabel()) //this is the parent. we want only edges that *enter* this
				continue;
			
			IntPipe parentP = (IntPipe)(parent);		

			if (parent.getLabel() == "a")
				int a = parentP.popReadyQueue();
			
			if (parent.getLabel() == "b")
				int b = parentP.popReadyQueue();

        }
		
		if (b == 0) //finished - a is GCD
			addToResultsQueue(a);
		
		else {
			if (a<b) { //swap a and b
				addToAQueue(b);
				addToBQueue(a);
			}
			
			else { //b -> a,  a%b -> b
				addToAQueue(b);
				addToBQueue(a%b);
			}
		}
		
		checkRep();
		
	}
	
}
