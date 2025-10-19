package com.low_level_design.design_patterns.creational_patterns.prototype;

import java.util.HashMap;
import java.util.Map;

interface EmailTemplate extends Cloneable {
    EmailTemplate clone(); // Deep copy recommended

    void setContent(String content);

    void send(String to);

    String getContent();

}

class WelcomeEmail implements EmailTemplate {

    private String subject;
    private String content;

    public WelcomeEmail() {
        this.subject = "Welcome To TUF+";
        this.content = "Hi there. Thanks for joining us.";
    }

    @Override
    public WelcomeEmail clone() {
        try {
            return (WelcomeEmail) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone Failed", e);
        }

    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void send(String to) {
        System.out.println("Sending to " + to + " : [" + subject + " ] " + content);
    }

    @Override
    public String getContent() {
        return content;
    }
}

class EmailTemplateRegistery {
    private static final Map<String, EmailTemplate> templates = new HashMap<>();
    static {
        templates.put("Welcome", new WelcomeEmail());
        // Add more templates like "discount" , "feature-update" etc
    }

    public static EmailTemplate getTemplate(String type) {
        return templates.get(type).clone();// clone avoids modifying original
    }

}

public class PrototypeSol {

    public static void main(String[] args) {
        EmailTemplate welcomeEmail = EmailTemplateRegistery.getTemplate("welcome");
        welcomeEmail.setContent("type-1");
        System.out.println(welcomeEmail.getContent());
        EmailTemplate welcomeEmail2 = EmailTemplateRegistery.getTemplate("welcome");
        // The following line will make change on the cloned object not on the main
        // object
        welcomeEmail2.setContent("type-2");
        System.out.println(welcomeEmail.getContent());
        System.out.println(welcomeEmail2.getContent());

    }
}
