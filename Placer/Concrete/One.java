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
public class One extends ConcretePlacer{
    private Spatial _template;
    public One(Node root, Spatial template){
	super(root);
	_template = template;
    }

    @Override
    public void place(Node on, Vector3f where) {
        super.place(on, where, _template.clone());
    }
}
