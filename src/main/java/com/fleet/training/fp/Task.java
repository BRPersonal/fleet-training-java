package com.fleet.training.fp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Task
{
    private final String assignedTo;
    private final String date;
    private final String description;
    private final int hours;

}
