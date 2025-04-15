package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class ExerciseTwentyFive implements Runnable
{
    @Override
    public void run()
    {
        List<BlogPost> posts = createBlogPosts();
        Map<String,List<BlogPost>> result = getMostRecentPostsByCategory(posts,3);
        result.entrySet().forEach(entry -> log.debug("{}",entry));
    }

    private List<BlogPost> createBlogPosts()
    {
        // Create sample blog posts
        List<BlogPost> posts = new ArrayList<>();

        // Technology category
        posts.add(new BlogPost("Java 21 Features", "Technology", LocalDate.of(2023, 9, 15)));
        posts.add(new BlogPost("Introduction to Spring Boot", "Technology", LocalDate.of(2023, 8, 20)));
        posts.add(new BlogPost("Microservices Architecture", "Technology", LocalDate.of(2023, 7, 10)));
        posts.add(new BlogPost("Docker for Beginners", "Technology", LocalDate.of(2023, 6, 5)));
        posts.add(new BlogPost("Web Development Trends", "Technology", LocalDate.of(2023, 5, 25)));

        // Travel category
        posts.add(new BlogPost("Exploring Japan", "Travel", LocalDate.of(2023, 9, 10)));
        posts.add(new BlogPost("European Destinations", "Travel", LocalDate.of(2023, 8, 15)));
        posts.add(new BlogPost("Backpacking Tips", "Travel", LocalDate.of(2023, 7, 20)));
        posts.add(new BlogPost("Beach Vacations", "Travel", LocalDate.of(2023, 6, 1)));

        // Food category
        posts.add(new BlogPost("Italian Cuisine", "Food", LocalDate.of(2023, 9, 5)));
        posts.add(new BlogPost("Vegetarian Recipes", "Food", LocalDate.of(2023, 8, 25)));
        posts.add(new BlogPost("Baking Bread", "Food", LocalDate.of(2023, 7, 15)));

        // Finance category
        posts.add(new BlogPost("Investment Strategies", "Finance", LocalDate.of(2023, 9, 18)));
        posts.add(new BlogPost("Retirement Planning", "Finance", LocalDate.of(2023, 8, 12)));

        return posts;
    }

    private Map<String, List<BlogPost>> getMostRecentPostsByCategory(List<BlogPost> posts,int mostRecentCount)
    {
        //group by category. within each category, sort the list of posts by
        //publishedDate and reverse and limit to count and get a list
        return posts.stream()
                .collect(
                        Collectors.groupingBy(BlogPost::getCategory,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        categoryPosts -> categoryPosts.stream()
                                                .sorted(Comparator.comparing(BlogPost::getPublishedDate).reversed())
                                                .limit(mostRecentCount)
                                                .toList()
                                )
                        )
                );
    }
}
