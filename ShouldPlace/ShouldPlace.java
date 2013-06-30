package nl.jappieklooster.JME3.ProceduralPlacement.ShouldPlace;

import nl.jappieklooster.JME3.ProceduralPlacement.TerrainDataAcces;

/**
 * Methods implemented by this class are optional, not every should place needs them.
 * @author jappie
 */
public abstract class ShouldPlace extends TerrainDataAcces implements IShouldPlace{

    public void onFinishedPlacing() {}

    public void onStartPlacing() {}
    
}
