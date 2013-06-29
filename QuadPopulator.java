package nl.jappieklooster.JME3.ProceduralPlacement;

import com.jme3.math.Vector3f;
import com.jme3.terrain.geomipmap.TerrainGridListener;
import com.jme3.terrain.geomipmap.TerrainQuad;
import nl.jappieklooster.JME3.ProceduralPlacement.Placer.IPlacer;
import nl.jappieklooster.JME3.ProceduralPlacement.ShouldPlace.IShouldPlace;

/**
 * Quad populator populates a quad by scrolling trough the heightmap and asking
 * the placegaurd if it can place somthing. If so it commands spatialplacer to
 * place somthing.
 * @author jappie
 */
public class QuadPopulator implements TerrainGridListener {
    private IShouldPlace _placeGaurd;
    private IPlacer _spatialPlacer;
    
    /**
     * it is not very strange to have both interfaces be implemented in the same class
     * @param placer 
     */
    public QuadPopulator(IDecideAndPlace placer){
	this(placer, placer);
    }
    
    public QuadPopulator(IShouldPlace placeGaurd, IPlacer spatialPlacer){
	_placeGaurd = placeGaurd;
	_spatialPlacer = spatialPlacer;
    }
    
    @Override
    public void gridMoved(Vector3f newCenter) {
    }

    @Override
    public void tileAttached(Vector3f cell, TerrainQuad quad) {
	_placeGaurd.setTerainData(cell, quad);
	_spatialPlacer.setTerainData(cell, quad);
	
	float[] heightMap = quad.getHeightMap();
	
	int z = 0, x = 0, size = heightMap.length;
        
        _spatialPlacer.onStartPlacing();
	for(int i = 0; i < size; i++){
	    x++;
	    if(x >= quad.getTerrainSize()){
		z++;
		x = 0;
	    }
	    Vector3f where = new Vector3f(x, heightMap[i], z);
	    if(_placeGaurd.shouldPlace(where)){
		_spatialPlacer.place(where);
	    }
	}
	_spatialPlacer.onFinishedPlacing();
	
    }

    @Override
    public void tileDetached(Vector3f cell, TerrainQuad quad) {
	_spatialPlacer.setTerainData(cell, quad); // make sure to destroy all refrences
	_spatialPlacer.clear();
	_placeGaurd.setTerainData(null, null);
	
    }

}
