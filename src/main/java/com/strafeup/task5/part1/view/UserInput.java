package com.strafeup.task5.part1.view;

import com.strafeup.task5.part1.model.Address;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);


    public static int getNumber() {
        return sc.nextInt();
    }

    public static String getWordStartsWithUppercase(String type) {
        Pattern pName = Pattern.compile("^[A-Z][\\w]{1,15}$");
        ConsolePrinter.print("Enter a " + type + " that starts with Uppercase letter");

        String text = sc.next().strip();
        Matcher matcher = pName.matcher(text);

        while (!pName.matcher(text).matches()) {
            ConsolePrinter.print("Invalid format");
            text = sc.next();
        }
        return text;
    }


    public static String getPhoneNumber() {
        Pattern pNumber = Pattern.compile("^\\+?(38)?(\\d{10,11})$");

        ConsolePrinter.print("Enter phone number in format: +38XXXPhoneNumber, where XXX - operator's code");
        String text = sc.next().strip();
        Matcher matcher = pNumber.matcher(text);

        while (!pNumber.matcher(text).matches()) {
            ConsolePrinter.print("Invalid format");
            text = sc.next();
        }
        return text;
    }

    public static LocalDate getDateOfBirth() {
        Pattern pDate = Pattern.compile("^([0-2][0-9]|(3)[0-1])-(((0)[0-9])|((1)[0-2]))-\\d{4}$");

        ConsolePrinter.print("Enter your date of birth in format dd-mm-yyyy");
        String text = sc.next().strip();
        Matcher matcher = pDate.matcher(text);

        while (!pDate.matcher(text).matches()) {
            ConsolePrinter.print("Invalid format");
            text = sc.next();
        }

        return LocalDate.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public static Address getAddress() {
        Pattern pAddress = Pattern.compile("^(\\w{1,20}),(\\d{1,3}(-\\w{0,2})?),(\\d{1,3})$");
        ConsolePrinter.print("Enter your home address StreetName,HouseNumber,FlatNumber");
        String text = sc.next().strip();
        Matcher matcher = pAddress.matcher(text);

        while (!pAddress.matcher(text).matches()) {
            ConsolePrinter.print("Invalid format");
            text = sc.next();
        }
        String[] tokens = text.split(",");
        return new Address(tokens[0], tokens[1], tokens[2]);
    }

}
