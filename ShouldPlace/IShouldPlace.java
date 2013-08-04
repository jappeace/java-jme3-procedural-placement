package nl.jappieklooster.JME3.ProceduralPlacement.ShouldPlace;

import com.jme3.math.Vector3f;
import nl.jappieklooster.JME3.ProceduralPlacement.IPlaceCycleListener;

/**
 *
 * @author jappie
 */
public interface IShouldPlace extends IPlaceCycleListener{
    public boolean shouldPlace(Vector3f where);
}
