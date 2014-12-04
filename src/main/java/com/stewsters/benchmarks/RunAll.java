package com.stewsters.benchmarks;

import com.google.caliper.Runner;


public class RunAll {
    //======== main ========//
    public static void main(String[] args) {
//        Runner.main(Pathfinder.class, args);
        Runner.main(Searcher.class, args);
    }

}
