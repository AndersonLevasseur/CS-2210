package project3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
* This class tests the RPNCalculator Class for compliance with the Project 3 
* description 
*
* @author Anderson Levasseur
* @version 1.0
* @exception InvalidRPNString
* File: RPNCalculatorTest.java
* Created: October 2023
* ©Copyright Cedarville University, its Computer Science faculty, and the
* authors. All rights reserved.
* Summary of Modifications:
* 6 October 2023 built out class
*/
public class RPNCalculatorTest {
    RPNCalculator rpn;

    /**
     * Instantiates a new RPNCalculator before every test
     */
    @BeforeEach
    public void setUp() {
        rpn = new RPNCalculator();
    }

    /**
     * Tests whether the RPNCalculator handles integers
     */
    @Test
    public void Handles_integers() {
        assertEquals(3.0, rpn.compute("1 2 +"));
    }

    /**
     * Tests whether the RPNCalculator handles doubles
     */
    @Test
    public void Handles_doubles() {
        assertEquals(6.2, rpn.compute("3.3 2.9 +"), 0.000000000000002);
    }

    /**
     * Tests whether the RPNCalculator throws when passed an invalid character
     */
    @Test
    public void Throws_when_passed_char() {
        InvalidRPNString e = assertThrows(InvalidRPNString.class, () -> {
            rpn.compute("3 i +");
        });
        assertTrue(e.getMessage().contains("Invalid character"));
    }

    /**
     * Tests whether the RPNCalculator throws InvalidRPNCalculator error when not
     * given enough operators
     */
    @Test
    public void Throws_when_too_many_numbers() {
        InvalidRPNString e = assertThrows(InvalidRPNString.class, () -> {
            rpn.compute("3 3 3 4.2 +");
        });
        assertTrue(e.getMessage().contains("Too many numbers"));
    }

    /**
     * Tests whether the RPNCalculator throws InvalidRPNCalculator error when not
     * given enough operators
     */
    @Test
    public void Throws_when_wrong_order() {
        InvalidRPNString e = assertThrows(InvalidRPNString.class, () -> {
            rpn.compute("3 + 3 3 + 4.2 -");
        });
        assertTrue(e.getMessage().contains("Too many operators"));
    }

    /**
     * Tests whether the RPNCalculator throws InvalidRPNCalculator error when gven
     * too many operators
     */
    @Test
    public void Throws_when_too_many_operators() {
        InvalidRPNString e = assertThrows(InvalidRPNString.class, () -> {
            rpn.compute("3 13 * -");
        });
        assertTrue(e.getMessage().contains("Too many operators"));
    }

    /**
     * Tests whether the RPNCalculator can add numbers successfully
     */
    @Test
    public void AdditionOperator() {
        assertEquals(5.0, rpn.compute("3.0 2.0 +"));
        assertEquals(-14.0, rpn.compute("-11.5 -2.5 +"));
    }

    /**
     * Tests whether the RPNCalculator can subtract numbers successfully
     */
    @Test
    public void SubtractionOperator() {
        assertEquals(1.0, rpn.compute("-1 -2 -"));

        // delta is accounting for rounding error in double
        assertEquals(1.3, rpn.compute("3.4 2.1 -"), 0.000000000000002);
    }

    /**
     * Tests whether the RPNCalculator can multiply numbers successfully
     */
    @Test
    public void MultiplicationOperator() {
        assertEquals(6.0, rpn.compute("-3 -2 *"));
        assertEquals(41.91, rpn.compute("3.3 12.7 *"));
    }

    /**
     * Tests whether the RPNCalculator can divide numbers successfully
     */
    @Test
    public void DivisionOperator_negative() {
        assertEquals(0.5, rpn.compute("-1.0 -2.0 /"));
    }

    /**
     * Tests whether the RPNCalculator thows InvalidRPNString when attempting to divide by zero
     */
    @Test
    public void Throws_DivisionOperator_divideByZero() {
        InvalidRPNString e = assertThrows(InvalidRPNString.class, () -> {
            rpn.compute("1233 0 /");
        });
        assertTrue(e.getMessage().contains("Cannot divide by zero"));
    }

    /**
     * A couple of tests, that are big and confusing
     */
    @Test
    public void Big_Bois() {
        //
        assertEquals(-1.0000000278348586,
                rpn.compute("-1.0 -2.0 19231.2 262 - 812931.12312 + 21923 / 9 * 210391 * / +"));
        assertEquals(3.000273806027093635999077060,
                rpn.compute("1.0 2.0 19231.2 262 812931.12312 + 21923 / 9 * 210391 * / + +"));

    }
}
