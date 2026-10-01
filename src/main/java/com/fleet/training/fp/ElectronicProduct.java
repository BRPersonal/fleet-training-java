package com.fleet.training.fp;

import java.math.BigDecimal;

public record ElectronicProduct(String name, String description, BigDecimal price) implements ProductV2
{
}
