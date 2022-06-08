package homework2;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;


public class SimulatorTest {

    @Test
    public void testSimplePlusFilter() throws NoChildException, NoParentException {
        SimulatorTestDriver simulatorSimplePlusFilter = new SimulatorTestDriver();
        simulatorSimplePlusFilter.createSimulator("simplePlusFilterSimulation");

        simulatorSimplePlusFilter.addPlusFilter("simplePlusFilterSimulation", "PlusFilter");

        Integer numOfPipesIn = 3;

        for(Integer i = 0; i < numOfPipesIn; i++) {
            simulatorSimplePlusFilter.addPipe("simplePlusFilterSimulation", String.join("", "pipe_in_", i.toString()));
            simulatorSimplePlusFilter.addEdge("simplePlusFilterSimulation", String.join("", "pipe_in_", i.toString()), "PlusFilter", String.join("edge_in_", i.toString()));

        }

        simulatorSimplePlusFilter.addPipe("simplePlusFilterSimulation","pipe_out");
        simulatorSimplePlusFilter.addEdge("simplePlusFilterSimulation", "PlusFilter", "pipe_out", "edge_out");


        simulatorSimplePlusFilter.injectInput("simplePlusFilterSimulation", "pipe_in_0", 1);
        simulatorSimplePlusFilter.injectInput("simplePlusFilterSimulation", "pipe_in_0", 5);
        simulatorSimplePlusFilter.injectInput("simplePlusFilterSimulation", "pipe_in_0", 6);
        //System.out.println("pipe_in_0 is " + simulatorSimplePlusFilter.listContents("simplePlusFilterSimulation", "pipe_in_0"));

        simulatorSimplePlusFilter.injectInput("simplePlusFilterSimulation", "pipe_in_1", 100);
        simulatorSimplePlusFilter.injectInput("simplePlusFilterSimulation", "pipe_in_1", 102);
        //System.out.println("pipe_in_1 is " + simulatorSimplePlusFilter.listContents("simplePlusFilterSimulation", "pipe_in_1"));

        simulatorSimplePlusFilter.injectInput("simplePlusFilterSimulation", "pipe_in_2", 123);
        simulatorSimplePlusFilter.injectInput("simplePlusFilterSimulation", "pipe_in_2", 7);
        //System.out.println("pipe_in_2 is " + simulatorSimplePlusFilter.listContents("simplePlusFilterSimulation", "pipe_in_2"));

        Integer numOfRounds = 5;

        for(Integer i = 0; i < numOfRounds; i++) {
            simulatorSimplePlusFilter.simulate("simplePlusFilterSimulation");
        }
        assertEquals("wrong pipe node output", "224 114 6 0 0", simulatorSimplePlusFilter.listContents("simplePlusFilterSimulation", "pipe_out"));
    }

    @Test
    public void testSimpleGCDFilter() throws NoChildException, NoParentException {
        SimulatorTestDriver simulatorSimpleGCDFilter = new SimulatorTestDriver();
        simulatorSimpleGCDFilter.createSimulator("simpleGCDFilterSimulation");

        simulatorSimpleGCDFilter.addGCDFilter("simpleGCDFilterSimulation", "GCDFilter");

        Integer numOfPipesIn = 2;
        for(Integer i = 0; i < numOfPipesIn; i++) {
            simulatorSimpleGCDFilter.addPipe("simpleGCDFilterSimulation", String.join("", "pipe_in_", i.toString()));
            simulatorSimpleGCDFilter.addEdge("simpleGCDFilterSimulation", String.join("", "pipe_in_", i.toString()), "GCDFilter",(i == 0) ? "a" : "b");

        }
        simulatorSimpleGCDFilter.addPipe("simpleGCDFilterSimulation","pipe_out");

        simulatorSimpleGCDFilter.addEdge("simpleGCDFilterSimulation", "GCDFilter", "pipe_out", "gcd");
        simulatorSimpleGCDFilter.addEdge("simpleGCDFilterSimulation", "GCDFilter", "pipe_in_0", "a");
        simulatorSimpleGCDFilter.addEdge("simpleGCDFilterSimulation", "GCDFilter", "pipe_in_1", "b");


        simulatorSimpleGCDFilter.injectInput("simpleGCDFilterSimulation", "pipe_in_0", 35);
        simulatorSimpleGCDFilter.injectInput("simpleGCDFilterSimulation", "pipe_in_0", 12);
        //System.out.println("pipe_in_0 is " + simulatorSimplePlusFilter.listContents("simplePlusFilterSimulation", "pipe_in_0"));

        simulatorSimpleGCDFilter.injectInput("simpleGCDFilterSimulation", "pipe_in_1", 100);
        simulatorSimpleGCDFilter.injectInput("simpleGCDFilterSimulation", "pipe_in_1", 45);
        //System.out.println("pipe_in_1 is " + simulatorSimplePlusFilter.listContents("simplePlusFilterSimulation", "pipe_in_1"));

        Integer numOfRounds = 11;

        for(Integer i = 0; i < numOfRounds; i++) {
//			System.out.println("pipe_in_0 is " + simulatorSimpleGCDFilter.listContents("simpleGCDFilterSimulation", "pipe_in_0") + " at interation " + i);
//			System.out.println("pipe_in_1 is " + simulatorSimpleGCDFilter.listContents("simpleGCDFilterSimulation", "pipe_in_1") + " at interation " + i);
            simulatorSimpleGCDFilter.simulate("simpleGCDFilterSimulation");
        }
//		System.out.println("pipe_in_0 is " + simulatorSimpleGCDFilter.listContents("simpleGCDFilterSimulation", "pipe_in_0") + " at end");
//		System.out.println("pipe_in_1 is " + simulatorSimpleGCDFilter.listContents("simpleGCDFilterSimulation", "pipe_in_1") + " at end" );
        assertEquals("wrong pipe node output", "5 3 0", simulatorSimpleGCDFilter.listContents("simpleGCDFilterSimulation", "pipe_out"));
    }
}





