/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Decoration;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.IPlacer;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.PlaceDecorator;

/**
 *
 * @author jappie
 */
public class Rotate extends PlaceDecorator{
    Quaternion _rotation;
    public Rotate(IPlacer component){
        this(component, Quaternion.ZERO);
    }
    public Rotate(IPlacer component, Quaternion rotation){
        super(component);
        _rotation = rotation;
    }

    public void place(Spatial what, Node on, Vector3f where) {
        what.rotate(_rotation);
    }
}
