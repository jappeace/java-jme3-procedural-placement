/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author jappie
 */
public class Place extends SpatialPlacer{
    private ISpatialFactory _factory;
    
    public Place(Node root, ISpatialFactory factory){
	super(root);
        _factory = factory;
    }
    
    public void place(Spatial what, Node on, Vector3f where) {
        on.attachChild(what);
    }

    @Override
    void place(Node on, Vector3f where) {
        place(_factory.createSpatial(where), on, where);
    }
}
