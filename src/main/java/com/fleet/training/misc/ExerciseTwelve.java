package com.fleet.training.misc;

import com.fleet.training.puzzle.BridgePuzzle;

public class ExerciseTwelve implements Runnable
{

    @Override
    public void run()
    {
        BridgePuzzle puzzle = new BridgePuzzle();
        puzzle.solve();
    }
}
