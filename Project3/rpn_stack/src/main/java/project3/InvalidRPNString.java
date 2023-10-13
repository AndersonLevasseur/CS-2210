package project3;

/**
* This class is a InvalidRPNString and extends a RuntimeException
*
* @author Anderson Levasseur
* @version 1.0 
* File: InvalidRPNString.java
* Created: October 2023
* ©Copyright Cedarville University, its Computer Science faculty, and the
* authors. All rights reserved.
* Summary of Modifications:
* 6 October 2023 built out class
*
*
* Description: This class constructs an InvalidRPNString using the 
* RuntimeException class. When a string is given it will used as a message, and
* if no string is given it will construct without a message. 
*/
public class InvalidRPNString extends RuntimeException {
    /**
     * Creates InvalidRPNString using super()
     * @param message to be contained within Exception
     */
    public InvalidRPNString(String message) {
        super(message);
    }

    /**
     * Creates a messageless InvalidRPNString using super()
     */

    public InvalidRPNString() {
        new InvalidRPNString();
    }

}