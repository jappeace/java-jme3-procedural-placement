package nl.jappieklooster.JME3.ProceduralPlacement.Placer;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import nl.jappieklooster.JME3.ProceduralPlacement.IPlaceCycleListener;

/**
 *
 * @author jappie
 */
public interface IPlacer extends IPlaceCycleListener{
    /**
     * places somthing on the coordinates where
     * @param where 
     */
    public IPlacement place(Vector3f where);
    
    /**
     * should place a what on a on with coordinates where.
     * @param what to be placed
     * @param on to receive a what
     * @param where place what on
     */
    public void place(Spatial what, Node on, Vector3f where);
    
    /**
     * terrain is to heavy to keep constant in memory, so this method should clear the current
     * quad that is set by IReceiveTerrainData
     */
    public void clear();
    
}
