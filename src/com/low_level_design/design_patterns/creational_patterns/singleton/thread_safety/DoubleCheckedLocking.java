package com.low_level_design.design_patterns.creational_patterns.singleton.thread_safety;

class JudgeAnalytics {
    /*
     * When a variable is declared volatile, it ensures that all threads accessing
     * that variable will always read its value directly from main memory and write
     * updates directly to main memory, bypassing thread-local caches. This
     * guarantees that any changes made by one thread are immediately visible to
     * other threads.
     * 
     * Prevents Instruction Reordering:
     * The volatile keyword also prevents the Java Virtual Machine (JVM) and the
     * compiler from reordering instructions involving the volatile variable. This
     * is crucial for maintaining memory consistency in concurrent programs.
     * 
     * Not a Substitute for Synchronization:
     * While volatile ensures visibility, it does not guarantee atomicity for
     * operations involving multiple steps (like count++, which involves reading,
     * modifying, and writing). For such operations, synchronization mechanisms like
     * synchronized blocks or java.util.concurrent.atomic classes are required to
     * prevent race conditions.
     * 
     * Use Cases:
     * volatile is commonly used for shared variables that act as flags or status
     * indicators, where the consistent state across threads is necessary for
     * correct program behavior. For example, a volatile boolean flag can be used to
     * signal a thread to stop execution.
     */

    private static volatile JudgeAnalytics judgeAnalytics;

    private JudgeAnalytics() {

    }

    public static JudgeAnalytics getInstance() {
        if (judgeAnalytics == null) {
            // Checking that some other thread has not initialized this
            synchronized (JudgeAnalytics.class) {
                if (judgeAnalytics == null) {
                    judgeAnalytics = new JudgeAnalytics();
                }
            }
        }
        return judgeAnalytics;
    }
}

public class DoubleCheckedLocking {

}
