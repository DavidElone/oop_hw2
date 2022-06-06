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
        checkRep();
    }

    /**
     * @returns nodeA
     */
    public Node getNodeA(){
        checkRep();
        return nodeA;
    }
    /**
     * @returns nodeB
     */
    public Node getNodeB(){
        checkRep();
        return nodeB;
    }
    /**
     * @modifie nodeA to  a
     */
    public void setNodeA(Node a){
        checkRep();
        this.nodeA = a;
        checkRep();
    }
    /**
     * @modifie nodeB to  b
     */
    public void setNodeB(Node b){
        checkRep();
        this.nodeB = b;
        checkRep();
    }
    /**
     * @returns parent's node of this
     */
    public Node getParent() throws NoParentException{//TODO if this.isDirected == false throw exception
        if(!isDirected){
            throw new NoParentException();
        }
        return getNodeA();
    }
    /**
     * @returns child's node of this
     */
    public Node getChild() throws NoChildException{
        if(!isDirected){
            throw new NoChildException();
        }
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
        checkRep();
        return label;
    }
    /**
     * @effects Check that the rep invariant is true.
     */
    private void checkRep() {
        assert this.nodeA != null: "nodeA can't be null";
        assert this.nodeB != null: "nodeB can't be null";
        assert this.label != null: "label can't be null";
        assert(!this.nodeA.equals(this.nodeB)): "edge connect between two differents nodes";

    }

}
