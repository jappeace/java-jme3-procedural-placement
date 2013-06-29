/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.ISpatialFactory;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.SpatialPlacer;

/**
 *
 * @author jappie
 */
public class Place extends SpatialPlacer{
    
    public Place(Node root, ISpatialFactory factory){
	super(root, factory);
    }
    
    public void place(Spatial what, Node on, Vector3f where) {
        on.attachChild(what);
	what.setLocalTranslation(where);
    }
}
