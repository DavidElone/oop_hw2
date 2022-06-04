package homework2;
import java.util.ArrayList;

//Class that implements a simulator of BipartiteGraph.
//Pipes are black nodes, filters are white nodes.

public class Simulator {
	private BipartiteGraph<E> PipesFiltersGraph = new BipartiteGraph<E> ();
	private int simCount = 0;
	
	
	// Abstraction Function:
	// Create and simulate a graph of pipes and filters - first simulate
	// each pipe in the graph, than each filter. 
	
	// Rep. invariant:
	// simCount >= 0

    private void checkRep() {
		assert this.simCount >= 0;
    }
	
	/**
	* @modifies this
	* @effects simulates one round - each pipe, then each filter, then increases the simulator counter
	**/
	public void simulate() {
		checkRep()
		ArrayList<E> pipes = new ArrayList<>();
		pipes = this.PipesFiltersGraph.listBlackNodes();
		
		ArrayList<E> filters = new ArrayList<>();
		filters = this.PipesFiltersGraph.listWhiteNodes();	

		for (int i = 0; i < pipes.size(); i++) { 
            pipes.get(i).simulate(PipesFiltersGraph);
        }
		
		for (int i = 0; i < filters.size(); i++) { 
            filters.get(i).simulate(PipesFiltersGraph);
        }
		
		this.simCount++;
		checkRep()
	}



}
