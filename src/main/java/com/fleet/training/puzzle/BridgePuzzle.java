package com.fleet.training.puzzle;

import java.util.*;

/**
 * Four people A,B,C,D has to cross a bridge that will collapse in
 * 15 minutes.
 *
 * A can cross the bridge in 1 minute
 * B can cross the bridge in 2 minutes
 * C can cross the bridge in 5 minutes
 * D can cross the bridge in 8 minutes
 *
 * It is pitch dark at night, and you need a torch to cross the bridge
 * There is only one torch
 * Max. two people can cross the bridge at a time.
 *
 */
public class BridgePuzzle
{
    private final List<String> persons;
    private final Map<String,Integer> timingMap;
    private final int timeAvailable;

    public BridgePuzzle()
    {
        persons = List.of("A","B","C","D");
        timingMap = Map.of(persons.get(0),1,persons.get(1),2,persons.get(2),5,persons.get(3),8);
        timeAvailable = 15;
    }

    public void solve()
    {
        move(new ArrayList<>(persons), new ArrayList<>(),1,0,new StringBuffer());
    }

    private void move(List<String> sourceList, List<String> destinationList
            , int step,int timeSpent, StringBuffer solutionSteps)
    {
        switch(step)
        {
            case 1,3:

                List<String> combinations = getCombinations(sourceList);
                for(Iterator<String> iter = combinations.iterator(); iter.hasNext();)
                {
                    String person1 = iter.next();
                    String person2 = iter.next();
                    moveToDestination(person1,person2,sourceList,destinationList,solutionSteps);
                    timeSpent += timeTaken(person1,person2);
                    move(sourceList,destinationList,step + 1,timeSpent,solutionSteps);
                }
                break;

            case 2,4:

                for (String person : new ArrayList<>(destinationList))
                {
                    moveToSource(person, sourceList,destinationList,solutionSteps);
                    timeSpent += timeTaken(person);
                    move(sourceList,destinationList,step + 1,timeSpent,solutionSteps);
                }
                break;

            case 5:

                System.out.println(String.format("at step 5 sourceList=%s",sourceList));

                String person1 = sourceList.get(0);
                String person2 = sourceList.get(1);
                moveToDestination(person1,person2,sourceList,destinationList,solutionSteps);

                timeSpent += timeTaken(person1,person2);

                if(timeSpent <= timeAvailable)
                {
                    System.out.println("timeSpent=" + timeSpent);
                    System.out.println(solutionSteps);
                    System.exit(0);
                }
                else
                {
                    System.out.println("Iteration Failed");
                }

                break;
        }
    }

    private List<String> getCombinations(List<String> choices)
    {

        List<String> combinations = new ArrayList<>();  //4c2 -> 6 pairs
        int length = choices.size();
        for(int i = 0; i < length; i++)
        {
            for(int j = i + 1; j < length; j++)
            {
                combinations.add(choices.get(i));
                combinations.add(choices.get(j));
            }
        }
        return combinations;
    }

    private int timeTaken(String person1,String person2)
    {
        //return max timing
        int t1 = timeTaken(person1);
        int t2 = timeTaken(person2);
        return Math.max(t1, t2);
    }

    private int timeTaken(String person)
    {
        return timingMap.get(person);
    }

    private void moveToDestination(String person1,String person2, List<String> sourceList
            , List<String> destinationList,StringBuffer solutionSteps)
    {
        solutionSteps.append(String.format("%s,%s move to destination %s",person1,person2,System.lineSeparator()));
        sourceList.remove(person1);
        sourceList.remove(person2);
        destinationList.add(person1);
        destinationList.add(person2);
    }

    private void moveToSource(String person1,List<String> sourceList
            , List<String> destinationList,StringBuffer solutionSteps )
    {
        solutionSteps.append(String.format("%s move back to source %s",person1,System.lineSeparator()));
        sourceList.add(person1);
        destinationList.remove(person1);
    }

}
