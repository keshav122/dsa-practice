package com.low_level_design.design_patterns.creational_patterns.singleton.thread_safety;

class JudgeAnalytics {

    private JudgeAnalytics() {

    }

    // The static inner class (Holder) is not loaded until referenced, thanks to
    // Java's class loading mechanism.
    private static class Holder {
        private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
    }

    public static JudgeAnalytics getInstance() {
        return Holder.judgeAnalytics;
    }
}

public class BillPughSingelton {

}
