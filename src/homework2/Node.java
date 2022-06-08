package homework2;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Node<E> {
    private E label;
    private ArrayList<DirectedEdge<E>> edges = new ArrayList<>();
    private HashMap<E,DirectedEdge<E>> edgesIn= new HashMap<>();
    private HashMap<E,DirectedEdge<E>> edgesOut= new HashMap<>();

    //Abstraction function:
    // Class that describes a simple node with label and edges,edgesIn,edgesOut connected to it.

    //Rep. invariant:
    //can't have two edges with same label

    /**
     * @requires label != null
     * @modifies this
     * @effects creates a new node.
     */
    Node(E label){
        this.label = label;
        checkRep();
    }

    /**
     *
     * @returns this.edges
     */
    public ArrayList<DirectedEdge<E>> getEdges() {
        checkRep();
        return edges;
    }
    /**
     *
     * @returns this.edgesIn
     */
    public HashMap<E,DirectedEdge<E>> getEdgesIn() {
        checkRep();
        return edgesIn;
    }
    /**
     *
     * @returns this.edgesIn
     */
    public HashMap<E,DirectedEdge<E>> getEdgesOut() {
        checkRep();
        return edgesOut;
    }


    /**
     * @requires edge != null
     * @modifies this
     * @effects add edge to edgeIn only if it doesn't contain it yet. then if added add it to this.edges
     */
    public boolean addEdgeIn(DirectedEdge<E> edge) {
        checkRep();

        DirectedEdge<E> edgeInWithSameLabel = getEdgesIn().get(edge.getLabel());
        if (edgeInWithSameLabel == null) { //no edge with the label of e
            getEdgesIn().put(edge.getLabel(), edge);
            getEdges().add(edge);
            checkRep();
            return true;
        }else{
            checkRep();
            return false;
        }

    }
    /**
     * @requires edge != null
     * @modifies this
     * @effects add edge to edgeOut only if it doesn't contain it yet. then if added, add it to this.edges
     */
    public boolean addEdgeOut(DirectedEdge<E> edge) {
        checkRep();

        DirectedEdge<E> edgeOutWithSameLabel = getEdgesOut().get(edge.getLabel());
        if (edgeOutWithSameLabel == null) { //no edge with the label of e
            getEdgesOut().put(edge.getLabel(), edge);
            getEdges().add(edge);
            checkRep();
            return true;
        }else{
            checkRep();
            return false;
        }
    }
    /**
     *
     * @returns label of this
     */
    public E getLabel(){
        checkRep();
        return label;
    }
    /**
     * @effects Check that the rep invariant is true.
     */
    private void checkRep(){
        assert(label != null):"name is null";
        assert(edges != null):"edges is null";
        assert(edgesIn != null):"edgesIn is null";
        assert(edgesOut != null):"edges is null";
    }
}
