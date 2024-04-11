package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * This is coding exercise to trainees
 *
 * Here is a sample Task csv file . For simplicity, assume date is just a string
 * and all data is valid
 *
 * AssignedTo,Date,Task,Hours
 * Balaji,02/Feb/24,Training,2
 * Sneha,02/Feb/24,Attend Training,2
 * Sneha,02/Feb/24,Project Work,1
 * Balaji,01/Feb/24,Training,2
 * Balaji,01/Feb/24,Preparing Training Material,2
 *
 * The program should take two inputs from user
 * 1. file path
 * 2. Has Header? (Y/N)
 *
 * If the file has header, you have to skip the first row
 * The output report should be like this
 *
 * name=Sneha,date=02/Feb/24,totalHours=3
 * name=Balaji,date=01/Feb/24,totalHours=4
 * name=Balaji,date=02/Feb/24,totalHours=2
 *
 * Note on parallel stream
 * -----------------------
 * It should be used only if the data volume is high
 * Very important point is  ordering of data should not matter.
 * ordering should not affect the end result. If this is not the case
 * then you should use sequential streaming only
 *
 */
@Slf4j
public class ExerciseTwenty implements Runnable
{

    @Override
    public void run()
    {
        System.out.print("Enter file path:");
        Scanner in = new Scanner(System.in);
        String filePath = in.nextLine();
        System.out.println("Has header(y/n)?");
        String reply = in.nextLine();

        try
        {
            try (Stream<String> lines = Files.newBufferedReader(Paths.get(filePath)).lines().parallel())
            {
                boolean hasHeader = "Y".equalsIgnoreCase(reply);

                log.debug("Is stream running in parallel? {}", lines.isParallel() ? "YES" : "NO");

                //Hint: if you can't determine type of lhs, just use var and IDE will show the type
                Map<String,Map<String,Integer>> taskGroup = lines
                        .skip(hasHeader ? 1 : 0)
                        .map(this::createTask)
                        .collect(groupingBy(Task::getAssignedTo
                                        ,groupingBy(Task::getDate, summingInt(t -> t.getHours()))
                                )
                        );

                log.debug("grouping={}", taskGroup);

                for (Map.Entry<String,Map<String,Integer>> nameWise : taskGroup.entrySet())
                {
                    String name = nameWise.getKey();
                    for(Map.Entry<String,Integer> dateWise : nameWise.getValue().entrySet())
                    {
                        String date = dateWise.getKey();
                        Integer totalHours  = dateWise.getValue();
                        log.debug("name={},date={},totalHours={}", name,date,totalHours);
                    }
                }

            }

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

    private Task createTask(String line)
    {
        //assuming only valid data for this exercise
        String[] data = line.split(",");
        return new Task(data[0], data[1], data[2],Integer.parseInt(data[3]));
    }
}
