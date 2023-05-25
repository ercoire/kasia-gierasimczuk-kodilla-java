package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.MovieStore;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        MovieStore movieStore = new MovieStore();


        System.out.println(movieStore.getMovies().values().stream()
                .flatMap(List::stream)
                .collect(Collectors.joining("! ")));

    }


}