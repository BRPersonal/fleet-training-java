package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExerciseSixteen implements Runnable
{

    @Override
    public void run()
    {
        User user1 = User.builder()
                .username("Krishna")
                .email("radhe@gmail.com")
                .active(true)
                .build();

        User user2 = User.builder()
                .username("Krishna")
                .email("radhe@gmail.com")
                .active(false)
                .build();

        log.debug("user1={}", user1);
        log.debug("user1.hashcode={}", user1.hashCode());

        log.debug("user2={}", user2);
        log.debug("user2.hashcode={}", user2.hashCode());

        log.debug("user1 == user2 : {}",user1.equals(user2));

    }
}
