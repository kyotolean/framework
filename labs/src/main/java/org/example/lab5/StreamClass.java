package org.example.lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamClass {
    private static final String CHARACTER_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int STRING_LENGTH = 10;
    public static void main(String[] args) {
        int n = 10;

        List<PersonEntity> personEntityList  = generatePersonEntityList(n);

        System.out.println("All person data");
        System.out.println(personEntityList);

//        System.out.println("Sorted Name Entity List");
//        System.out.println(personEntityList.stream().sorted().collect(Collectors.toList()));

        System.out.println("filter to age 30");
        System.out.println(personEntityList.stream().filter(person -> person.getAge() < 30).collect(Collectors.toList()));

        System.out.println("map all name");
        System.out.println(personEntityList.stream().map(PersonEntity::getName).collect(Collectors.toList()));

    }
    public static List<PersonEntity> generatePersonEntityList(int n){
        Random random = new Random();
        List<PersonEntity> personEntityList = new ArrayList<>();

        IntStream.range(1, n).forEach(i ->{
            PersonEntity person = new PersonEntity();


            person.setName(generateRandomString());
            person.setAge(random.nextInt(50)+1);

            List<String> friend = new ArrayList<>();
            for(int j = 0; j < 10; j++){
                String text = generateRandomString();
                friend.add(text);
            }

            person.setFriends(friend);
            personEntityList.add(person);
        });
        return personEntityList;
    }
    public static String generateRandomString(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(STRING_LENGTH);

        for(int j = 0; j < STRING_LENGTH; j++){
            int randomIndex = random.nextInt(CHARACTER_SET.length());
            char randomChar = CHARACTER_SET.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }
}
