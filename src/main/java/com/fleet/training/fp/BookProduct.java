package com.fleet.training.fp;

import java.math.BigDecimal;

public record BookProduct(String name, String description, BigDecimal price) implements ProductV2
{
}
