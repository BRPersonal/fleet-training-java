package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class EvaluationTest implements Runnable
{
    public void run()
    {
        /**
         * an array of strings  containing numbers
         * to filter the duplicates ignoring the number
         */
        List<String> words = new ArrayList<>(List.of("abc12", "abc34", "12abc", "def12", "1234"));
        Set<String> similarWords = new HashSet<>();
        int size = words.size();
        for (int i =0; i < size; i++)
        {
            for(int j = i + 1; j < size; j++ )
            {
                String firstWord = words.get(i);
                String secondWord = words.get(j);
                if (stripNumbers(firstWord).equals(stripNumbers(secondWord)))
                {
                    similarWords.add(firstWord);
                    similarWords.add(secondWord);
                }
            }
        }

        words.removeAll(similarWords);
        log.debug("words={}", words);

    }

    private static int compare(String s1,Object s2)
    {
        return stripNumbers(s1).compareTo(stripNumbers((String)s2));
    }

    private static String stripNumbers(String text)
    {
        if (isNumeric(text))
        {
            return text;
        }

        int length = text.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++)
        {
            char ch = text.charAt(i);
            if ( ch>= '0' && ch <= '9')
            {
                continue;
            }
            builder.append(ch);
        }

        return builder.toString();
    }

    private static boolean isNumeric(String text)
    {
        boolean result = true;
        try
        {
            Integer.parseInt(text);
        }
        catch(NumberFormatException ne)
        {
            result = false;
        }
        return result;
    }


}
