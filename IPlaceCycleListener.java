package nl.jappieklooster.JME3.ProceduralPlacement;

import com.jme3.math.Vector3f;
import com.jme3.terrain.geomipmap.TerrainQuad;

/**
 *
 * @author jappie
 */
public interface IPlaceCycleListener {
    /**
     * gives the listener acces to some terrain data. Which cell is being proceced in the grid
     * and how the terrain looks (the quad).
     * @param cell
     * @param quad 
     */
    public void setTerainData(Vector3f cell, TerrainQuad quad);
    /**
     * callback when there are no coordinates to place stuf on
     */
    public void onFinishedPlacing();
    
    /**
     * callback for if a placing cycle starts.
     */
    public void onStartPlacing();
}
