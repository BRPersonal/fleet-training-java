package com.fleet.training.generics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Circle extends AbstractShape
{
    public Circle(String id)
    {
        super(id);
    }

    @Override
    public void draw()
    {
        log.debug("drawing circle:{}", id);
    }
}
