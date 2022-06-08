package homework2;
import java.util.ArrayList;
import java.util.List;


//
public class Simulator<E> {
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
	* @returns this.PipesFiltersGraph
	**/
	
	public BipartiteGraph<E> getPipesFiltersGraph() {
		return this.PipesFiltersGraph;
	}
	/**
	* @requires
	* @modifies this
	* @effects simulates each pipe, then each filter, then increases the simulator counter
	**/
	public void simulate() throws NoParentException, NoChildException {
		checkRep();
		List<BlackOrWhiteNode<E>> pipes = new ArrayList<>(this.PipesFiltersGraph.getListBlackNodes().values());
		List<BlackOrWhiteNode<E>> filters = new ArrayList<>(this.PipesFiltersGraph.getListWhiteNodes().values());



		for (int i = 0; i < pipes.size(); i++) {
			((Simulatable)(pipes.get(i))).simulate(PipesFiltersGraph); //check
        }
		
		for (int i = 0; i < filters.size(); i++) {
			((Simulatable)(filters.get(i))).simulate(PipesFiltersGraph); //check
        }
		
		this.simCount++;
		checkRep();
	}



}
