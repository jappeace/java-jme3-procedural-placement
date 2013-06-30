package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Decoration;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.IPlacer;

/**
 *
 * @author jappie
 */
public class Rotate extends Decorator{
    private IQuaternionFactory _factory;
    public Rotate(IPlacer component){
        this(component, 
            new IQuaternionFactory(){
                public Quaternion createQuaternion(Spatial what, Node on, Vector3f where) {
                    return Quaternion.ZERO;
                }
            }
        );
    }
    public Rotate(IPlacer component, IQuaternionFactory rotation){
        super(component);
        _factory = rotation;
    }

    @Override
    public void place(Spatial what, Node on, Vector3f where) {
        what.rotate(_factory.createQuaternion(what, on, where));
        super.place(what, on, where);
    }

    /**
     * @param factory the _factory to set
     */
    public void setFactory(IQuaternionFactory factory) {
        _factory = factory;
    }
}
