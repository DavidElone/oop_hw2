package homework2;
import java.util.*;

/**
 * A BipartiteGraph is an extension of DirectedGraph. Itsa particularity is that evry node is black or white and, nodes can connect only if they are from different colors.
 */
public class BipartiteGraph<E> extends DirectedGraph<E>{

    private HashMap<E,BlackOrWhiteNode<E>> blackNodes= new HashMap<>();
    private HashMap<E,BlackOrWhiteNode<E>>  whiteNodes = new HashMap<>();
    @Override
    /**
     * @requires node != null and node is of type blackOrWhiteNode
     * @return true if the node has been added
     * @modifies this
     * @effects adds node to the graph
     */

    public boolean addNode(Node<E> node) {
        boolean nodeIsAdded = super.addNode(node);
        BlackOrWhiteNode<E> nodeToAdd = (BlackOrWhiteNode<E>)node;
        if(nodeIsAdded){
            if(nodeToAdd.isBlack()) {
                blackNodes.put(nodeToAdd.getLabel(),nodeToAdd);
            }else {
                whiteNodes.put(nodeToAdd.getLabel(),nodeToAdd);
            }
            return true;
        }
        return false;
    }
    @Override
    /**
     * @requires node != null and node is of type blackOrWhiteNode
     * @return true if the node has been removed
     * @modifies this
     * @effects removes node to the graph
     */
    public boolean removeNode(Node<E> node) {
        boolean nodeIsRemoved = super.removeNode(node);
        BlackOrWhiteNode<E> nodeToRemove = (BlackOrWhiteNode<E>)node;
        if(nodeIsRemoved){
            if(nodeToRemove.isBlack()) {
                return blackNodes.remove(nodeToRemove.getLabel(),nodeToRemove);
            }else {
                return whiteNodes.remove(nodeToRemove.getLabel(),nodeToRemove);
            }
        }
        return false;
    }
    @Override
    /**
     * @requires parentLabel , childLabel and edgeLabel != null
     * @return true if the edge has been added
     * @modifies this
     * @effects Adds an edge from the node parentLabel to the node childLabel
     * 			in the graph. The new edge's label is edgeLabel.
     */
    public boolean addEdge(E parentLabel, E childLabel,
                        E edgeLabel) throws NoChildException, NoParentException, LabelAlreadyExists {
        //check if they have different colors

        BlackOrWhiteNode<E> parent = (BlackOrWhiteNode<E>)getNodeByLabel(parentLabel);
        BlackOrWhiteNode<E> child = (BlackOrWhiteNode<E>)getNodeByLabel(childLabel);
        if(parent.isBlack() == child.isBlack()){
            return false;
        }
        //if they do, create edge then call super.addEdge add  setParent and setChild of the edge
        Edge directedEdge = new Edge(edgeLabel,parent,child,true);
        boolean edgeIsAdded = super.addEdge(parentLabel,childLabel,edgeLabel,true);
        if(edgeIsAdded){
            directedEdge.setParent(parent);
            directedEdge.setChild(child);
            return true;
        }
        return false;
    }



    /**
     * @requires none
     * @return  list of the labels of all the black nodes
     * 		   in the graph.
     */
    public HashMap<E,BlackOrWhiteNode<E>> getListBlackNodes() {
        checkRep();
        return blackNodes;

    }


    /**
     * @requires none
     * @return  list of the labels of all the white nodes
     * 		   in the graph.
     */
    public HashMap<E,BlackOrWhiteNode<E>> getListWhiteNodes() {
        checkRep();
        return whiteNodes;

    }
    /**
     * @requires parentLabel , childLabel and edgeLabel != null
     * @return the edge that have edgeLabel as label and that is connect from parentLabel's node to childLabel's node
     */
    @Override
    public Edge<E> getEdgeByLabel(E parentLabel, E childLabel, E edgeLabel) throws NoParentException, NoChildException {
        ArrayList<Edge<E>> edges = getEdges();
        for (int i = 0; i < getEdges().size(); i++) {
            if (edges.get(i).getLabel() == edgeLabel) {
                if ((((Edge<E>)edges.get(i)).getParent().getLabel() == parentLabel) && (((Edge<E>)edges.get(i)).getChild().getLabel() == childLabel))
                    return ((Edge<E>)edges.get(i));
            }
        }
        return null;
    }
    
     /**
     * @returns node from this.blackNodes by its label, null if doesn't exist
     */
    public Node<E> getBlackNodeByLabel(E label) {//TODO why this function. getNodeByLabel is not enough ?
        return blackNodes.get(label);
    }
    
     /**
     * @returns node from this.whiteNodes by its label, null if doesn't exist
     */
     public Node<E> getWhiteNodeByLabel(E label) {
         return whiteNodes.get(label);
    }

    /**
     * @effects Check that the rep invariant is true.
     */
    private void checkRep(){
        assert blackNodes != null: "blackNodes is null";
        assert whiteNodes != null: "whiteNodes is null";
    }




}
