package homework2;
import java.util.ArrayList;
import java.util.HashMap;


public abstract class FilterNode<T> extends BlackOrWhiteNode<String> implements Simulatable <String> {

	private HashMap<String,T> inputs = new HashMap<>();
	// Abstraction Function:
	// Filter is a BlackOrWhiteNode that filter data

	// Rep. invariant:
	// has one output edge
	// has zero or more input edges


	/**
	 * @modifies this
	 * @effects Constructs a new Filter with color = white
	 */
	FilterNode(String label,boolean isBLack) {
		super(label, isBLack);
		checkRep();
	}
	/**
	 * @requires none
	 * @modifies none
	 * @effects return this.inputs
	 */
	public HashMap<String,T> getInputs() {
		return this.inputs;
	}
	/**
	 * @requires none
	 * @modifies none
	 * @effects return the list of inputs
	 */
	public ArrayList<T> getInputsArray() {
		return new ArrayList<>(this.inputs.values());
	}

	/**
	 * @requires value != null
	 * @modifies this
	 * @effects insert a new value in this.inputs
	 */
	public void insetValue(String edgeLabel ,T value) {
		this.inputs.put(edgeLabel,value);
	}

	/**
	 * @effect clear inputs of the filter
	 */
	public void clearInputs() {
		this.inputs.clear();
	}
	private void checkRep(){
		assert this.isBlack() == false :"filter color has to be white";
		assert this.getInputsArray() != null : "input of filter is null";
	}
}
