import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * A DirectedGraph is an implement of Graph. This is a graph with only directed edges
 */
public class DirectedGraph<E> extends Graph<E>{
    //Abstraction Function:
    // DirectedGraph is a Graph that work with DirectedEdge<E> where E is the label of the edges and the nodes

    // Rep. Invariant:
    //

    /**
     * @modifies this
     * @effects Adds a directed edge between nodes names parentLabel and childLabel in this.edges
     *          The new edge's label is edgeLabel.
     */
    @Override
    public boolean addEdge(E parentLabel, E childLabel,
                        E edgeLabel) {
        //do the same than Graph.addEdge but now we can choose which node is parent and which is child
        return super.addEdge(parentLabel, childLabel,edgeLabel);
    }
    /**
     * @requires parentLabel != null
     * @return a space-separated list of the names of the children of
     * 		   parentLabel in this, in alphabetical order.
     */
    public List<E> listChildren(E parentLabel) {
        List<E> nodes = new ArrayList<>();
        Node<E> parentNode = getNodeByLabel(parentLabel);
        Iterator it = parentNode.getEdges().iterator();
        for(Edge<E> e : parentNode.getEdges()){

            Node<E> child = (Node<E>) getChildByEdgeLabel(parentLabel,e.getLabel());
            if(child!=null){
                nodes.add(child.getLabel());
            }
        }
        //Collections.sort(nodes);//TODO
        return nodes;
        //create an empty list
        // Go over edges of  parentNode and call getChildByEdgeLabel. if getChildByEdgeLabel != null, add it to the list

    }


    /**
     * @requires childLabel != null
     * @return a space-separated list of the names of the parents of
     * 		   childName in this , in alphabetical order.
     */
    public List<E> listParents(E childLabel) {
        List<E> nodes = new ArrayList<>();
        Node<E> childNode = getNodeByLabel(childLabel);
        Iterator it = childNode.getEdges().iterator();
        for(Edge<E> e : childNode.getEdges()){

            Node<E> parent = (Node<E>) getParentByEdgeLabel(childLabel,e.getLabel());
            if(parent!=null){
                nodes.add(parent.getLabel());
            }
        }
        //Collections.sort(nodes);//TODO
        return nodes;
        //create an empty list
        // Go over edges of  parentNode and call getChildByEdgeLabel. if getChildByEdgeLabel != null, add it to the list

    }


    /**
     * @requires parentLabel and edgeLabel != null
     * @return the label of the child of parentLabel that is connected by the
     * 		   edge labeled edgeLabel, in this.
     */
    public E getChildByEdgeLabel(E parentLabel,
                                 E edgeLabel) {
        // Check if edgeLAbel is in parentLabel.edges , if edgeLabel.getChild =! parentLabel returns it else return exception "you ask for a child of a child"
        Node parent = getNodeByLabel(parentLabel);
        DirectedEdge edge = (DirectedEdge) parent.getEdge(edgeLabel);
        if(parent.getEdges().contains(edge)){
            Node child = edge.getChild();
            if( child != parent){
                return (E) child.getLabel();
            }
            else {
                return null;//TODO need eception here
            }
        }
        return null;//TODO need eception here

    }


    /**
     * @requires childLabel and edgeLabel != null
     * @return the label of the parent of childLabel that is connected by the
     * 		   edge labeled edgeLabel, in this.
     */
    public E getParentByEdgeLabel(E childLabel,
                                  E edgeLabel) {
        Node child = getNodeByLabel(childLabel);
        DirectedEdge edge = (DirectedEdge) child.getEdge(edgeLabel);
        if(child.getEdges().contains(edge)){
            Node parent = edge.getParent();
            if( parent != child){
                return (E) parent.getLabel();
            }
            else {
                return null;//TODO need eception here
            }
        }
        return null;//TODO need eception here

    }
}
