package nl.jappieklooster.JME3.ProceduralPlacement.Placer.Concrete;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.Iterator;

/**
 * lets you define a collection of templates to clone spatials from. ie
 * <code>List<Spatial> || Set<Spatial></code>
 *
 * @author jappie
 */
public class IteratorClone extends ClonePlace {

    private Iterator<Spatial> _iterator;
    private Iterable<Spatial> _iteratable;

    public IteratorClone(Iterable<Spatial> iterateable) {
        super(null);
        construct(iterateable);
    }

    public IteratorClone(Node root, Iterable<Spatial> iterateable) {
        super(root, null);
        construct(iterateable);
    }

    private void construct(Iterable<Spatial> iterateable) {
        _iteratable = iterateable;
        resetIterator();
        setWhat(next());
    }

    @Override
    protected Spatial place(Node on, Vector3f where) {
        setWhat(next());
        return super.place(on, where);
    }

    protected final Spatial next() {
        if (!_iterator.hasNext()) {
            resetIterator();
        }
        return _iterator.next();
    }

    protected final void resetIterator() {
        _iterator = _iteratable.iterator();
    }
}
