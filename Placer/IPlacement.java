/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.Placer;

import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author jappie
 */
public interface IPlacement {

    /**
     * @return the _on
     */
    Node getOn();

    /**
     * @return the _what
     */
    Spatial getWhat();
    
}
