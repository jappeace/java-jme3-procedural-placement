package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author jappie
 */
public class CreatePlace extends Place{
    private ISpatialFactory _factory;
    public CreatePlace(ISpatialFactory factory){
        super();
        construct(factory);
        
    }
    public CreatePlace(Node root, ISpatialFactory factory){
	super(root);
        construct(factory);
    }
    
    private void construct(ISpatialFactory factory){
        _factory = factory;
    }
    @Override
    protected Spatial place(Node on, Vector3f where) {
        Spatial creation = _factory.createSpatial(where);
        place(creation, on, where);
        return creation;
    }
}
