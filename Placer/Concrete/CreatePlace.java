/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 *
 * @author jappie
 */
public class CreatePlace extends Place{
    private ISpatialFactory _factory;
    
    public CreatePlace(Node root, ISpatialFactory factory){
	super(root);
        _factory = factory;
    }

    @Override
    void place(Node on, Vector3f where) {
        place(_factory.createSpatial(where), on, where);
    }
}
