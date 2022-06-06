package homework2;
public class BlackOrWhiteNode<E> extends Node<E>{
    private boolean isBlack;


    /**
     * @requires label, isBlack != null
     * @modifies this
     * @effects creates a new BlackOrWhiteNode.
     */
    BlackOrWhiteNode(E label,boolean isBlack){
        super(label);
        this.isBlack = isBlack;
    }
    public boolean isBlack(){
        return isBlack;
    }
}
