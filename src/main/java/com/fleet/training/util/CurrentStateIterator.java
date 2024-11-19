package com.fleet.training.util;

import java.util.Iterator;

public interface CurrentStateIterator<T> extends Iterator<T>
{
    T current();
}
