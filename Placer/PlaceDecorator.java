/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.Placer;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 *
 * @author jappie
 */
public abstract class PlaceDecorator implements IPlacer{
    private IPlacer _component;
    
    public PlaceDecorator(IPlacer component){
        _component = component;
    }

    public void place(Node on, Vector3f where) {
        _component.place(on, where);
    }
}
