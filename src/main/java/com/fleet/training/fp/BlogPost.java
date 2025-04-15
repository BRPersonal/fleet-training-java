package com.fleet.training.fp;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BlogPost
{
    private String title;
    private String category;
    private LocalDate publishedDate;
}
