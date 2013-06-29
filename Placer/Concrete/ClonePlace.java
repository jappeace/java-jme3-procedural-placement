/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 * I now cloning is a form of creation, but I'm often to lazy to write a factory.
 * @author jappie
 */
public class ClonePlace extends Place{
    private Spatial _what;
    public ClonePlace(Node root, Spatial what){
        super(root);
        _what = what;
    }

    @Override
    protected Spatial place(Node on, Vector3f where) {
        Spatial clone = _what.clone();
        place(clone, on, where);
        return clone;
    }

    /**
     * @param what the _what to set
     */
    protected void setWhat(Spatial what) {
        this._what = what;
    }
}
