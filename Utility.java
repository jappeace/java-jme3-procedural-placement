/*
 * visit <a href="jappieklooster.nl">jappieklooster.nl</a> for more information about this license.
 */
package nl.jappieklooster.JME3.ProceduralPlacement;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author jappie
 */
public class Utility {
    private Utility(){}
    public static String getRandomString(){
        return new BigInteger(130, new SecureRandom()).toString(32);
    }
}
