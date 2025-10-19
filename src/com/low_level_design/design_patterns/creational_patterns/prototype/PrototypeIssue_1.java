package com.low_level_design.design_patterns.creational_patterns.prototype;

interface EmailTemplate {
    void setContent(String content);

    void send(String to);
}

class WelcomeEmail implements EmailTemplate {

    private String subject;
    private String content;

    public WelcomeEmail() {
        this.subject = "Welcome To TUF+";
        this.content = "Hi there. Thanks for joining us.";
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void send(String to) {
        System.out.println("Sending to " + to + " : [" + subject + " ] " + content);
    }

}

public class PrototypeIssue_1 {

    public static void main(String[] args) {
        // We will be creating the same object in lots of places if we are using it in
        // mutiple places
        WelcomeEmail welcomeEmailTUF = new WelcomeEmail();
        welcomeEmailTUF.setContent("Welcome to TUF");

        // We cannot use singleton as the TUFPlus set content object will also set the
        // content for TUF But we also don't want to create separate objects like below.
        WelcomeEmail welcomeEmailTUFPlus = new WelcomeEmail();
        welcomeEmailTUFPlus.setContent("Welcome to TUF Plus");

    }
}
