package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class ExerciseTen implements Runnable
{
    @Override
    public void run()
    {
        List<String> languages = Arrays.asList("Java", "VisualJ++","Scala", "C++", "Haskell", "Lisp");

        log.debug("Languages which starts with J :");
        filter(languages, s -> s.startsWith("J"));

        log.debug("Languages which ends with a ");
        filter(languages, s -> s.endsWith("a"));

        log.debug("Print all languages :");
        filter(languages, s->true);

        log.debug("Print no language : ");
        filter(languages, s->false);

        log.debug("Print language whose length greater than 4:");
        filter(languages, s -> s.length() > 4);

        Predicate<String> containsJ = s -> s.contains("J");
        Predicate<String> fourLetterLong = s -> s.length() == 4;

        log.debug("Print languages which contains letter 'J' and  length equals 4:");
        filter(languages, containsJ.and(fourLetterLong));



    }

    private void filter(List<String> names, Predicate<String> condition)
    {
        names.parallelStream()
                .filter(condition)
                .forEach(name -> log.debug("language={}", name));

    }
}
