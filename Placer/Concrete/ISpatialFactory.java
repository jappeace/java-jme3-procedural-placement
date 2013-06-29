/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

/**
 * Use this interface to define how the spatials are created. Then this framework will place them.
 * @author jappie
 */
public interface ISpatialFactory {
    public Spatial createSpatial(Vector3f where);
}
