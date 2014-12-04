package com.stewsters.examples;

import com.stewsters.util.pathing.threeDimention.shared.Mover3d;
import com.stewsters.util.pathing.threeDimention.shared.PathNode3d;
import com.stewsters.util.pathing.threeDimention.shared.TileBasedMap3d;

/**
 *
 */
public class ExampleMap3d implements TileBasedMap3d {

    private final int width;
    private final int height;
    private final int depth;
    private ExampleCellType[][][] ground;

    public ExampleMap3d(int width, int height, int depth, ExampleCellType floor, ExampleCellType wall) {
        this.width = width;
        this.height = height;
        this.depth = depth;

        ground = new ExampleCellType[width][height][depth];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = 0; z < depth; z++) {
                    if (x == 0 || x >= width - 1 || y == 0 || y >= width - 1 || z == 0 || (z >= depth - 1)) {
                        ground[x][y][z] = wall;
                    } else {
                        ground[x][y][z] = floor;
                    }
                }
            }
        }

        //set up some walls

    }

    @Override
    public int getWidthInTiles() {
        return width;
    }

    @Override
    public int getHeightInTiles() {
        return height;
    }

    @Override
    public int getDepthInTiles() {
        return depth;
    }

    @Override
    public void pathFinderVisited(int x, int y, int z) {

    }

    @Override
    public boolean isBlocked(Mover3d mover, PathNode3d pathNode) {
        return ground[pathNode.x][pathNode.y][pathNode.z].blocks;
    }

    @Override
    public boolean isBlocked(Mover3d mover, int x, int y, int z) {
        return ground[x][y][z].blocks;
    }

    @Override
    public float getCost(Mover3d mover, int sx, int sy, int sz, int tx, int ty, int tz) {
        return 1;
    }

}
