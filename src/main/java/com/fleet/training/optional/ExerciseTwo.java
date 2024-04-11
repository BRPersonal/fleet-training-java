package com.fleet.training.optional;

import com.fleet.training.util.Assert;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ExerciseTwo implements Runnable
{
    @Override
    public void run()
    {
        Modem[] marr = {new Modem(10.0),new Modem(9.9),new Modem(null),new Modem(15.5),null};
        Stream<Modem> ms1 = Stream.of(marr);
        Stream<Modem> ms2 = Stream.of(marr);

        List<Boolean> resultOne = ms1.map(this::priceIsInRange1).collect(Collectors.toList());
        List<Boolean> resultTwo = ms2.map(this::priceIsInRange2).collect(Collectors.toList());

        log.debug("resultOne={}", resultOne);
        log.debug("resultTwo={}", resultTwo);
        Assert.assertTrue(resultOne.equals(resultTwo));


    }

    //Imperative code
    private boolean priceIsInRange1(Modem modem)
    {
        boolean isInRange = false;
        if (modem != null && modem.getPrice() != null
                && (modem.getPrice() >= 10
                && modem.getPrice() <= 15))
        {

            isInRange = true;
        }

        return isInRange;
    }

    //Declarative code Using Optional
    private boolean priceIsInRange2(Modem modem)
    {
        return Optional.ofNullable(modem)
                .map(Modem::getPrice)
                .filter(p -> p >= 10)
                .filter(p -> p<= 15)
                .isPresent();
    }
}
