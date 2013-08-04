/*
 * visit <a href="jappieklooster.nl">jappieklooster.nl</a> for more information about this license.
 */

package nl.jappieklooster.JME3.ProceduralPlacement;

import com.jme3.scene.Node;
import com.jme3.terrain.geomipmap.TerrainGridListener;

/**
 *
 * @author jappie
 */
public interface IQuadPopulator extends TerrainGridListener {

    /**
     * @return the _placement
     */
    Node getPlacings();

}
