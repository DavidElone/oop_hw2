package homework2;
import java.util.ArrayList;
import java.util.List;


public class PlusFilter extends FilterNode<Integer>  {

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
	PlusFilter(String label)   {
		super(label, false);
	}
	
	/**
	 * @effects Simulates this Filter in a the graph graph_.
	 */	
	public void simulate(BipartiteGraph<String> graph_) throws NoChildException {
		checkValidPlusFilter();

		Integer sum = 0;
		for(Integer val : getInputsArray())
			sum += val;
		List<String> pipeLabel = graph_.listChildren(this.getLabel());
		IntPipe pipe = (IntPipe)graph_.getNodes().get(pipeLabel.get(0));
		pipe.addToQueue(sum);
		this.clearInputs();
	}

	/**
	 * @effects Check that the rep invariant is true.
	 */
	private void checkValidPlusFilter() {
		assert this.isBlack() == false;

		int numEdgesIn = this.getEdgesIn().size();
		int numEdgesOut = this.getEdgesOut().size();
		assert numEdgesIn >= 0;
		assert numEdgesOut == 1;

	}

}
