# FruitsIntoBasketsIII_3479
Segment Tree ek binary tree hai jo kisi array ke elements ke range-based queries (sum, min, max, etc.) ko fast karne ke liye hota hai.
Our use case :
Find the minimum basket capacity in a range — and later we'll use it to find leftmost basket ≥ fruit[i].

Segment Tree array mein tree[0] ka koi matlab nahi hota. 🚫
Ye intentional waste hota hai.

🧠 Why is tree[0] unused?
Because:
Segment tree is typically implemented as 1-indexed (starting from index 1)
Isse left child = 2 * i and right child = 2 * i + 1 ka logic perfectly kaam karta hai
✅ Tree Node Indexing:
Node Index i	Represents
1	Root of the tree (entire array range)
2	Left child of root
3	Right child of root
4	Left child of node 2
5	Right child of node 2
...	and so on

🔧 Agar hum 0 se start karte (0-indexed):
Then:

Left child = 2 * i + 1
Right child = 2 * i + 2
But ye code aur logic ko thoda complex bana deta hai, especially for beginners

Isliye:
Most implementations (especially in CP / interviews / simple code) start from tree[1]

Aur tree[0] ko chhod dete hain (unused rahta hai)

