package com.fleet.training.fp;

import java.math.BigDecimal;

public record FashionProduct(String name, String description, BigDecimal price) implements ProductV2
{
}
