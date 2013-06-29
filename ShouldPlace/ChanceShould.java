package nl.jappieklooster.JME3.ProceduralPlacement.ShouldPlace;

import com.jme3.math.Vector3f;
import com.jme3.terrain.geomipmap.TerrainQuad;

/**
 * For game logic this makes no sense, But I needed some test logic
 * @author jappie
 */
public class ChanceShould implements IShouldPlace {
    
    private static final double ONE = 1;
    private static final double IN = 10000;

    public boolean shouldPlace(Vector3f where) {
	
	return Math.random() < (ONE / IN);
    }

    /**
     * ChancheShould does not care about terain data
     * @param cell
     * @param quad 
     */
    public void setTerainData(Vector3f cell, TerrainQuad quad) {}

}
