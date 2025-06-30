# Creating an List of fixed size with some initial value
```
List<Integer> row = new ArrayList<>(Collections.nCopies(size, 0));
```

Collections.nCopies(size, 0) - This creates an immutable list of size elements, all initialized to 0. However, this list is immutable, meaning you cannot modify its elements.

new ArrayList<>(...)
This creates a mutable ArrayList from the immutable list returned by Collections.nCopies.
Now, you can modify the elements of row.