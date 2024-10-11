package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class ExerciseTwentyThree implements Runnable
{
    @Override
    public void run()
    {
        List<Product> products = List.of(
                new Product(ProductType.ELECTRONICS, 1500),
                new Product(ProductType.CLOTHING, 500),
                new Product(ProductType.GROCERY, 200),
                new Product(ProductType.ELECTRONICS, 1200)
        );

//        log.debug("Total price of all products:{}",
//                totalProductPrices(products));

        log.debug("Total price of all products:{}",
                totalProductPrices(products,product -> true));

        log.debug("Total price of electronics products:{}",
                totalProductPrices(products,product -> product.getType() == ProductType.ELECTRONICS));

        log.debug("Total price of groceries products:{}",
                totalProductPrices(products,product -> product.getType() == ProductType.GROCERY));

    }

    private double totalProductPrices(List<Product> products)
    {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    //Now what if I want to total only electronics or grocery
    //items. DO I have to create separate methods.
    //Answer is No. There are two solutions to this problem
    //one is implementing Strategy design pattern in a conventional way
    //create an interface for strategy and concrete classes for implementing it
    //Inject strategy interface to a context object and change implementations at
    //runtime.
    //second approach is to implement strategy using lambdas - elegant solution
    //that avoids creating many classes and interface

    private double totalProductPrices(List<Product> products, Predicate<Product> productFilter)
    {
        //how to loop thru and how to do summation remains the same
        //only what to total is different, which is what we have abstracted into a lambda
        return products.stream()
                .filter(productFilter)
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
