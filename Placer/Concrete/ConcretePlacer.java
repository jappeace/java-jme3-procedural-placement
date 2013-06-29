/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.SpatialPlacer;

/**
 * final two lines of multiple and one where the same.
 * @author jappie
 */
public abstract class ConcretePlacer extends SpatialPlacer{
    
    public ConcretePlacer(Node root){
	super(root);
    }
    
    public void place(Node on, Vector3f where, Spatial target) {
        on.attachChild(target);
	target.setLocalTranslation(where);
    }
    
}
