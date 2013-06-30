/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

/**
 *
 * @author jappie
 */
public interface ISpatialCollectionFactory {
    public Iterable<Spatial> createSpatials(Vector3f where);
}
