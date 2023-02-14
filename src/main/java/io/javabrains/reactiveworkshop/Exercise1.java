package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {
        final String bar = "=========================================";

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(System.out::println);
        System.out.println(bar);

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(number -> number < 5)
                .forEach(number -> System.out.println(number));
        System.out.println(bar);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(number -> System.out.println(number));
        System.out.println(bar);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer value = StreamSources.intNumbersStream().filter(number -> number > 5)
                .findFirst().orElse(-1);
        System.out.println(value);
        System.out.println(bar);

        // Print first names of all users in userStream
//        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));
        StreamSources.userStream()
                        .map(user -> user.getFirstName() + " " + user.getLastName())
                        .forEach(System.out::println);
        System.out.println(bar);

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.intNumbersStream()
                        .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                        .map(user -> user.getFirstName())
                        .forEach(System.out::println);

        System.out.println(bar);

        StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch(i -> i == u.getId()))
                .map(u -> u.getFirstName())
                .forEach(System.out::println);

    }

}
