package com.fleet.training.generics;

import java.util.ArrayList;
import java.util.List;

public class ExerciseFive implements Runnable
{
    @Override
    public void run()
    {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle("r1"));

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle("c1"));
        circles.add(new Circle("c2"));

        drawShapes(rectangles);
        drawShapes(circles);

    }

    private void drawShapes(List<? extends Shape> figures)
    {
        figures.stream().forEach(s -> s.draw());
    }
}
