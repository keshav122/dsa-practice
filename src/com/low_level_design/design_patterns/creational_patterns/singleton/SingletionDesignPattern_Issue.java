package com.low_level_design.design_patterns.creational_patterns.singleton;

class JudgeAnalyticsPb {
    private int run = 0;
    private int submit = 0;

    public void countRun() {
        run++;
    }

    public void countSubmit() {
        submit++;
    }

    public int getRunCount() {
        return run;
    }

    public int getSubmitCount() {
        return submit;
    }
}

public class SingletionDesignPattern_Issue {

    public static void main(String[] args) {
        JudgeAnalyticsPb judgeAnalytics = new JudgeAnalyticsPb();
        // Whenever there is a run
        judgeAnalytics.countRun();
        // Whenever there is a submission
        judgeAnalytics.countSubmit();

        // This however will not store the run and submit count on a global
        // level as this is new object createds
        JudgeAnalyticsPb judgeAnalytics2 = new JudgeAnalyticsPb();
        judgeAnalytics2.countRun();
        judgeAnalytics2.countSubmit();

    }
}
