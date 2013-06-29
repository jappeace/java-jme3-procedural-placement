package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.Iterator;
import java.util.List;

/**
 * Places somthing without any decoration.
 * @author jappie
 */
public class Multiple extends ConcretePlacer{
    private Iterator<Spatial> _iterator;
    private List<Spatial> _templates;
    public Multiple(Node root, List<Spatial> templates){
	super(root);
	_templates = templates;
	resetIterator();
    }

    @Override
    public void place(Node on, Vector3f where) {
	if(!_iterator.hasNext()){
	    resetIterator();
	}        
        super.place(on, where, _iterator.next().clone());
    }
    
    public final void resetIterator(){
	_iterator = _templates.iterator();
    }
}
