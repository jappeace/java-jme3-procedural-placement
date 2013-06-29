package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.Iterator;
import java.util.List;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.SpatialPlacer;

/**
 * Places somthing without any decoration.
 * @author jappie
 */
public class Plain extends SpatialPlacer{
    private Iterator<Spatial> _iterator;
    private List<Spatial> _templates;
    public Plain(Node root, List<Spatial> templates){
	super(root);
	_templates = templates;
	resetIterator();
    }

    @Override
    public void place(Node on, Vector3f where) {
	if(!_iterator.hasNext()){
	    resetIterator();
	}
	Spatial target = _iterator.next().clone();
        
	on.attachChild(target);
	target.setLocalTranslation(where);
    }
    
    public final void resetIterator(){
	_iterator = _templates.iterator();
    }
}
