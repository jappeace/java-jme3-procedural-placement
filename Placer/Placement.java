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
public class Placement implements IPlacement {
    private Spatial _what;
    private Node _on;
    public Placement(Spatial what, Node on){
        _what = what;
        _on = on;
    }

    /**
     * @return the _what
     */
    @Override
    public Spatial getWhat() {
        return _what;
    }

    /**
     * @return the _on
     */
    @Override
    public Node getOn() {
        return _on;
    }
}
