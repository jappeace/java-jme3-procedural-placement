package nl.jappieklooster.JME3.ProceduralPlacement.ShouldPlace;

import nl.jappieklooster.JME3.ProceduralPlacement.IReceiveTerrainData;
import com.jme3.math.Vector3f;
import nl.jappieklooster.JME3.ProceduralPlacement.IReceiveTerrainData;

/**
 *
 * @author jappie
 */
public interface IShouldPlace extends IReceiveTerrainData{
    public boolean shouldPlace(Vector3f where);
}
