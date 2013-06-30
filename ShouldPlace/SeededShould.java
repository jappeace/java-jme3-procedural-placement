/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.ShouldPlace;

import com.jme3.math.Vector3f;
import nl.jappieklooster.JME3.ProceduralPlacement.TerrainDataAcces;

/**
 *
 * @author jappie
 */
public class SeededShould extends ShouldPlace implements IShouldPlace{
    private String _seed;
    private static final int  RESET_VALUE = 0;
    private static final float PER = 1500;
    private int _placeCycle = RESET_VALUE, places = RESET_VALUE;
    public SeededShould(String seed){
        _seed = seed;
    }
    public boolean shouldPlace(Vector3f where) {
        if(_placeCycle < PER){
            _placeCycle++;
            return false;
        }
        _placeCycle = RESET_VALUE;
        places++;
        boolean result = determinPlacement(where);
        return result;
    }
    
    private boolean determinPlacement(Vector3f where){
        return getCell().hashCode()*where.hashCode()* places < (_seed.hashCode() * where.x  + where.y * where.z );
    }
    @Override
    public void onFinishedPlacing() {
        _placeCycle = RESET_VALUE;
        places = RESET_VALUE;
    }
}
