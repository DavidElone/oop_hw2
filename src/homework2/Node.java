package homework2;
import javax.swing.*;
import java.util.ArrayList;

public class Node<E> {
    private E label;
    private ArrayList<Edge<E>> edges = new ArrayList<>();

    //Abstraction function:
    // Class that describes a simple node with label and edges connected to it

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
    public ArrayList<Edge<E>> getEdges() {
        checkRep();
        return edges;
    }


    /**
     *
     * @returns edge in this.edges by label if exists, else returns null
     */

    public Edge<E> getEdge(E label){
        checkRep();
        for (int i = 0; i < this.edges.size(); i++) {
            if (this.edges.get(i).getLabel() == label) {
                return this.edges.get(i);
            }
        }
        return null;
    }
    /**
     *
     * @returns edge in this.edges by label if exists, else returns null
     */

    public int getNumOfEdgeWithSameLabel(E label){
        checkRep();
        int res = 0;
        for (int i = 0; i < this.edges.size(); i++) {
            if (this.edges.get(i).getLabel() == label) {
                res++;
            }
        }
        return res;
    }

    /**
     *
     * @modifies this
     * @effects adds edge to this.edges if the label doesn't exist. throws exception otherwise
     */

    public void addEdge(Edge<E> e) throws LabelAlreadyExists, NoParentException, NoChildException {
        checkRep();
        Edge<E> edgeWithSameLabel = getEdge(e.getLabel());
        if (edgeWithSameLabel == null) { //no edge with the label of e
            edges.add(e);
        } else if (e.getParent() == edgeWithSameLabel.getChild() || edgeWithSameLabel.getParent() == e.getChild() && getNumOfEdgeWithSameLabel(e.getLabel()) ==1) {//check the case that 2 edge can have the same name
            edges.add(e);
        }else {
            throw new LabelAlreadyExists();
        }
        checkRep();
    }

    /**
     *
     * @return true if edge e connected to this
     */
    public boolean isConnectedTo(Edge<E> e){

        for (int i = 0; i < this.edges.size(); i++) {
            if (this.edges.get(i).getLabel() == e.getLabel()) {
                if (this.edges.get(i).getNodeA().getLabel() == e.getNodeA().getLabel() &&
                        this.edges.get(i).getNodeB().getLabel() == e.getNodeB().getLabel())
                    checkRep();
                    return true;
            }
        }
        checkRep();
        return false;
    }

    /**
     *
     * @modifies this
     * @effects removes edge from this.edges, throw exception if there is no edge to remove
     */
    public void removeEdge(Edge<E> edge) throws EdgeNoExists {
        if (!(isConnectedTo(edge))) {
            throw new EdgeNoExists();
        }
        else {
            checkRep();
            this.edges.remove(edge);
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
        assert(edges != null):"edges_in is null";
    }
}
