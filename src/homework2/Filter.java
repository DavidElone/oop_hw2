package homework2;
import java.util.ArrayList;


public class Filter extends BlackOrWhiteNode<E> implements Simulatable <E> {
	private ArrayList<workObject> worksQueue = new ArrayList<workObject>();
	
	// Abstraction Function:
	// Filter is a BlackOrWhiteNode type with the color white.
	
	// Rep. invariant:
	// field from BlackOrWhiteNode isBlack = false
	
    private void checkRep()
    {
		assert this.isBlack == false;
    }
	
	/**
     * @modifies this
     * @effects Constructs a new Filter with color = white
     */
	public Filter(E label) {
		super(label, false);
		checkRep();
		
	}
	
	/**
	 * @returns works queue
	 */	
	public ArrayList<workObject> getWorksQueue() {
		checkRep();
		return this.workObject;
	}
	
	/**
	 * @modifies this
	 * @effects add a work object to the queue of this Filter
	 */	
	public void addToWorksQueue(workObject newWork) {
		worksQueue.add(newWork);
		checkRep();
	}
	
	/**
	 * @effects Simulates this Filter in a the graph graph_.
	 */	
	public void simulate(BipartiteGraph<E> graph_) 
	{
	}
	
}
