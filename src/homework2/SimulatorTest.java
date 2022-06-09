package homework2;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;


public class SimulatorTest {

    @Test
    public void testPlusFilter() throws NoChildException, NoParentException {
        SimulatorTestDriver simulatorplusFilter = new SimulatorTestDriver();
        simulatorplusFilter.createSimulator("plusFilterSimulation");
        simulatorplusFilter.addPlusFilter("plusFilterSimulation", "plusFilter");



        for(Integer i = 1; i < 4; i++) {
            simulatorplusFilter.addPipe("plusFilterSimulation", String.join("", "pipe_", i.toString()));
            simulatorplusFilter.addEdge("plusFilterSimulation", String.join("", "pipe_", i.toString()), "plusFilter", String.join("edge_", i.toString()));

        }

        simulatorplusFilter.addPipe("plusFilterSimulation","pipe_out");
        simulatorplusFilter.addEdge("plusFilterSimulation", "plusFilter", "pipe_out", "edge_out");


        simulatorplusFilter.injectInput("plusFilterSimulation", "pipe_1", 28);
        simulatorplusFilter.injectInput("plusFilterSimulation", "pipe_1", 100);
        simulatorplusFilter.injectInput("plusFilterSimulation", "pipe_1", -1);

        simulatorplusFilter.injectInput("plusFilterSimulation", "pipe_2", 2);
        simulatorplusFilter.injectInput("plusFilterSimulation", "pipe_2", 200);

        simulatorplusFilter.injectInput("plusFilterSimulation", "pipe_3", 10);
        simulatorplusFilter.injectInput("plusFilterSimulation", "pipe_3", 50);



        for(Integer i = 1; i < 6; i++) {
            simulatorplusFilter.simulate("plusFilterSimulation");
        }
        assertEquals("wrong pipe node output", "40 350 -1 0 0", simulatorplusFilter.listContents("plusFilterSimulation", "pipe_out"));
    }

    @Test
    public void testGCDFilter() throws NoChildException, NoParentException {
        SimulatorTestDriver simulatorSimpleGCDFilter = new SimulatorTestDriver();
        simulatorSimpleGCDFilter.createSimulator("simpleGCDFilterSimulation");

        simulatorSimpleGCDFilter.addGCDFilter("simpleGCDFilterSimulation", "GCDFilter");

        for(Integer i = 1; i < 3; i++) {
            simulatorSimpleGCDFilter.addPipe("simpleGCDFilterSimulation", String.join("", "pipe_", i.toString()));
            simulatorSimpleGCDFilter.addEdge("simpleGCDFilterSimulation", String.join("", "pipe_", i.toString()), "GCDFilter",(i == 1) ? "a" : "b");
        }
        simulatorSimpleGCDFilter.addPipe("simpleGCDFilterSimulation","pipe_out");


        simulatorSimpleGCDFilter.addEdge("simpleGCDFilterSimulation", "GCDFilter", "pipe_1", "a");
        simulatorSimpleGCDFilter.addEdge("simpleGCDFilterSimulation", "GCDFilter", "pipe_2", "b");
        simulatorSimpleGCDFilter.addEdge("simpleGCDFilterSimulation", "GCDFilter", "pipe_out", "gcd");

        simulatorSimpleGCDFilter.injectInput("simpleGCDFilterSimulation", "pipe_1", 153);
        simulatorSimpleGCDFilter.injectInput("simpleGCDFilterSimulation", "pipe_1", 7);

        simulatorSimpleGCDFilter.injectInput("simpleGCDFilterSimulation", "pipe_2", 27);
        simulatorSimpleGCDFilter.injectInput("simpleGCDFilterSimulation", "pipe_2", 5);


        for(Integer i = 1; i < 9; i++) {
            simulatorSimpleGCDFilter.simulate("simpleGCDFilterSimulation");
        }
        assertEquals("wrong pipe node output", "9 1", simulatorSimpleGCDFilter.listContents("simpleGCDFilterSimulation", "pipe_out"));
    }

//    public void main() throws NoChildException, NoParentException {
//        SimulatorTest tester = new SimulatorTest();
//        tester.testPlusFilter();
//        tester.testGCDFilter();
//    }
}





