package homework2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class IntPipe extends BlackOrWhiteNode<String> implements Simulatable <String> {
	private ArrayList<Integer> queue = new ArrayList<>();
	
	// Abstraction Function:
	// IntegerPipe is a black node in the graph that transfers the data to filters
	
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
	 * @returns all the works object in the pipe
	 */	
	public ArrayList<Integer> getQueue() {
		checkRep();
		return this.queue;
	}
	
	
	/**
	 * @modifies this
	 * @effects removes and returns the first element in readyQueue. returns 0 if there is no element
	 */	
	public Integer popQueue() {
		if (getQueue().size() == 0){
			return 0;
		}
		Integer res = getQueue().get(0);
		queue.remove(0);
		checkRep();
		return res;
	}
	
	/**
	 * @modifies this
	 * @effects add a work object to the queue of this pipe
	 */	
	public void addToQueue(Integer newWork) {
		queue.add(newWork);
		checkRep();
	}


	/**
	 * @requires none
	 * @modifies this graph
	 * @effects Simulates this pipe in a system modeled by graph. If the pipe is empty, the value piped is null.
	 */
	public void simulate(BipartiteGraph<String> graph){
		int index =0;
		Integer intToPush =0;
		for (DirectedEdge<String> edgesOut :  this.getEdgesOut().values()) {
			if(index == 0){
				 intToPush = this.popQueue();
			}
			index++;
			FilterNode filter = (FilterNode) edgesOut.getChild();

			filter.insetValue(edgesOut.getLabel(),intToPush);
		}

	}
	
}
