package com.fleet.training.misc;

import java.nio.charset.Charset;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExerciseFive implements Runnable
{
    @Override
    public void run()
    {
        //create a bloom filter instance. Expected 10,000 insertions
        //with a false positive probability of 0.005
        BloomFilter<CharSequence> blackListedIps = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8"))
                , 10000, 0.005);

        //feed some data to bloom filter
        blackListedIps.put("192.170.0.1");
        blackListedIps.put("75.245.10.1");
        blackListedIps.put("10.125.22.20");

        // Test the bloom filter
        System.out.println(
                blackListedIps
                        .mightContain(
                                "75.245.10.1"));
        System.out.println(
                blackListedIps
                        .mightContain(
                                "101.125.20.22"));
    }
}
