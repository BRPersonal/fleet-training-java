package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class ExerciseSix  implements Runnable
{
    @Override
    public void run()
    {
        String allowedUrl = "/loanrequest/api/loan/request/{eprolendId}/{statusId}/submit";

        Scanner in = new Scanner(System.in);
        System.out.print("Enter url to match:");
        String actualUrl = in.nextLine();

        boolean result = doesUrlMatch(allowedUrl, actualUrl);
        log.debug("match Found:{}", result);

    }

    private boolean doesUrlMatch(String allowedUrl, String actualUrl)
    {
        //create a reg ex that replaces every placeholder {} with a regex pattern [^/]+
        //the regex pattern [^/]+ matches one or more characters that are not a forward slash
        //since characters { and } has special meaning in regex, they have to escaped to treat
        //them literally. So we need to prefix a \. But that becomes an invalid escape sequence
        //as per java. So we have to escape it again with a \ (backslash)
        String regex = allowedUrl.replaceAll("\\{[^/]+\\}", "[^/]+");

        // Add start and end anchors to ensure the entire URL is matched
        regex = "^" + regex + "$";
        log.debug("allowedUrl={}, regEx={}", allowedUrl, regex);

        // Use the regex to match the actualUrl
        return actualUrl.matches(regex);
    }
}
