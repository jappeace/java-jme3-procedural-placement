/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.Placer;

/**
 *
 * @author jappie
 */
public abstract class PlaceDecorator implements IPlacer{
    private IPlacer _component;
    
    public PlaceDecorator(IPlacer component){
        _component = component;
    }

    /**
     * @return the _component
     */
    public IPlacer getComponent() {
        return _component;
    }
}
