package nl.jappieklooster.JME3.ProceduralPlacement.Placer;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.terrain.geomipmap.TerrainQuad;
import java.util.HashMap;
import java.util.Map;
import nl.jappieklooster.JME3.ProceduralPlacement.ISpatialPlacer;

/**
 * Handles the mapping of spatials. Every cell gets its own node.
 * Also handles the loading and deloading of the spatials
 * @author jappie
 */
public abstract class SpatialPlacer implements ISpatialPlacer {
    private static final String NODE_PREFIX = "SpatialScene:";
    private static final float ROUNDING_CORRECTION = 0.1f;
    
    private Map<Vector3f, Node> _nodes;
    private Vector3f _currentCell;
    private TerrainQuad _currentQuad;
    private Node _root;
    
    public SpatialPlacer(Node root){
	_root = root;
	_nodes = new HashMap<Vector3f, Node>();
    }
    
    @Override
    public void place(Vector3f where) {	
	place(
            _nodes.get(getCell()), 
	    where
	);
    }
    protected abstract void place(Node on, Vector3f where);
    
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
    @Override
    public void setTerainData(Vector3f cell, TerrainQuad quad){
	_currentCell = (cell == null) ? null : cell.clone();
	_currentQuad = quad;
        if(_currentCell != null){
            // somthimes I get weird halve cell values this fixes that
            _currentCell.x = Math.round(_currentCell.x + ROUNDING_CORRECTION);
            _currentCell.z = Math.round(_currentCell.z + ROUNDING_CORRECTION);
        }
    }

    /**
     * @return the _currentCell
     */
    protected Vector3f getCell() {
	return _currentCell;
    }

    /**
     * @return the _currentQuad
     */
    protected TerrainQuad getQuad() {
	return _currentQuad;
    }
}
