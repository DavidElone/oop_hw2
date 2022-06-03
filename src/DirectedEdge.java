public class DirectedEdge<E> extends Edge<E>{
    //Abstraction function:
    // Class that describes a directed edge by his label. DirectedEdge is connecting parent's node to child's node


    /**
     * @requires args != null
     * @modifies this
     * @effects create a new edge.
     */
    DirectedEdge(E labelEdge, Node<E> parent, Node<E> child){
        super(labelEdge, parent,child);
    }

    /**
     * @returns parent's node of this
     */
    public Node getParent(){
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
}
