# MinimumInsertionsToMakePalindromicSequence
The idea is that we can make any string palindromic by attaching a reverse string to it.
We'll keep the longest palindromic subsequence intact(we 'll not change their positions). For the rest of the characters we will have to do insertions. 
So the length required will be (length of string - length of longest palindromic subsequence).