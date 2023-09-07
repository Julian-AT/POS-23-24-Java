package at.htldonaustadt.schmidt.registrierung.signup;

import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup {
    // instance variables
    private String name;
    private String email;
    private int age;

    // getters
    public String getLastname() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public int getAge () {
        return age;
    }

    // fetch data from console
    public void fetchData() {
        // Initialize Scanner
        Scanner sc = new Scanner(System.in);

        // fetch data from Terminal
        try {
            System.out.print("Enter your name: ");
            name = sc.nextLine(); // maybe multiple tokens
            System.out.print("Enter your email: ");
            email = sc.next(); // single token

            Pattern p = Pattern.compile("^[\\w-\\\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
            Matcher m = p.matcher(email);
            if(!m.matches()) {
                throw new InvalidParameterException("Please enter a valid E-Mail Address");
            }

            System.out.print("Enter your age: ");
            age = sc.nextInt(); // Integer token
            if(age < 1 || age > 100) {
                throw new InvalidParameterException("Please enter a valid age between 1 and 100.");
            }
        }
        catch (InvalidParameterException e) {
            // print stack trace and throw exception
            e.printStackTrace();
            throw new InvalidParameterException(e.getLocalizedMessage());
        }
    }

    // print data to Terminal
    public void printData() {
        if(name != null && !name.trim().isEmpty() && email!= null &&!email.trim().isEmpty() && age > 0 && age <= 100) {
            System.out.printf(String.format("Hey, %s. You are %d years old and your mail is %s", name, age, email));
        }
        else {
            throw new InputMismatchException("Invalid/Insufficient data entered. Please try again");
        }
    }
}
