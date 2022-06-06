package homework2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SimulatorTest
{

	/**
	 * @effects example for a test of Simulator.
	 */
	@Test
    public void testExample() throws NoParentException, NoChildException, LabelAlreadyExists {
		SimulatorTestDriver driver = new SimulatorTestDriver();

        driver.createSimulator("sim");

        //create and add nodes
		driver.addPipe("sim", "pipeA");
		driver.addPipe("sim", "pipeB");
		driver.addPipe("sim", "pipeC");
		driver.addPipe("sim", "pipeD");
		driver.addPipe("sim", "pipeE");
		driver.addPipe("sim", "pipeF");
		driver.addPlusFilter("sim", "plusFilter1");
		driver.addGCDFilter("sim", "gcdFilter1");


        //create and add edges
        driver.addEdge("sim", "pipeA", "plusFilter1", "pAtoPF1");
        driver.addEdge("sim", "pipeB", "plusFilter1", "pBtoPF1");

        driver.addEdge("sim", "pipeC", "gcdFilter1", "a");
		driver.addEdge("sim", "pipeD", "gcdFilter1", "b");
		driver.addEdge("sim", "gcdFilter1", "pipeC", "a");
		driver.addEdge("sim", "gcdFilter1", "pipeD", "b");
		driver.addEdge("sim", "gcdFilter1", "pipeE", "gcd");



        //TODO - add checks
    }


	/**
	 * @effects create a test for Simulator.
	 */
    public void main() throws NoChildException, NoParentException, LabelAlreadyExists {
    	SimulatorTest tester = new SimulatorTest();
    	tester.testExample();
    }

}



