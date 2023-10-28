import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hw5.NodeListStack;

public class NodeListStackTest {
    NodeListStack d;

    @BeforeEach
    public void setup() {
        d = new NodeListStack<Character>();
    }

    @Test
    public void Stack_Pushes_Checks_With_Size() {
        d.push("N");
        assertEquals(1, d.size());
    }

    @Test
    public void Stack_Pushes_Checks_With_Top() {
        d.push('N');
        assertEquals('N', d.top());
    }

    @Test
    public void Stack_Pushes_Checks_With_Pop() {
        d.push('N');
        assertEquals('N', d.pop());
    }
    
    @Test
    public void () {
        d.push('N');
        assertEquals('N', d.top());
    }
}
