package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.terrain.geomipmap.TerrainQuad;
import java.util.HashMap;
import java.util.Map;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.IPlacement;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.IPlacer;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.Placement;
import nl.jappieklooster.JME3.ProceduralPlacement.TerrainDataAcces;

/**
 * Handles the mapping of spatials. Every cell gets its own node.
 * Also handles the loading and deloading of the spatials.
 * 
 * Its subclasses handle the creation of things. This is important since my own library does not even
 * use spatials (I wrap them in a class together with a physics controller). 
 * But I wanted to keep this in JME3 style.
 * @author jappie
 */
public abstract class SpatialPlacer extends TerrainDataAcces implements IPlacer {
    private static final String NODE_PREFIX = "SpatialScene:";
    
    private Map<Vector3f, Node> _nodes;
    private Node _root;
    
    
    public SpatialPlacer(Node root){
	_root = root;
	_nodes = new HashMap<Vector3f, Node>();
    }
    
    @Override
    public IPlacement place(Vector3f where) {	
        Node node = _nodes.get(getCell());
	return new Placement(
            place(
                node, 
                where
            ),
            node
        );
    }
    protected abstract Spatial place(Node on, Vector3f where);
    
    
    @Override
    public void onStartPlacing(){
 	if(! _nodes.containsKey(getCell())){
	    Node on = new Node(NODE_PREFIX + getCell().toString());
	    _root.attachChild(on);
	    _nodes.put(getCell(), on);
	}       
    }
    
    @Override
    public void onFinishedPlacing(){
	Node target = _nodes.get(getCell());
	target.setLocalTransform(getQuad().getWorldTransform());
        
        float size = -getQuad().getTotalSize()/2;
	target.move(
            new Vector3f(
                size*getQuad().getWorldScale().x, 
                0, 
                size*getQuad().getWorldScale().z
            )
        );
    }
    
    
    @Override
    public void clear() {
        Node node;
        Vector3f cell = getCell();
        boolean found = false;
        if(_nodes.containsKey(cell)){
            node = _nodes.get(cell);
            _root.detachChild(node);
            _nodes.remove(cell).detachAllChildren();
        }
	
	setTerainData(null, null);
    }
    
}
