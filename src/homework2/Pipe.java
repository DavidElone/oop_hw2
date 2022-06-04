package homework2;
import java.util.ArrayList;


public class Pipe extends BlackOrWhiteNode<E> implements Simulatable <E> {
	private ArrayList<workObject> worksQueue = new ArrayList<workObject>();
	
	// Abstraction Function:
	// Pipe is a BlackOrWhiteNode type with the color black.
	
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
	public Pipe(E label) {
		super(label, true);
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
	 * @effects add a work object to the queue of this pipe
	 */	
	public void addToWorksQueue(workObject newWork) {
		worksQueue.add(newWork);
		checkRep();
	}
	
	/**
	 * @effects Simulates this pipe in a the graph graph_.
	 */	
	public void simulate(BipartiteGraph<E> graph_) 
	{
	}
	
}
