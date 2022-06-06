package homework2;
import java.util.ArrayList;


public class GCDFilter extends BlackOrWhiteNode<String> implements Simulatable <String> {
	private ArrayList<Integer> resultsQueue = new ArrayList<>();
	private ArrayList<Integer> aQueue = new ArrayList<>();
	private ArrayList<Integer> bQueue = new ArrayList<>();
	// Abstraction Function:
	// PlusFilter is a white node in the graph that 
	
	// Rep. invariant:
	// field from BlackOrWhiteNode isBlack = false
	// has two input edges named 'a', 'b'
	// has three output edges named 'a', 'b', 'gcd'
	
    private void checkRep()
    {
		assert this.isBlack() == false;
		//TODO talk with tali
//		ArrayList<Edge<E>> myEdges = this.getEdges();
//		assert myEdges.size() == 5;
//		int a = 0, b = 0, gcd = 0;
//		for (int i = 0; i < myEdges.size(); i++) {
//            Node parent = myEdges.get(i).getParent();
//
//			if (parent.getLabel() == this.getLabel()) { //this is the parent
//				if (myEdges.get(i).getLabel() == "a") a++;
//				if (myEdges.get(i).getLabel() == "b") b++;
//				if (myEdges.get(i).getLabel() == "gcd") gcd++;
//			}
//
//			else {
//				if (myEdges.get(i).getLabel() == "a") a++;
//				if (myEdges.get(i).getLabel() == "b") b++;
//			}
//
//		}
//
//		assert a == 2;
//		assert b == 2;
//		assert gcd == 1;

    }
	
	/**
     * @modifies this
     * @effects Constructs a new PlusFilter with color = white
     */
	public GCDFilter(String label) {
		super(label, false);
		checkRep();
		
	}
	
	/**
	 * @returns results Queue
	 */	
	public ArrayList<Integer> getResultsQueue() {
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
	public void simulate(BipartiteGraph<String> graph_) throws NoParentException {
		checkRep();
		ArrayList<Edge<String>> myEdges = this.getEdges();
		if(myEdges.size() == 0){
			return;
		}
		Integer a=0,b=0;
		for (int i = 0; i < myEdges.size(); i++) { 
            Node parent = myEdges.get(i).getParent();
			if (parent.getLabel() == this.getLabel()) //this is the parent. we want only edges that *enter* this
				continue;
			
			IntPipe parentP = (IntPipe)(parent);
			if (parent.getLabel() == "a")
				a = parentP.popReadyQueue();
			
			if (parent.getLabel() == "b")
				b = parentP.popReadyQueue();

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
