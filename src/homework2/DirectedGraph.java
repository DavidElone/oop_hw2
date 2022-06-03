package homework2;
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

    public boolean addEdge(E parentLabel, E childLabel,
                        E edgeLabel) {
        //do the same than Graph.addEdge but now we can choose which node is parent and which is child
        return super.addEdge(parentLabel, childLabel,edgeLabel,true);
    }
    /**
     * @requires parentLabel != null
     * @return a space-separated list of the names of the children of
     * 		   parentLabel in this, in alphabetical order.
     */
    public List<E> listChildren(E parentLabel) {
        
        List<E> childrenLabel = new ArrayList<>();
        Node<E> parentNode = getNodeByLabel(parentLabel);
        //Go over parentNode.edges and find child != parentLabel
        Edge<E> e = null;
        ArrayList<Edge<E>> edges = parentNode.getEdges();
        for (int index = 0; index < edges.size(); index++) {
            e =  edges.get(index);
            E child = (E) e.getChild().getLabel();
            if(child!=null && child != parentLabel){
                childrenLabel.add(child);
            }
        }
        //Collections.sort(nodes);//TODO
        return childrenLabel;
        //create an empty list
        // Go over edges of  parentNode and call getChildByEdgeLabel. if getChildByEdgeLabel != null, add it to the list

    }


    /**
     * @requires childLabel != null
     * @return a space-separated list of the names of the parents of
     * 		   childName in this , in alphabetical order.
     */
    public List<E> listParents(E childLabel) {
        System.out.println("We are line 61 before the for each");
        List<E> parentsLabel = new ArrayList<>();
        Node<E> childNode = getNodeByLabel(childLabel);
        //Go over parentNode.edges and find child != parentLabel
        System.out.println("We are line 68 before the for each");
        Edge<E> e = null;
        ArrayList<Edge<E>> edges = childNode.getEdges();
        for (int index = 0; index < edges.size(); index++) {
            e =  edges.get(index);
            System.out.println("edge e is "+ e.getLabel());
            System.out.println("currentEdge is " + e.getLabel());
            E parent = (E) e.getParent().getLabel();
            System.out.println("child is " + parent);
            if(parent!=null && parent != childLabel){
                parentsLabel.add(parent);
            }
        }
        //Collections.sort(nodes);//TODO
        return parentsLabel;

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
        Edge edge = (Edge) parent.getEdge(edgeLabel);
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
        Edge edge = (Edge) child.getEdge(edgeLabel);
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
