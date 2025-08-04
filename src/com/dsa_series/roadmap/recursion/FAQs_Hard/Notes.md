# Palindrome Partitioning
The key is to start from a index and then iterate over the string and see if the substring is a palindrome . if it is call the function for the next index. This way we can split the string.

```
private void partitions(int index, String s, List<String>  ans , List<List<String>> res){
        if(index == s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int j = index; j < s.length();j++){
            if(isPalindrome(s,index,j)){
                ans.add(s.substring(index, j+1));
                // Make sure to do (j + 1) here and not index + 1 because we have already taken 
                // the string upto index j.
                partitions(j + 1,s,ans,res);
                ans.remove(ans.size() - 1);
            }
        }
    }

    ```

# Word Search 
The key here is to only start in cases where you have matched the first character. 
The second important thing is to mark the character which you have already visited as empty for the current iteration so that you don't run into a infinite loop or select the same character more than once.