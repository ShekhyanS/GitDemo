package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExpressionDemo {
    @Test
    public void findNameStartingWithS() {
        List<String> names = new ArrayList<>(Arrays.asList("Sona", "Tiko", "Vika", "Levon", "Susanna", "Shushanik"));
        int count = 0;
        for (String name : names) {
            if (name.startsWith("S")) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamFilter() {
        List<String> names = new ArrayList<>(Arrays.asList("Sona", "Tiko", "Vika", "Levon", "Susanna", "Sara"));
        //stream is applied to list object, it makes stream from object and goes one by one through the list,
        // then filter it by parameter and makes another stream with filtered info, then return count of items
        // in second new stream
        Long count = names.stream().filter(s -> s.startsWith("S")).count();
        System.out.println(count);

        long l = Stream.of("Sona", "Tiko", "Vika", "Levon", "Susanna", "Sara").filter(s ->
        {
            s.startsWith("S");
            return true; // in case lambda expression returns false then the method which should be executed after it will not work
        }).count();
        System.out.println(l);

        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
    }

    @Test
    public void streamMap() {
        // Stream.of("Sona", "Tiko", "Vika", "Levon", "Susanna", "Sara").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
        // Stream.of("Sona", "Tiko", "Vika", "Levon", "Susanna", "Sara").filter(s->s.startsWith("S")).map(s->s.toUpperCase()).sorted().forEach(s-> System.out.println(s));

        List<String> names = Arrays.asList("Sona", "Tiko", "Vika", "Levon", "Susanna", "Sara");
        List<String> names1 = Arrays.asList("Karen", "Shushanik", "Eva", "Kotik", "Levon");
        //MAKE TWO STEAMS INTO ONE
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
        //when you apply some action on stream, then it returns new stream it is not the same stream as before
        Stream<String> newStream1 = newStream.sorted();
        Assert.assertTrue(newStream1.anyMatch(s-> s.equalsIgnoreCase("Levon")));

    }

    @Test
    public void streamCollect() {
//        //With collect method we will transform stream to list
//        List<String> list = Stream.of("Sona", "Tiko", "Vika", "Levon", "Susanna", "Sara").filter(s -> s.startsWith("S")).map(s -> s.toUpperCase()).collect(Collectors.toList());
//        System.out.println(list.get(0));
//        list.add("kuku");
//        list.forEach(s -> System.out.println(s));
//        //print unique elements and print first element
//        List<Integer> intList = Arrays.asList(1,5,5,6,1,2,7,8,9,9,5);
//        //intList.stream().distinct().sorted().forEach(s-> System.out.println(s));
//        intList.stream().distinct().sorted().limit(1).forEach(s-> System.out.println(s));
        //print nth item after removing duplicates ad sorting
        List<Integer> intList = Arrays.asList(1,5,5,6,1,2,7,8,9,9,5);
        List<Integer> result = intList.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(result.get(3));

    }

}





