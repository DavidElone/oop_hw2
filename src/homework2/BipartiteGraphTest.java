package homework2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * BipartiteGraphTest contains JUnit block-box unit tests for BipartiteGraph.
 */
public class BipartiteGraphTest {

	@Test
    public void testExample() throws NoChildException, NoParentException {
        BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();

        //create a graph
        driver.createGraph("graph1");

        //add a pair of nodes
        driver.addBlackNode("graph1", "n1");
        driver.addWhiteNode("graph1", "n2");

        //add an edge
        driver.addEdge("graph1", "n1", "n2", "edge");

        //check neighbors
        assertEquals("wrong black nodes", "n1", driver.listBlackNodes("graph1"));
        assertEquals("wrong white nodes", "n2", driver.listWhiteNodes("graph1"));
        assertEquals("wrong children", "n2", driver.listChildren ("graph1", "n1"));
        assertEquals("wrong children", "", driver.listChildren ("graph1", "n2"));
        assertEquals("wrong parents", "", driver.listParents ("graph1", "n1"));
        assertEquals("wrong parents", "n1", driver.listParents ("graph1", "n2"));

    }

	@Test
    public void test2() throws NoChildException, NoParentException {
        BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();

        //create a graph
        driver.createGraph("graph2");

        //add a pair of nodes
        driver.addBlackNode("graph2", "n1");
        driver.addWhiteNode("graph2", "n2");
        driver.addBlackNode("graph2", "n3");
        driver.addWhiteNode("graph2", "n4");
        driver.addBlackNode("graph2", "n5");
        driver.addWhiteNode("graph2", "n6");

        //add an edge
        driver.addEdge("graph2", "n4", "n2", "z");
        driver.addEdge("graph2", "n4", "n3", "y");
        driver.addEdge("graph2", "n4", "n5", "z");
        driver.addEdge("graph2", "n3", "n1", "x");
        driver.addEdge("graph2", "n3", "n5", "x");
        driver.addEdge("graph2", "n6", "n3", "x");
        driver.addEdge("graph2", "n2", "n3", "x");




        //check neighbors
        assertEquals("wrong black nodes", "n1 n3 n5", driver.listBlackNodes("graph2"));
        assertEquals("wrong white nodes", "n2 n4 n6", driver.listWhiteNodes("graph2"));
        assertEquals("wrong children", "", driver.listChildren ("graph2", "n1"));
        assertEquals("wrong children", "n3 n5", driver.listChildren ("graph2", "n4"));
        assertEquals("wrong parents", "n4 n6", driver.listParents ("graph2", "n3"));
        assertEquals("wrong parents", "n4", driver.listParents ("graph2", "n5"));
        assertEquals("wrong parents", "n3", driver.getChildByEdgeLabel("graph2", "n4","y"));
        assertEquals("wrong parents", "n3", driver.getChildByEdgeLabel("graph2", "n6","x"));
        assertEquals("wrong parents", "n4", driver.getParentByEdgeLabel("graph2", "n5","z"));




    }




    //  TODO: Add black-box tests


}
