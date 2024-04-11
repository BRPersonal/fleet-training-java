package com.fleet.training.optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * Demonstrates the difference between orElse() and orElseGet().
 * orElseGet() is lazy - i.e, will be executed only if Optional is empty
 * orElse() will be executed irrespective of Optional is empty or not
 */

@Slf4j
public class ExerciseFour implements Runnable
{
    @Override
    public void run()
    {
        log.debug("Using Optional in correct way...");
        findInventoryByProductId(1).orElseGet(() -> createInventory(1));
        findInventoryByProductId(2).orElseGet(() -> createInventory(2));

        log.debug("Using Optional in wrong way...");
        findInventoryByProductId(1).orElse(createInventory(1));
        findInventoryByProductId(2).orElse(createInventory(2));


    }

    private Optional<Inventory> findInventoryByProductId(int productId)
    {
        log.debug("Checking Inventory for product Id {}", productId);
        return (productId  == 1) ? Optional.of(new Inventory(10)) : Optional.empty();
    }

    private Inventory createInventory(int productId)
    {
        log.debug("Creating Inventory for productId {}", productId);
        return new Inventory(5);
    }

    @RequiredArgsConstructor
    private class Inventory
    {
        private final int quantity;
    }
}
