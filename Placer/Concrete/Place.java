package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author jappie
 */
public abstract class Place extends SpatialPlacer{
    public Place(){
        super();
    }
    public Place(Node root){
        super(root);
    }
    public void place(Spatial what, Node on, Vector3f where) {
        on.attachChild(what);
    }
    
}
