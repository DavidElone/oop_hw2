package homework2;
import java.util.*;

/**
 * This class implements a testing driver for BipartiteGraph. The driver
 * manages BipartiteGraphs whose nodes and edges are Strings.
 */
public class BipartiteGraphTestDriver {

    private Map<String, BipartiteGraph<String>> graphs;

    /**
     * @modifies this
     * @effects Constructs a new test driver.
     */
    public BipartiteGraphTestDriver () {
        this.graphs = new HashMap<String, BipartiteGraph<String>>();
       
       
    }

    
    /**
     * @requires graphName != null
     * @modifies this
     * @effects Creates a new graph named graphName. The graph is initially
     * 			empty.
     */
    public void createGraph(String graphName) {
        BipartiteGraph<String> newGraph = new BipartiteGraph<String>();
        this.graphs.put(graphName, newGraph);
        
    	
    }

    
    /**
     * @requires createGraph(graphName)
     *           && nodeName != null
     *           && neither addBlackNode(graphName,nodeName) 
     *                  nor addWhiteNode(graphName,nodeName)
     *                      has already been called on this
     * @modifies graph named graphName
     * @effects Adds a black node represented by the String nodeName to the
     * 			graph named graphName.
     */
    public void addBlackNode(String graphName, String nodeName) {
        BlackOrWhiteNode<String> blackNode = new BlackOrWhiteNode<String>(nodeName, true);
        this.graphs.get(graphName).addNode(blackNode);
    	
    }

    
    /**
     * @requires createGraph(graphName)
     *           && nodeName != null
     *           && neither addBlackNode(graphName,nodeName) 
     *                  nor addWhiteNode(graphName,nodeName)
     *                      has already been called on this
     * @modifies graph named graphName
     * @effects Adds a white node represented by the String nodeName to the
     * 			graph named graphName.
     */
    public void addWhiteNode(String graphName, String nodeName) {
        BlackOrWhiteNode<String> whiteNode = new BlackOrWhiteNode<String>(nodeName, false);
        this.graphs.get(graphName).addNode(whiteNode);
    	
    	
    }

    
    /**
     * @requires
     *           && edgeLabel != null
     *           && node named parentName has no other outgoing edge labeled
     * 				edgeLabel
     *           && node named childName has no other incoming edge labeled
     * 				edgeLabel
     * @modifies graph named graphName
     * @effects Adds an edge from the node parentName to the node childName
     * 			in the graph graphName. The new edge's label is the String
     * 			edgeLabel.
     */
    public void addEdge(String graphName,
    					String parentName, String childName, 
                        String edgeLabel) {
        BipartiteGraph<String> graph = this.graphs.get(graphName);
        graph.addEdge(parentName,childName,edgeLabel);
    	
    	
    }

    
    /**
     * @requires createGraph(graphName)
     * @return a space-separated list of the names of all the black nodes
     * 		   in the graph graphName, in alphabetical order.
     */
    public String listBlackNodes(String graphName) {
        BipartiteGraph<String> graph = this.graphs.get(graphName);
    	List<String> list = new ArrayList<>(graph.getListBlackNodes().keySet());
        Collections.sort(list);
        String output = String.join(" ", list);
    	return output;
    }

    
    /**
     * @requires createGraph(graphName)
     * @return a space-separated list of the names of all the white nodes
     * 		   in the graph graphName, in alphabetical order.
     */
    public String listWhiteNodes(String graphName) {
        BipartiteGraph<String> graph = this.graphs.get(graphName);
        List<String> list = new ArrayList<>(graph.getListWhiteNodes().keySet());
        Collections.sort(list);
        String output = String.join(" ", list);
        return output;
    	
    	
    }

    
    /**
     * @requires createGraph(graphName) && createNode(parentName)
     * @return a space-separated list of the names of the children of
     * 		   parentName in the graph graphName, in alphabetical order.
     */
    public String listChildren(String graphName, String parentName) throws NoChildException {
        BipartiteGraph<String> graph = this.graphs.get(graphName);
        List<String> list = graph.listChildren(parentName);
        Collections.sort(list);
        String output = String.join(" ", list);
        return output;
    	
    	
    }

    
    /**
     * @requires createGraph(graphName) && createNode(childName)
     * @return a space-separated list of the names of the parents of
     * 		   childName in the graph graphName, in alphabetical order.
     */
    public String listParents(String graphName, String childName) throws NoParentException {
        BipartiteGraph<String> graph = this.graphs.get(graphName);
        List<String> list = graph.listParents(childName);
        Collections.sort(list);
        String output = String.join(" ", list);
        return output;
    	
    	
    }

    
    /**
     * @requires addEdge(graphName, parentName, str, edgeLabel) for some
     * 			 string str
     * @return the name of the child of parentName that is connected by the
     * 		   edge labeled edgeLabel, in the graph graphName.
     */
    public String getChildByEdgeLabel(String graphName, String parentName,
    								   String edgeLabel) throws NoChildException {
        BipartiteGraph<String> graph = this.graphs.get(graphName);
        return graph.getChildByEdgeLabel(parentName,edgeLabel);
    	
    	
    }

    
    /**
     * @requires addEdge(graphName, str, childName, edgeLabel) for some
     * 			 string str
     * @return the name of the parent of childName that is connected by the 
     * 		   edge labeled edgeLabel, in the graph graphName.
     */
    public String getParentByEdgeLabel(String graphName, String childName,
    									String edgeLabel) throws NoParentException {
        BipartiteGraph<String> graph = this.graphs.get(graphName);
        return graph.getParentByEdgeLabel(childName,edgeLabel);
    	
    	
    }
}
