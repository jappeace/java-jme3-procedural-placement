package nl.jappieklooster.JME3.ProceduralPlacement;

import com.jme3.math.Vector3f;
import com.jme3.terrain.geomipmap.TerrainQuad;

/**
 *
 * @author jappie
 */
public abstract class TerrainDataAcces implements IPlaceCycleListener{
    private static final float ROUNDING_CORRECTION = 0.1f;
    
    private Vector3f _currentCell;
    private TerrainQuad _currentQuad;
    
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
