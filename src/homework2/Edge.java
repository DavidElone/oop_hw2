package homework2;
import java.util.ArrayList;

public class Edge<E> {


    //Abstraction function:
    // Class that describes a simple edge by his label and the two nodes that it is connecting one to another

    //Rep. invariant:
    // nodeA != nodeB
    private E label;
    private Node nodeA;
    private Node nodeB;
    private boolean isDirected;

    /**
     * @requires args != null
     * @modifies this
     * @effects create a new edge.
     */
    Edge(E label, Node<E> nodeA, Node<E> nodeB,boolean isDirected){
        this.label = label;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.isDirected = isDirected;
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
     * @returns parent's node of this
     */
    public Node getParent(){//TODO if this.isDirected == false throw exception
        return getNodeA();
    }
    /**
     * @returns child's node of this
     */
    public Node getChild(){
        return getNodeB();
    }
    /**
     * @modifie parent's node of this to parent
     */
    public void setParent(Node parent){
        setNodeA(parent);
    }
    /**
     * @modifie child's node of this to child
     */
    public void setChild(Node child){
        setNodeB(child);
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
