package com.fleet.training.fp;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface TriFunction<Arg1,Arg2,Arg3,R>
{
    R apply(Arg1 arg1, Arg2 arg2, Arg3 arg3);
    default <K> TriFunction<Arg1, Arg2, Arg3, K> andThen(Function<? super R, ? extends K> f)
    {
        Objects.requireNonNull(f);
        return (Arg1 a, Arg2 b, Arg3 c) -> f.apply(apply(a, b, c));  //essentially we are doing f.apply(R) that returns a K
    }
}
