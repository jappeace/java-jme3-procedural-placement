package nl.jappieklooster.JME3.ProceduralPlacement.Placer;

import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 * I needed a return value that contained a spatial and a node.
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
