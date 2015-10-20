package com.udacity.gradle.jokes;

import java.util.Random;

public class Joker {
    public String getJoke(){
        String[] jokes = {
                "What did the bird say after his cage fell apart?\n- Cheap, cheap!",
                "Why did the blonde become a big basketball fan?\n- Because every time they stopped the clock, she thought that she had stopped aging.",
                "Why did the chicken cross the basketball court?\n- He heard the ref was blowing fowls.",
                "What did one computer say to the other?\n- 010101101010101010101"
        };

        int min = 0;
        int max = jokes.length-1;
        Random random = new Random();

        return jokes[random.nextInt(max - min + 1) + min];
    }
}
