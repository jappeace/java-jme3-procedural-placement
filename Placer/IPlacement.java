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
    public Node getOn();

    /**
     * @return the _what
     */
    public Spatial getWhat();
    
}
