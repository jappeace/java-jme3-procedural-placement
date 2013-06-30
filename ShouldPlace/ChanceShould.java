package nl.jappieklooster.JME3.ProceduralPlacement.ShouldPlace;

import com.jme3.math.Vector3f;

/**
 * For game logic this makes no sense, But I needed some test logic
 * @author jappie
 */
public class ChanceShould extends ShouldPlace implements IShouldPlace {
    
    private static final double ONE = 1;
    private static final double IN = 10000;

    public boolean shouldPlace(Vector3f where) {
	
	return Math.random() < (ONE / IN);
    }
}
