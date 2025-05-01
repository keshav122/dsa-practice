import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basics {

    public List<String> generateParenthesis(int n) {
        int len = 2 * n;
        return generateParenthesis(1, 0, 0, len);
    }

    public List<String> generateParenthesis(int positionToBeFilled, int leftBraceCount, int rightBraceCount, int n) {
        List<String> resultSet = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        if (positionToBeFilled < len && (leftBraceCount <= rightBraceCount)) {
            ans.append('(');
            generateParenthesis(positionToBeFilled + 1, ++leftBraceCount, rightBraceCount, n);
        } else if (positionToBeFilled < len && (leftBraceCount >= rightBraceCount)) {
            ans.append(')');
            generateParenthesis(positionToBeFilled + 1, leftBraceCount, ++rightBraceCount, n);
        } else if (positionToBeFilled > len && (leftBraceCount == rightBraceCount)) {
            resultSet.add(ans.toString());
            ans = new StringBuilder();
        } else {
            return resultSet;
        }
        return resultSet;
    }

    public static void main(String[] args) {
        Basics basics = new Basics();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<String> parenthesisSet = basics.generateParenthesis(n);
        for (String str : parenthesisSet) {
            System.out.print(str + " ");
        }
        s.close();
    }
}
