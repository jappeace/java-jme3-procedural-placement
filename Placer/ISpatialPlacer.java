package nl.jappieklooster.JME3.ProceduralPlacement.Placer;

import com.jme3.math.Vector3f;
import nl.jappieklooster.JME3.ProceduralPlacement.IReceiveTerrainData;

/**
 *
 * @author jappie
 */
public interface ISpatialPlacer extends IReceiveTerrainData, IPlacer{
    public void place(Vector3f where);
    
    public void onFinishedPlacing();
    
    public void onStartPlacing();
    
    /**
     * terrain is to heavy to keep constant in memory, so this method should clear the current
     * quad that is set by IReceiveTerrainData
     */
    public void clear();
}
