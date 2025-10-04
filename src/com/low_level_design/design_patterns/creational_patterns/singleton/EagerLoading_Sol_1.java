package com.low_level_design.design_patterns.creational_patterns.singleton;

//Thread - safes
class JudgeAnalytics {
    // Because this line executes during the class load time , that is why this is
    // called eager loading.
    private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();

    private JudgeAnalytics() {

    }

    // Should be static so that we do not need to create an instance of the class
    public static JudgeAnalytics getInstance() {
        return judgeAnalytics;
    }
}

public class EagerLoading_Sol_1 {

    public static void main(String[] args) {
        // Because of the private constructor we will not be able to create a
        // object of the JudgeAnalytics class
        // JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
        JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();
        JudgeAnalytics judgeAnalytics2 = JudgeAnalytics.getInstance();
        // Both the objects are same
        System.out.println(judgeAnalytics);
        System.out.println(judgeAnalytics2);
    }

}
