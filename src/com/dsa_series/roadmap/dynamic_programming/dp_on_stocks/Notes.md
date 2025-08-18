# Recursion Approach - How to write a recurennce relation - 
**Best Time To Buy And Sell Stocks II**
1. Express everything in terms of paramters that change (ind,buy) - buy signifies the decision whether you can buy or not (because if you are already holding the stock you must sell it before buying it again).
f(0,1) - It tells me if we start on 0th day with allowance to buy what max profit can you give me.
2. Explore possibilities on that day
3. Take the max of all profits made
4. base case

