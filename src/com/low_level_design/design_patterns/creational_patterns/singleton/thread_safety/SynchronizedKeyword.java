package com.low_level_design.design_patterns.creational_patterns.singleton.thread_safety;

class JudgeAnalytics {
    private static JudgeAnalytics judgeAnalytics;

    private JudgeAnalytics() {

    }

    public static synchronized JudgeAnalytics getInstance() {
        if (judgeAnalytics == null) {
            judgeAnalytics = new JudgeAnalytics();
        }
        return judgeAnalytics;
    }
}

public class SynchronizedKeyword {

    public static void main(String[] args) {

    }
}
