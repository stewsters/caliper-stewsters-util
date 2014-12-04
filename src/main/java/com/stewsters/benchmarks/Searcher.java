package com.stewsters.benchmarks;


import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;
import com.stewsters.examples.*;
import com.stewsters.util.pathing.threeDimention.searcher.DjikstraSearcher3d;
import com.stewsters.util.pathing.threeDimention.searcher.Objective3d;
import com.stewsters.util.pathing.threeDimention.shared.FullPath3d;
import com.stewsters.util.pathing.threeDimention.shared.PathNode3d;
import com.stewsters.util.pathing.twoDimention.searcher.DjikstraSearcher2d;
import com.stewsters.util.pathing.twoDimention.searcher.Objective2d;
import com.stewsters.util.pathing.twoDimention.shared.FullPath2d;
import com.stewsters.util.pathing.twoDimention.shared.PathNode2d;


public class Searcher extends SimpleBenchmark {

    DjikstraSearcher2d searcher2d;
    ExampleMover2d exampleMover2d;
    Objective2d objective2d;

    DjikstraSearcher3d searcher3d;
    ExampleMover3d exampleMover3d;
    Objective3d objective3d;


    @Override
    protected void setUp() throws Exception {
        super.setUp();

        ExampleCellType floor = new ExampleCellType('.', false);
        ExampleCellType wall = new ExampleCellType('#', true);


        ExampleMap2d map2d = new ExampleMap2d(100, 100, floor, wall);
        searcher2d = new DjikstraSearcher2d(map2d, 1000, false);
        exampleMover2d = new ExampleMover2d(map2d);
        objective2d = new Objective2d() {
            @Override
            public boolean satisfiedBy(PathNode2d current) {
                return (current.x == 98 && current.y == 98);
            }
        };


        ExampleMap3d map3d = new ExampleMap3d(100, 100, 3, floor, wall);
        searcher3d = new DjikstraSearcher3d(map3d, 1000, false);
        exampleMover3d = new ExampleMover3d(map3d);
        objective3d = new Objective3d() {
            @Override
            public boolean satisfiedBy(PathNode3d current) {
                return (current.x == 98 && current.y == 98 && current.z == 1);
            }
        };


    }


    //======== benchmarks ========//

    public void timeSearching2d(int numReps) {


        for (int i = 0; i < numReps; i++) {
            FullPath2d fullPath2d = searcher2d.search(exampleMover2d, 1, 1, objective2d);
            assert fullPath2d != null;
        }
    }


    public void timeSearching3d(int numReps) {
        for (int i = 0; i < numReps; i++) {
            FullPath3d fullPath3d = searcher3d.search(exampleMover3d, 1, 1, 1, objective3d);
            assert fullPath3d != null;
        }
    }

}
