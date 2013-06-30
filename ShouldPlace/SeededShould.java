/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.ShouldPlace;

import com.jme3.math.Vector3f;
import nl.jappieklooster.JME3.ProceduralPlacement.TerrainDataAcces;
import nl.jappieklooster.vikingr.Engine.Log;

/**
 *
 * @author jappie
 */
public class SeededShould extends ShouldPlace implements IShouldPlace{
    private String _seed;
    
    private static final int  RESET_VALUE = 0,  
            SKIP_THRESHOLD = 4;
    private static final double INCREMENT_STEPS = Double.MAX_VALUE/13;
    private static final float PER = 1500;
    private int _placeCycle = RESET_VALUE, _places = RESET_VALUE, _skipped = RESET_VALUE;
    public SeededShould(String seed){
        _seed = seed;
    }
    public boolean shouldPlace(Vector3f where) {
        if(_placeCycle < PER){
            _placeCycle++;
            return false;
        }
        _placeCycle = RESET_VALUE;
        _places++;
        return determinPlacement(where);
    }
    
    private boolean determinPlacement(Vector3f where){
        if(_places % SKIP_THRESHOLD == 0){
            // first one gets skipped, then 1 2th then 1 2 3th etc
            _skipped++;
            return false;
        }
        double smaller = 0, bigger = 0, seed = becomePositive(_seed.hashCode());
        Log.debug("seed val: + {0}, max int: {1}", seed, Integer.MAX_VALUE);
        // the increment steps are quite big, but this code has to run fast. One go is probably enough
        for(double compare = RESET_VALUE; compare < seed; compare += INCREMENT_STEPS){
            
            smaller += _skipped*getCell().hashCode()*where.hashCode()* _places * getCell().x*where.hashCode()*where.hashCode();
            bigger += (seed * where.x * getCell().z* getCell().z  + seed +
                    where.y * where.z - 
                    getCell().y );
        }
        return smaller < bigger;
    }
    /**
     * if a number is negative it gets multiplied by 13 until overflow oceurs making it very positive
     * @param input
     * @return a positive value
     */
    private double becomePositive(double input){
        return (input < 0)? becomePositive(input* input) : input;
    }
    @Override
    public void onFinishedPlacing() {
        _skipped = RESET_VALUE;
        _placeCycle = RESET_VALUE;
        _places = RESET_VALUE;
    }
}
