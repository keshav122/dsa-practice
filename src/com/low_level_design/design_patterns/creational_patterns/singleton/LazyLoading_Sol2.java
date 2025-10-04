package com.low_level_design.design_patterns.creational_patterns.singleton;

//Lazy Loading is not thread safe , Because we might get different instances 
//we have mutiple threads , as the instance is not created during the class loading time rather 
//it is created during the execution time.
class JudgeAnalytics {

    private static JudgeAnalytics judgeAnalytics;

    private JudgeAnalytics() {

    }

    public static JudgeAnalytics getInstance() {
        if (judgeAnalytics == null) {
            judgeAnalytics = new JudgeAnalytics();
        }
        return judgeAnalytics;
    }
}

public class LazyLoading_Sol2 {

    public static void main(String[] args) {
        JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();
        JudgeAnalytics judgeAnalytics2 = JudgeAnalytics.getInstance();
        // Both the objects are same
        System.out.println(judgeAnalytics);
        System.out.println(judgeAnalytics2);
    }
}
