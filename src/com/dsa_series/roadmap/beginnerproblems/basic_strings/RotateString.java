/*Author: keshav122 */
package com.dsa_series.roadmap.beginnerproblems.basic_strings;

public class RotateString {

    public boolean rotateString_optimal(String s, String goal) {
        String concatString = s.concat(s);
        return (concatString.indexOf(goal) != -1);
    }

    public boolean rotateString(String s, String goal) {
        String concatString = s.concat(s);
        return (concatString.indexOf(goal) != -1);
    }
}
