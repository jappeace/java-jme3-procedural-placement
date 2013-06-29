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
public interface IPlacer {
    public abstract void place(Node on, Vector3f where);
}
