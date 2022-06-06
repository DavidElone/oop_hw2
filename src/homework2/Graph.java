package homework2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Graph<E> {
    private HashMap<E,Node<E>> nodes= new HashMap<>();
    private ArrayList<Edge<E>> edges = new ArrayList<>();


    // Abstraction function:
    // defines a graph with Edge<E> (without direction) and Node<E>

    // Rep. Invariant:


    /**
     * @modifies this
     * @effects add node to this.nodes if node isn't in nodes and return true. Else return false.
     */
    public boolean addNode(Node<E> node) {
        //add node to nodes if not already in nodes
        if (getNodes().containsKey(node.getLabel()))
            return false;

        this.nodes.put(node.getLabel(),node);
        return true;

    }

    /**
     * @modifies this
     * @effects if node exists in this.nodes - remove it, update edges and return true. Else return false
     */
    public boolean removeNode(Node<E> node) {

        if (getNodes().containsKey(node.getLabel())) {
            return getNodes().remove(node.getLabel(),node);
        }
        return false;
    }

    /**
     * @modifies this
     * @effects Adds an edge between nodes names labelA and labelB in this. The new edge's label is edgeLabel.
     */
    public boolean addEdge(E labelA, E labelB, E edgeLabel,boolean isDirected) throws LabelAlreadyExists, NoChildException, NoParentException {

        if (getEdgeByLabel(labelA,labelB,edgeLabel) != null)
            return false;

        Node nodeA = getNodeByLabel(labelA);
        Node nodeB = getNodeByLabel(labelB);

        if (nodeA == null || nodeB == null)
            return false;

        Edge<E> newEdge = new Edge(edgeLabel, nodeA,  nodeB,isDirected);

        nodeA.addEdge(newEdge);
        nodeB.addEdge(newEdge);

        this.edges.add(newEdge);
        return true;
    }

    /**
     * @modifies this
     * @effects removes an edge named edgeLabel connecting nodes named labelA and labelB.
     *          If edge doesn't exist in this - return false. Else return true
     */
    public boolean removeEdge(E labelA, E labelB,
                           E edgeLabel) throws EdgeNoExists, NoChildException, NoParentException {
        Edge<E> edgeToRemove = getEdgeByLabel(labelA,labelB,edgeLabel);
        if (edgeToRemove == null)
            return false;

        Node<E> NodeA = edgeToRemove.getNodeA();
        Node<E> NodeB = edgeToRemove.getNodeB();

        NodeA.removeEdge(edgeToRemove);
        NodeB.removeEdge(edgeToRemove);

        this.edges.remove(edgeToRemove);
        return true;

    }

    /**
     *
     * @returns this.nodes
     */

    public HashMap<E,Node<E>> getNodes() {
        checkRep();
        return this.nodes;
    }

    /**
     *
     * @returns this.edges
     */

    public ArrayList<Edge<E>> getEdges() {
        checkRep();
        return this.edges;
    }

    /**
     * @returns node from this.nodes by its label, null if doesn't exist
     */

    public Node<E> getNodeByLabel(E label) {
        return nodes.get(label);
    }

    /**
     * @returns edge from this.edges by its label, null if doesn't exist
     */
    public Edge<E> getEdgeByLabel(E labelA, E labelB, E edgeLabel) throws NoParentException, NoChildException {

        for (int i = 0; i < this.edges.size(); i++) {
            if (this.edges.get(i).getLabel() == edgeLabel) {
                if ((this.edges.get(i).getNodeA().getLabel() == labelA) && (this.edges.get(i).getNodeB().getLabel() == labelB))
                    return this.edges.get(i);
            }
        }
        return null;
    }
    /**
     * @effects Check that the rep invariant is true.
     */
    private void checkRep(){
        assert nodes != null: "nodes is null";
        assert edges != null: "edges is null";
    }
}