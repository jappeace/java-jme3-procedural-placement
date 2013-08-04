package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Decoration;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.terrain.geomipmap.TerrainQuad;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.IPlacement;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.IPlacer;

/**
 *
 * @author jappie
 */
public abstract class Decorator implements IPlacer{
    private IPlacer _component;
    
    public Decorator(IPlacer component){
        _component = component;
    }

    /**
     * @return the _component
     */
    private IPlacer getComponent() {
        return _component;
    }

    public IPlacement place(Vector3f where) {
        IPlacement placement = getComponent().place(where);
        // manual call is necisary because this method is called from the concrete's inside
        place(placement.getWhat(), placement.getOn(), where);
        return placement;
    }

    public void onFinishedPlacing() {
        getComponent().onFinishedPlacing();
    }

    public void onStartPlacing() {
        getComponent().onStartPlacing();
    }

    public void clear() {
        getComponent().clear();
    }

    public void place(Spatial what, Node on, Vector3f where) {
        getComponent().place(what, on , where);
    }

    public void setTerainData(Vector3f cell, TerrainQuad quad) {
        getComponent().setTerainData(cell, quad);
    }
}
