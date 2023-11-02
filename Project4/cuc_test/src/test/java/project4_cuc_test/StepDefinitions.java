package project4_cuc_test;

import project4.ArrayQueue;
import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    ArrayQueue<Integer> a;

    @Given("Integer ArrayQueue is empty")
    public void anExampleScenario() {
        a = new ArrayQueue();
    }

    @When("an Integer three is enqueued")
    public void allStepDefinitionsAreImplemented() {
        a.enqueue(3);
    }


}
