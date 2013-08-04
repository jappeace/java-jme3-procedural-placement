/*
 * visit <a href="jappieklooster.nl">jappieklooster.nl</a> for more information about this license.
 */
package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.terrain.geomipmap.TerrainQuad;
import nl.jappieklooster.JME3.ProceduralPlacement.IQuadPopulator;
import nl.jappieklooster.JME3.ProceduralPlacement.Utility;

/**
 * Manualy calls the tile atached on the quadpopulater, then gets the placement wich contains a on
 * the on then gets atached the this place's on.
 *
 * It calls manualy the quad populator be creating a new quad by making up a heightmap based on its
 * own quad and the where parameter.
 *
 * @author jappie
 */
public class GroupPlace extends Place {

    private int _size,
            _patchSize;
    private IQuadPopulator _populator;

    public GroupPlace(IQuadPopulator quadPopulator, int patchSize, int size) {
        construct(quadPopulator, size, patchSize);
    }

    public GroupPlace(Node root, IQuadPopulator quadPopulator, int patchSize, int size) {
        super(root);
        construct(quadPopulator, size, patchSize);
    }

    private void construct(IQuadPopulator quadPopulator, int patchSize, int size) {
        _size = size;
        _patchSize = patchSize;
        _populator = quadPopulator;
    }

    @Override
    protected Spatial place(Node on, Vector3f where) {
        // sumon heightmap
        float[] heightMap = new float[_size * _size];
        float x = where.x - _size / 2;
        float z = where.z - _size / 2;
        for (int i = 0; i < _size; i++) {
            x++;
            if (x >= _size) {
                z++;
                x = 0;
            }
            heightMap[i] = getQuad().getHeightmapHeight(new Vector2f(x, z));
        }
        TerrainQuad quad = new TerrainQuad(Utility.getRandomString(), _patchSize, _size, heightMap);

        // pretend a tile is atached
        _populator.tileAttached(getCell(), quad);

        // return the node where the stuff is placed on
        return _populator.getPlacings();
    }
}
