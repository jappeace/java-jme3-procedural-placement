 java-jme3-procedural-placement
==============================

this library contains a framework for placing object procuderaly in a jme3 terraingrid.

Atach QuadPopulator to a terraingrid as a listener to start population of the quads.

To construct a quadPopulator you need an object that determins if there should be placed a spatial
and an object that places the spatial.
The interfaces IShouldPlace and IPlacer can be used to make youre own.
The packages ShouldPlace and Placer coontain some default implementations to make life easier.

The placers can be decorated with a moveToWhere functionality, And a rotate functionality. The move
to where uses the where parameter to move the spatials to that location. You probably want to
use this decoration.
