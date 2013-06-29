/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Decoration;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author jappie
 */
public interface IQuaternionFactory {
    public Quaternion createQuaternion(Spatial what, Node on, Vector3f where);
}
