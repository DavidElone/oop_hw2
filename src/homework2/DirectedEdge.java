package homework2;

public class DirectedEdge<E> {


    //Abstraction function:
    // Class that describes a simple DirectedEdge by his label , his parent and his child.

    //Rep. invariant:
    // nodeA != nodeB
    private E label;
    private Node parent;
    private Node child;

    /**
     * @requires args != null
     * @modifies this
     * @effects create a new edge.
     */
    DirectedEdge(E label, Node<E> parent, Node<E> child){
        this.label = label;
        this.parent = parent;
        this.child = child;
        checkRep();
    }

    /**
     * @returns parent
     */
    public Node getParent(){
        checkRep();
        return this.parent;
    }
    /**
     * @returns child
     */
    public Node getChild(){
        checkRep();
        return this.child;
    }
    /**
     * @modifie nodeA to  a
     */
    public void setParent(Node parent){
        checkRep();
        this.parent = parent;
        checkRep();
    }
    /**
     * @modifie nodeB to  b
     */
    public void setChild(Node child){
        checkRep();
        this.child = child;
        checkRep();
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
        assert this.parent != null: "parent can't be null";
        assert this.child != null: "child can't be null";
        assert this.label != null: "label can't be null";
        assert(!this.parent.equals(this.child)): "edge must connect between two differents nodes";

    }

}
