# Cartesian Graph

`CartesianGraph` is an undirected and unweighted graph representation of a Cartesian coordinate system. 

## Using in your own project

Clone or download this repository and import it into your IDE of choice. You may then either add the project to your own project's build
path or export the project as a runnable .jar and add the .jar to your build path.

## Vertex

This class represents Cartesian coordinates `(x, y, z)`. If implementing a 2D coordinate system, set `z` to 0.  

## EdgeMap

This interface is implemented by classes that define which coordinates in a Cartesian coordinate system are adjacent. For example,
`Square2D` defines vertices that would be adjacent in a 2D square-based Cartesian grid (diagonal not considered adjacent) by storing 
the unit vectors:

```(1, 0, 0), (0, 1, 0), (-1, 0, 0), and (0, -1, 0)```

You may create your own definitions of adjacency by implementing `EdgeMap`. For example, to create a 3D cube-based Cartesian grid (diagonal
not considered adjacent), you would store the unit vectors:

```(1, 0, 0), (0, 1, 0), (-1, 0, 0), (0, -1, 0)```

```(1, 0, 1), (0, 1, 1), (-1, 0, 1), (0, -1, 1)```

```(1, 0, -1), (0, 1, -1), (-1, 0, -1), (0, -1, -1)```

## Authors

[doctortickle](https://github.com/doctortickle)

## Acknowledgments

* The `Graph` class is based on [imamhidayat92's](https://gist.github.com/imamhidayat92/dff60e5554020bd58b64) undirected and and unweighted
graph implementation.
