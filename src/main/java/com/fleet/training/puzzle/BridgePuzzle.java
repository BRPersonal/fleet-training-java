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
        solve(new ArrayList<>(persons), new ArrayList<>(),new ArrayList<>(),1,0);
    }

    private void solve(List<String> sourceList, List<String> destinationList
            ,List<String> solutionSteps, int step, int timeSpent)
    {
        switch(step)
        {
            case 1,3:

                List<String> combinations = getCombinations(sourceList);

                for(Iterator<String> iter = combinations.iterator(); iter.hasNext();)
                {
                    String person1 = iter.next();
                    String person2 = iter.next();

                    moveToDestination(person1,person2,sourceList,destinationList);
                    solutionSteps.add(String.format("%s,%s move to destination",person1,person2));
                    timeSpent += timeTaken(person1,person2);

                    solve(new ArrayList<>(sourceList),new ArrayList<>(destinationList)
                            ,new ArrayList<>(solutionSteps),step + 1,timeSpent);

                    //restore previous state
                    moveToDestination(person1,person2,destinationList,sourceList);
                    solutionSteps.removeLast();
                    timeSpent -= timeTaken(person1,person2);

                }
                break;

            case 2,4:

                List<String> copy = new ArrayList<>(destinationList);
                for (String person : copy)
                {
                    moveToSource(person, sourceList,destinationList);
                    solutionSteps.add(String.format("%s move back to source",person));
                    timeSpent += timeTaken(person);

                    solve(new ArrayList<>(sourceList),new ArrayList<>(destinationList)
                            ,new ArrayList<>(solutionSteps),step + 1,timeSpent);

                    //restore previous state
                    moveToSource(person, destinationList,sourceList);
                    solutionSteps.removeLast();
                    timeSpent -= timeTaken(person);
                }
                break;

            case 5:

                String person1 = sourceList.get(0);
                String person2 = sourceList.get(1);
                moveToDestination(person1,person2,sourceList,destinationList);
                solutionSteps.add(String.format("%s,%s move to destination",person1,person2));
                timeSpent += timeTaken(person1,person2);

                if(timeSpent <= timeAvailable)
                {
                    System.out.println("Success.Solution arrived.timeSpent=" + timeSpent);
                    solutionSteps.forEach(System.out::println);
                }
                else
                {
                    System.out.println("Failure.Solution not arrived.timeSpent=" + timeSpent);
                    solutionSteps.forEach(System.out::println);
                }

                System.out.println("----------End of Trial");

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
            , List<String> destinationList)
    {

        sourceList.remove(person1);
        sourceList.remove(person2);
        destinationList.add(person1);
        destinationList.add(person2);
    }

    private void moveToSource(String person,List<String> sourceList
            , List<String> destinationList)
    {
        sourceList.add(person);
        destinationList.remove(person);
    }

}
