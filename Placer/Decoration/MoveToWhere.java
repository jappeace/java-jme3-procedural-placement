package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Decoration;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.IPlacer;

/**
 *
 * @author jappie
 */
public class MoveToWhere extends Decorator{
    public MoveToWhere(IPlacer component){
        super(component);
    }
    @Override
    public void place(Spatial what, Node on, Vector3f where) {
        super.place(what, on, where);
	what.setLocalTranslation(where);
    }
}
