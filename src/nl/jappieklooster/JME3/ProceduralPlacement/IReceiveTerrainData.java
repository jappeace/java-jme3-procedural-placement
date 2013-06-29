package nl.jappieklooster.JME3.ProceduralPlacement;

import com.jme3.math.Vector3f;
import com.jme3.terrain.geomipmap.TerrainQuad;

/**
 *
 * @author jappie
 */
public interface IReceiveTerrainData {
    public void setTerainData(Vector3f cell, TerrainQuad quad);
}
