package homework2;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;


/**
 * BipartiteGraphTest contains JUnit block-box unit tests for BipartiteGraph.
 */
public class BipartiteGraphTest {

	@Test
    public void testExample() throws NoParentException, NoChildException, LabelAlreadyExists {
        BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();

        //create a graph
        driver.createGraph("graph1");

        //add a pair of nodes
        driver.addBlackNode("graph1", "A");
        driver.addWhiteNode("graph1", "Az");

        //add an edge
        driver.addEdge("graph1", "A", "Az", "edge");

        //check neighbors
        assertEquals("wrong black nodes", "A", driver.listBlackNodes("graph1"));
        assertEquals("wrong white nodes", "Az", driver.listWhiteNodes("graph1"));
        assertEquals("wrong children", "Az", driver.listChildren ("graph1", "A"));
        assertEquals("wrong children", "", driver.listChildren ("graph1", "Az"));
        assertEquals("wrong parents", "", driver.listParents ("graph1", "A"));
        assertEquals("wrong parents", "A", driver.listParents ("graph1", "Az"));
        System.out.println("finish");
    }


    @Test
    public void test2() throws NoChildException, NoParentException, NoChildFound, NoParentFound, LabelAlreadyExists {
        BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();

        //create a graph
        driver.createGraph("graph2");

        //add a pair of nodes
        driver.addBlackNode("graph2", "A");
        driver.addWhiteNode("graph2", "Az");
        driver.addBlackNode("graph2", "C");
        driver.addWhiteNode("graph2", "Cz");
        driver.addBlackNode("graph2", "B");
        driver.addWhiteNode("graph2", "Bz");

        //add an edge
        driver.addEdge("graph2", "Cz", "Az", "z");
        driver.addEdge("graph2", "Cz", "C", "y");
        driver.addEdge("graph2", "Cz", "B", "z");
        driver.addEdge("graph2", "C", "A", "x");
        driver.addEdge("graph2", "C", "B", "x");
        driver.addEdge("graph2", "Bz", "C", "x");
        try {
        	driver.addEdge("graph2", "Az", "C", "x");
        }
        catch(LabelAlreadyExists e) {
        	System.out.println("LabelAlreadyExists catched");
        }




        //check neighbors
        assertEquals("wrong black nodes", "A B C", driver.listBlackNodes("graph2"));
        assertEquals("wrong white nodes", "Az Bz Cz", driver.listWhiteNodes("graph2"));
        assertEquals("wrong children", "", driver.listChildren ("graph2", "A"));
        assertEquals("wrong children", "B C", driver.listChildren ("graph2", "Cz"));
        assertEquals("wrong parents", "Bz Cz", driver.listParents ("graph2", "C"));
        assertEquals("wrong parents", "Cz", driver.listParents ("graph2", "B"));
        assertEquals("wrong parents", "C", driver.getChildByEdgeLabel("graph2", "Cz","y"));
        assertEquals("wrong parents", "C", driver.getChildByEdgeLabel("graph2", "Bz","x"));
        assertEquals("wrong parents", "Cz", driver.getParentByEdgeLabel("graph2", "B","z"));


        System.out.println("finish_2");



    }


}
