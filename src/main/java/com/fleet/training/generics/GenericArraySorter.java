package com.fleet.training.generics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericArraySorter
{
    public static <E extends Comparable<E>> void sort(E[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j].compareTo(array[j + 1]) > 0)
                {
                    swap(j, j + 1, array);
                }
            }
        }

        StringBuffer buf = new StringBuffer();
        for (E elem : array)
        {
            buf.append(elem).append(", ");
        }

        String arrayElementClassName = (    array.length > 0
                                            ? array[0].getClass().getName().replace("java.lang.","")
                                            : array.getClass().getTypeName().replace("java.lang.","").replace("[]","")
                                       );
        log.debug("Sorted {} array: {}",arrayElementClassName , buf);

    }

    private static <E> void swap(int i, int j, E[] a)
    {
        E temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
