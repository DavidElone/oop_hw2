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
        //TODO checkRep();
    }

    /**
     *
     * @returns this.edges
     */
    public ArrayList<Edge<E>> getEdges() {
        return edges;
    }


    /**
     *
     * @returns edge in this.edges by label if exists, else returns null
     */

    public Edge<E> getEdge(E label){
        for (int i = 0; i < this.edges.size(); i++) {
            if (this.edges.get(i).getLabel() == label) {
                return this.edges.get(i);
            }
        }
        return null;
    }

    /**
     *
     * @modifies this
     * @effects adds edge to this.edges if the label doesn't exist. throws exception otherwise
     */

    public void addEdge(Edge<E> e) {
        if (getEdge(e.getLabel()) == null) { //no edge with the label of e
            edges.add(e);
        }
        else {
            //TODO add exception here
            return;
        }
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
                    return true;
            }
        }
        return false;
    }

    /**
     *
     * @modifies this
     * @effects removes edge from this.edges
     */
    public void removeEdge(Edge<E> edge){
        if (!(isConnectedTo(edge)))
            //TODO add exception here
            return;
        else
            this.edges.remove(edge);
    }

    /**
     *
     * @returns label of this
     */
    public E getLabel(){
        return label;
    }

}
