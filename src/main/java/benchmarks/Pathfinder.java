package benchmarks;

import benchmarks.test.*;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;
import com.stewsters.util.pathing.threeDimention.pathfinder.AStarPathFinder3d;
import com.stewsters.util.pathing.threeDimention.shared.FullPath3d;
import com.stewsters.util.pathing.twoDimention.pathfinder.AStarPathFinder2d;
import com.stewsters.util.pathing.twoDimention.pathfinder.ChebyshevHeuristic2d;
import com.stewsters.util.pathing.twoDimention.shared.FullPath2d;


public class Pathfinder extends SimpleBenchmark {

    AStarPathFinder2d pathfinder2d;
    ExampleMover2d exampleMover2d;

    AStarPathFinder3d pathfinder3d;
    ExampleMover3d exampleMover3d;


    @Override
    protected void setUp() throws Exception {
        super.setUp();

        ExampleCellType floor = new ExampleCellType('.', false);
        ExampleCellType wall = new ExampleCellType('#', true);


        ExampleMap2d map2d = new ExampleMap2d(100, 100, floor, wall);
        pathfinder2d = new AStarPathFinder2d(map2d, 1000, false, new ChebyshevHeuristic2d());
        exampleMover2d = new ExampleMover2d(map2d);

        ExampleMap3d map3d = new ExampleMap3d(100, 100, 3, floor, wall);
        pathfinder3d = new AStarPathFinder3d(map3d, 1000, false);
        exampleMover3d = new ExampleMover3d(map3d);


    }


    //======== benchmarks ========//

    public void timePathing2d(int numReps) {


        for (int i = 0; i < numReps; i++) {
            FullPath2d fullPath2d = pathfinder2d.findPath(exampleMover2d, 1, 1, 98, 98);
            assert fullPath2d != null;
        }
    }


    public void timePathing3d(int numReps) {
        for (int i = 0; i < numReps; i++) {
            FullPath3d fullPath3d = pathfinder3d.findPath(exampleMover3d, 1, 1, 1, 98, 98, 1);
            assert fullPath3d != null;
        }
    }


    //======== main ========//
    public static void main(String[] args) {
        Runner.main(Pathfinder.class, args);
    }


}
