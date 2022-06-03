import java.util.ArrayList;

public class Edge<E> {


    //Abstraction function:
    // Class that describes a simple edge by his label and the two nodes that it is connecting one to another

    //Rep. invariant:
    // nodeA!=node!B
    private E label;
    private Node nodeA;
    private Node nodeB;

    /**
     * @requires args != null
     * @modifies this
     * @effects create a new edge.
     */
    Edge(E label, Node<E> nodeA, Node<E> nodeB){
        this.label = label;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    /**
     * @returns nodeA
     */
    public Node getNodeA(){
        return nodeA;
    }
    /**
     * @returns nodeB
     */
    public Node getNodeB(){
        return nodeB;
    }
    /**
     * @modifie nodeA to  a
     */
    public void setNodeA(Node a){
        this.nodeA = a;
    }
    /**
     * @modifie nodeB to  b
     */
    public void setNodeB(Node b){
        this.nodeB = b;
    }
    /**
     * @returns this.label
     */
    public E getLabel(){
        return label;
    }
    /**
     * @modifie label to  label_
     */
    public void setLabel(E label_){
        this.label = label_;
    }

}
