package com.fleet.training.generics;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rectangle extends AbstractShape
{
    public Rectangle(String id)
    {
        super(id);
    }

    @Override
    public void draw()
    {
        log.debug("drawing rectangle:{}",id);
    }
}
