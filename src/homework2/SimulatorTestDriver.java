package homework2;
import java.util.*;

/**
 * This class implements a testing driver for Simulator. The driver
 * manages Simulators for integer arithmetic.
 */
public class SimulatorTestDriver {

    private Map<String, Simulator<String>> simulators;

    /**
     * @modifies this
     * @effects Constructs a new test driver.
     */
    public SimulatorTestDriver () {
    	this.simulators = new HashMap<String, Simulator<String>>();       
    }


    /**
     * @requires simName != null
     * @modifies this
     * @effects Creates a new simulator named simName. The simulator's
     * 			graph is initially empty.
     */
    public void createSimulator(String simName) {
		if (simName == null)
    		return;
    	if (this.simulators.containsKey(simName))
    		return;
    	Simulator<String> simulator = new Simulator<String>();
    	simulators.put(simName, simulator);

    	
    }


    /**
     * @requires createSimulator(simName)
     *           && pipeName != null
     *  		 && pipeName has not been used in a previous addPipe(),
     * 				addPlusFilter(), or addGCDFilter() call on this object
     * @modifies simulator named simName
     * @effects Creates a new IntPipe named by the String pipeName and add it
     * 			to the simulator named simName.
     */
    public void addPipe(String simName, String pipeName) {
    	IntPipe newPipe = new IntPipe(pipeName);
		if (!(simulators.get(simName).getPipesFiltersGraph().addNode(newPipe))){

		}
			//TODO: add exception
  	
    }


    /**
     * @requires createSimulator(simName)
     *           && filterName != null
     *  		 && filterName has not been used in a previous addPipe(),
     * 				addPlusFilter(), or addGCDFilter() call on this object
     * @modifies simulator named simName
     * @effects Creates a new PlusFilter named by the String filterName and
     * 			add it to the simulator named simName.
     */
    public void addPlusFilter(String simName, String filterName) throws NoParentException {
		
    	PlusFilter newPlusFilter = new PlusFilter(filterName);
		if (!(simulators.get(simName).getPipesFiltersGraph().addNode(newPlusFilter))){
			System.out.println("We into if because we didn't manage to add newPlusFilter");

			//TODO: add exception
		}


    	
    }


    /**
     * @requires createSimulator(simName)
     *           && filterName != null
     *  		 && filterName has not been used in a previous addPipe(),
     * 				addPlusFilter(), or addGCDFilter() call on this object
     * @modifies simulator named simName
     * @effects Creates a new GCDFilter named by the string filterName and
     * 			add it to the simulator named simName.
     */
    public void addGCDFilter(String simName, String filterName) {
		
    	GCDFilter newGCDFilter = new GCDFilter(filterName);
		if (!(simulators.get(simName).getPipesFiltersGraph().addNode(newGCDFilter))){
			//TODO: add exception
		}


    	
    }


    /**
     * @requires createSimulator(simName)
     *           && ((addPipe(parentName) && addFilter(childName))
     *              || (addFilter(parentName) && addPipe(childName)))
     *           && edgeLabel != null
     *           && node named parentName has no other outgoing edge labeled
     * 				edgeLabel
     *           && node named childName has no other incoming edge labeled
     * 				edgeLabel
     * @modifies simulator named simName
     * @effects Adds an edge from the node named parentName to the node named
     * 			childName in the simulator named simName. The new edge's
     * 			label is the String	edgeLabel.
     */
    public void addEdge(String simName,
    					String parentName, String childName,
                        String edgeLabel) throws NoChildException, NoParentException, LabelAlreadyExists {
							
    	if (!(simulators.get(simName).getPipesFiltersGraph().addEdge(parentName, childName, edgeLabel))){
			//TODO: add exception
		}



    }


    /**
     * @requires createSimulator(simName)
     * 			 && addPipe(pipeName)
     * @modifies pipe named pipeName
     * @effects pushes the integer value into the pipe named pipeName in the
     * 			simulator named simName.
     */
    public void injectInput(String simName, String pipeName, int value) {
    	IntPipe p = (IntPipe) this.simulators.get(simName).getPipesFiltersGraph().getBlackNodeByLabel(pipeName);
		p.addToEnterQueue(value);
   	
    }


    /**
     * @requires addPipe(pipeName)
     * @return a space-separated list of the integer values currently in the
     * 		   pipe named pipeName in the simulator named simName.
     */
    public String listContents(String simName, String pipeName) {
    	if ((simName == null) || (pipeName == null))
    		return null;
		
    	if (!this.simulators.containsKey(simName))
    		return null;

    	IntPipe p = (IntPipe) this.simulators.get(simName).getPipesFiltersGraph().getBlackNodeByLabel(pipeName); //TODO addedby dez (IntPipe <String>) check with Tali
    	if (p == null)
    		return null;
    	
    	String str = "";
    	if (p.getEnterQueue().size() <= 0)
    		return str;
		
       	for(int i=0; i < p.getEnterQueue().size()-1; i++) {	
    		str += p.getEnterQueue();
    		str += " ";
    	}
		str += p.getEnterQueue().get(p.getEnterQueue().size()-1);
    	return str;

    	
    }

    /**
     * @requires createSimulator(simName)
     * @modifies simulator named simName
     * @effects runs simulator named simName for a single time slice.
     */
    public void simulate(String simName) throws NoParentException {
    	if (simName == null)
    		return;
    	
    	if (!this.simulators.containsKey(simName))
    		return;
    	
    	simulators.get(simName).simulate();
    	
    	
    }
}
