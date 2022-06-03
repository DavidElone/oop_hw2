import java.util.*;

/**
 * A BipartiteGraph is an extension of DirectedGraph. Itsa particularity is that evry node is black or white and, nodes can connect only if they are from different colors.
 */
public class BipartiteGraph<E> extends DirectedGraph<E>{

    private ArrayList<E> blackNodesLabel = new ArrayList<>();
    private ArrayList<E> whiteNodesLabel = new ArrayList<>();

    //Override//TODO
    /**
     * @requires node != null
     * @return true if the node has been added
     * @modifies this
     * @effects adds node to the graph
     */
    public boolean addNode(BlackOrWhiteNode<E> node) {//TODO what if someone call addNode with Node and not BlackOrWhiteNode?
        boolean nodeIsAdded = super.addNode((Node<E>)node);
        if(nodeIsAdded){
            if(node.isBlack()) {
                blackNodesLabel.add(node.getLabel());
            }else {
                whiteNodesLabel.add(node.getLabel());
            }
            return true;
        }
        return false;
    }
    //Override//TODO
    /**
     * @requires node != null
     * @return true if the node has been removed
     * @modifies this
     * @effects removes node to the graph
     */
    public boolean removeNode(BlackOrWhiteNode<E> node) {
        //TODO if super.removeNode returns true, remove node from black/white nodes
        boolean nodeIsRemoved = super.removeNode((Node<E>) node);
        if(nodeIsRemoved){
            if(node.isBlack()) {
                blackNodesLabel.remove(node.getLabel());
            }else {
                whiteNodesLabel.remove(node.getLabel());
            }
            return true;
        }
        return false;
    }

    @Override
    /**
     * @requires parentLabel , childLabel and edgeLabel != null
     * @return true if the edge has been added
     * @modifies this
     * @effects Adds an edge from the node parentLabel to the node childLabel
     * 			in the graph. The new edge's label is edgeLabel.
     */
    public boolean addEdge(E parentLabel, E childLabel,
                        E edgeLabel) {
        //check if they have different colors
        BlackOrWhiteNode<E> parent = (BlackOrWhiteNode<E>)getNodeByLabel(parentLabel);
        BlackOrWhiteNode<E> child = (BlackOrWhiteNode<E>)getNodeByLabel(childLabel);
        if(parent.isBlack() == child.isBlack()){
            return false;
        }
        //if they do, create edge then call super.addEdge add  setParent and setChild of the edge
        DirectedEdge<E> edge = new DirectedEdge(edgeLabel,parent,child);
        boolean edgeIsAdded = super.addEdge(parentLabel,childLabel,edgeLabel);
        if(edgeIsAdded){
            edge.setParent(parent);
            edge.setChild(child);
            return true;
        }
        return false;
    }



    /**
     * @requires E is comparable ??TODO
     * @return a space-separated list of the labels of all the black nodes
     * 		   in the graph, in alphabetical order.
     */
    public List<E> listBlackNodes() {
        //TODO sort blackNodes and returns it

       // Collections.sort(blackNodesLabel);//TODO what is the pb. maybe E should be extends Comparable ?

        return blackNodesLabel;

    }


    /**
     * @requires E is comparable ??TODO
     * @return a space-separated list of the labels of all the black nodes
     * 		   in the graph, in alphabetical order.
     */
    public List<E> listWhiteNodes() {
        //TODO sort whiteNodes and returns it
        //Collections.sort(whiteNodesLabel);//TODO what is the pb. maybe E should be extends Comparable ?

        return whiteNodesLabel;

    }
    /**
     * @requires parentLabel , childLabel and edgeLabel != null
     * @return the edge that have edgeLabel as label and that is connect from parentLabel's node to childLabel's node
     */
    @Override
    public DirectedEdge<E> getEdgeByLabel(E parentLabel, E childLabel, E edgeLabel) {
        ArrayList<Edge<E>> edges = getEdges();
        for (int i = 0; i < getEdges().size(); i++) {
            if (edges.get(i).getLabel() == edgeLabel) {
                if ((((DirectedEdge<E>)edges.get(i)).getParent().getLabel() == parentLabel) && (((DirectedEdge<E>)edges.get(i)).getChild().getLabel() == childLabel))
                    return ((DirectedEdge<E>)edges.get(i));
            }
        }
        return null;
    }




}
