package com.fleet.training;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Scanner;

@Slf4j
public class Main
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            Arrays.stream(args).forEach(arg -> log.debug("arg:{}", arg));
            String[] packages = {"fp.","generics.","optional.","concurrent.","misc."};

            Scanner in = new Scanner(System.in);
            System.out.print("Enter package (1 - fp 2 - generics 3 - optional 4 - concurrent 5 - misc):");
            int packageIndex = in.nextInt();
            in.nextLine();  //consume a carriage return

            System.out.print("Enter class Name:");
            String className = in.nextLine();

            //prefix package
            className = "com.fleet.training." + packages[packageIndex - 1] + className;

            log.debug("Executing class={}", className);
            Class c = Class.forName(className);
            Runnable r = (Runnable)c.getConstructor().newInstance();
            r.run();

            log.debug("All is Well");
        }
        catch(Exception ex)
        {
            log.error("Exception Occured:", ex);
            throw ex;
        }

    }
}
