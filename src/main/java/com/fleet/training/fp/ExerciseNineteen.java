package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.*;

@Slf4j
public class ExerciseNineteen implements Runnable
{
    @Override
    public void run()
    {
        final List<Person> people = Arrays.asList(
                new Person("John",20),
                new Person("Greg",35),
                new Person("Jane",21),
                new Person("Sara",35));

        Comparator<Person> compareByAgeAscending = Person::getAgeDifference;
        Comparator<Person> compareByAgeDescending = compareByAgeAscending.reversed();

        //sort by descending order of age
        List<Person> descendingAgeList = people.stream()
                .sorted(compareByAgeDescending)
                .collect(toList());
        log.debug("descending order of age list={}", descendingAgeList);

        //sort by ascending order of age and descending order of name
        Comparator<Person> compareByNameDescending = Comparator.comparing(Person::getName).reversed();
        List<Person> multiSortList = people.stream()
                .sorted(compareByAgeAscending.thenComparing(compareByNameDescending))
                .collect(toList());
        log.debug("ascending order of age and descending order of name list={}", multiSortList);

        //Create grouping by age
        Map<Integer,List<Person>> peopleByAge =
                people.stream()
                .collect(groupingBy(Person::getAge));
        log.debug("People grouped by age={}", peopleByAge);

        //Get pnly people's names grouped by age
        Map<Integer, List<String>> nameOfPeopleByAge =
                people.stream()
                        .collect(groupingBy(Person::getAge
                                    ,mapping(Person::getName,toList())
                                )
                        );
        log.debug("Names of people grouped by age={}", nameOfPeopleByAge);

        //Group by First character of the name, and find the oldest person in each group
        //group by the first character of the name and reduce to the person with the maximum age

        Map<Character, Optional<Person>> oldestPersonOfEachLetter =
                people.stream()
                        .collect(groupingBy(
                                        (Person p) -> p.getName().charAt(0)
                                        ,reducing(BinaryOperator.maxBy(compareByAgeAscending))
                                 )
                        );
        log.debug("Oldest person in each letter={}", oldestPersonOfEachLetter);


    }
}
