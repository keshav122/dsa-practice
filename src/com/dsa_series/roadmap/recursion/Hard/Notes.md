# Letter Combinations Of A Phone
- We can take the number letter combinations in a HashMap or even in a array (for cleaner code - take indices 0 & 1 as "").
- We need to iterate from indices of the input string and for each of the digits , we will get the correspoding string. For eg : for 3 we will get "def" . And then we will do a recursive call for each of the characters with index + 1

```
private void combinations(int index, String currString, String[] keypad, String digits, List<String> res){
      if(currString.length() == digits.length()){
        res.add(currString);
        return;
      }
      int number = (int) (digits.charAt(index) -'0');
      for(int i = 0; i < keypad[number].length(); i++){
         combinations(index + 1, currString + keypad[number].charAt(i),keypad,digits,res);
      }
    }

```
