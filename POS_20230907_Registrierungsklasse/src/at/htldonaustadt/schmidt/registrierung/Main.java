package at.htldonaustadt.schmidt.registrierung;

import at.htldonaustadt.schmidt.registrierung.backend.Signup;

public class Main {
    public static void main(String[] args) {
        Signup signup = new Signup();
        signup.fetchData();
        signup.printData();
    }
}