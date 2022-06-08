package homework2;
import java.util.*;

/**
 * A BipartiteGraph is a graph like explained in the homework.
 */
public class BipartiteGraph<E>{

    private HashMap<E,BlackOrWhiteNode<E>> nodes= new HashMap<>();
    private ArrayList<DirectedEdge<E>> edges = new ArrayList<>();
    private HashMap<E,BlackOrWhiteNode<E>> blackNodes= new HashMap<>();
    private HashMap<E,BlackOrWhiteNode<E>>  whiteNodes = new HashMap<>();


    /**
     *
     * @returns this.nodes
     */

    public HashMap<E,BlackOrWhiteNode<E>> getNodes() {
        checkRep();
        return this.nodes;
    }
    /**
     *
     * @returns this.blackNodes
     */
    public HashMap<E,BlackOrWhiteNode<E>> getBlackNodes() {
        checkRep();
        return this.blackNodes;
    }
    /**
     *
     * @returns this.blackNodes
     */
    public HashMap<E,BlackOrWhiteNode<E>> getWhiteNodes() {
        checkRep();
        return this.whiteNodes;
    }
    /**
     * @requires node != null and node is of type blackOrWhiteNode
     * @return true if the node has been added
     * @modifies this
     * @effects adds node to the graph
     */

    public boolean addNode(BlackOrWhiteNode<E> node) {
        boolean nodeAlreadyExist = getNodes().containsValue(node);
        if(nodeAlreadyExist){
            return false;
        }
        getNodes().put(node.getLabel(),node);
        if(node.isBlack()) {
            getBlackNodes().put(node.getLabel(),node);
        }else {
            getWhiteNodes().put(node.getLabel(),node);
        }
        return true;
    }


    /**
     * @requires parentLabel , childLabel and edgeLabel != null
     * @return true if the edge has been added
     * @modifies this
     * @effects Adds an edge from the node parentLabel to the node childLabel
     * 			in the graph. The new edge's label is edgeLabel.
     */
    public void addEdge(E parentLabel, E childLabel,
                        E edgeLabel) {
        //check if they have different colors

        BlackOrWhiteNode<E> parent = getNodes().get(parentLabel);
        BlackOrWhiteNode<E> child = getNodes().get(childLabel);
        if(parent == null || child ==null){
            return;
        }
        if(parent.isBlack() == child.isBlack()){
            return;
        }
        DirectedEdge edgeToAdd = new DirectedEdge(edgeLabel,parent,child);
        if(!parent.getEdgesOut().containsKey(edgeLabel) && !child.getEdgesIn().containsKey(edgeLabel)){
            parent.addEdgeOut(edgeToAdd);
            child.addEdgeIn(edgeToAdd);
            getEdges().add(edgeToAdd);
        }
    }

    /**
     * @requires parentLabel != null
     * @return a  list of the names of the children of
     * 		   parentLabel in this.
     */
    public List<E> listChildren(E parentLabel)  {

        List<E> childrenLabel = new ArrayList<>();
        Node<E> parentNode = getNodes().get(parentLabel);
        DirectedEdge<E> edge = null;
        ArrayList<DirectedEdge<E>> edgesOut = new ArrayList<>(parentNode.getEdgesOut().values());
        for (int index = 0; index < edgesOut.size(); index++) {
            edge =  edgesOut.get(index);
            E child = (E) edge.getChild().getLabel();
            if(child!=null){
                childrenLabel.add(child);
            }
        }
        return childrenLabel;
    }
    /**
     * @requires childLabel != null
     * @return a  list of the names of the parents of
     * 		   childName in this.
     */
    public List<E> listParents(E childLabel) throws NoParentException {
        List<E> parentsLabel = new ArrayList<>();
        Node<E> childNode = getNodes().get(childLabel);
        //Go over parentNode.edgesIn
        DirectedEdge<E> edge = null;
        ArrayList<DirectedEdge<E>> edgesIn = new ArrayList<>(childNode.getEdgesIn().values());
        for (int index = 0; index < edgesIn.size(); index++) {
            edge =  edgesIn.get(index);
            E parent = (E) edge.getParent().getLabel();
            if(parent!=null){
                parentsLabel.add(parent);
            }
        }
        return parentsLabel;

    }


    /**
     * @requires parentLabel and edgeLabel != null
     * @return the label of the child of parentLabel that is connected by the
     * 		   edge labeled edgeLabel, in this.
     */
    public E getChildByEdgeLabel(E parentLabel,
                                 E edgeLabel) throws NoChildException {
        Node parent = getNodes().get(parentLabel);
        DirectedEdge edge = (DirectedEdge) parent.getEdgesOut().get(edgeLabel);
        if(edge == null){
            throw new NoChildException();
        }

        return (E)edge.getChild().getLabel();
    }
    /**
     * @requires childLabel and edgeLabel != null
     * @return the label of the parent of childLabel that is connected by the
     * 		   edge labeled edgeLabel, in this.
     */
    public E getParentByEdgeLabel(E childLabel,
                                  E edgeLabel) throws NoParentException {
        Node child = getNodes().get(childLabel);
        DirectedEdge edge = (DirectedEdge) child.getEdgesIn().get(edgeLabel);
        if(edge == null){
            throw new NoParentException();
        }

        return (E)edge.getParent().getLabel();
    }



    /**
     *
     * @returns this.edges
     */

    public ArrayList<DirectedEdge<E>> getEdges() {
        checkRep();
        return this.edges;
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
     * @effects Check that the rep invariant is true.
     */
    private void checkRep(){
        assert blackNodes != null: "blackNodes is null";
        assert whiteNodes != null: "whiteNodes is null";
    }




}
