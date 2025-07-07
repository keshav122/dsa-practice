In Binary Search on answers we wil always know the range in which we are looking for an output.

# Check Nth root of M
If we try to do mid ^ N , then for large values it will overflow , so what we can try is to check whether mid ^ N is getting greater than M and if yes , we will return / break out of the calculation as the final output will never be greater than M

# Book Allocation problem 
- One thing to remember is that even if count is less than m , because we do not require m students but we can still distribute the pages in m students but if it is opposite (count > m students) we cannot take it as we have a limit of m students.