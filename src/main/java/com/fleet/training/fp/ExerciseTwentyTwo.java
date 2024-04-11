package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ExerciseTwentyTwo implements Runnable
{
    @Override
    public void run()
    {
        List<Student> students = List.of(
                new Student("Bob", 18),
                new Student("Ted", 17),
                new Student("Zeka", 19),
                new Student("Krishna",20),
                new Student("Rama",25));

        int topN = 3;
        List<Student> result = getTopNOldestStudents(students,topN);

        log.debug("Top {} oldest students={}", topN,result);
        findMaxAge(students);
        findMinAge(students);
    }

    //Get top N oldest students whose age is greater than 18
    private List<Student> getTopNOldestStudents(List<Student> students,int topN)
    {
        return students.stream()
                .filter(s -> s.getAge() > 18)
                .sorted((s1,s2) -> s2.getAge() - s1.getAge())
                .limit(topN)
                .collect(Collectors.toList());
    }

    //

    /**
     * find max age.
     * There are 3 ways of building a comparator in this example
     * 1. Comparator.naturalOrder()
     * 2. (s1,s2) -> s1.compareTo(s2)
     * 3. Comparator.comparing(t -> t)
     *
     */
    private void findMaxAge(List<Student> students)
    {
        students.stream()
                .map(Student::getAge)
                .max(Comparator.comparing(t -> t))
                .ifPresent(a -> log.debug("max Age={}", a));
    }

    //Note: max(Comparator.reverseOrder()) will also work but it does not look good
    //Please Dont do that.  Be a responsbile sensisble programmer.
    private void findMinAge(List<Student> students)
    {
        students.stream()
                .map(Student::getAge)
                .min(Comparator.naturalOrder())
                .ifPresent(a -> log.debug("min Age={}", a));
    }
}
