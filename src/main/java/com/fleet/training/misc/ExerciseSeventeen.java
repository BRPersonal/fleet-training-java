package com.fleet.training.misc;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Slf4j
public class ExerciseSeventeen implements Runnable
{
    @Override
    public void run()
    {
        List<Employee> employees = List.of(
                new Employee("krishna", "maintenance"),
                new Employee("Radha", "maintenance"),
                new Employee("brahma", "manufacturing"),
                new Employee("saraswathi", "manufacturing"),
                new Employee("shiva", "trash"),
                new Employee("parvathi", "trash")
        );

        Map<String, List<Employee>> grouped =
                new HashMap<>();

        for (Employee employee : employees) {
            grouped.computeIfAbsent(employee.department(),
                    k -> new ArrayList<Employee>())
                    .add(employee);
        }
        log.info("Grouped Employees: {}", grouped);
    }

}
