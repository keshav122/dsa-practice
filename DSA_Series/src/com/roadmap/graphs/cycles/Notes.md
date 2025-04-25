### Bipartite Graph - A bipartite graph is a graph that can be colored using 2 colors such that no adjacent nodes have the same color. 
- Any linear graph with no cycle is always a bipartite graph.
- With a cycle, any graph with an even cycle length can also be a bipartite graph. So, any graph with an odd cycle length can never be a bipartite graph.



## Topological Sort
The topological sorting of a directed acyclic graph is nothing but the linear ordering of vertices such that if there is an edge between node u and v(u -> v), node u appears before v in that ordering.

Why does topological sort only exist in DAG?

If the edges are undirected: An undirected edge between node u and v signifies an edge from u to v (u->v) as well as from v to u (v->u) making it practically impossible to write such orderings where u appears before v and v appears before u simultaneously.
If the directed graph contains a cycle: There is no linear ordering possible for nodes in cycles, making it impossible for topological sorting to exist.

# Kahn's Algorithm - Topological Sort using BFS

The algorithm suggests that there will always be at least one node having in-degree as zero, which means all such nodes can be put before any other node in the ordering as there is no node pointing to any of these nodes.

After such nodes are added to the ordering, the edges from these nodes can be removed, updating the in-degree of other nodes and exposing more nodes having an in-degree of zero. This process can be repeated till there are nodes left in the graph to get the required linear ordering.

Approach:
Prepare a list to store the topological order. Create an array to track the in-degree (number of incoming edges) of each node. Traverse each node and update the in-degree of its neighbors based on the adjacency list representation of the graph.
Initialize a queue and add all nodes with zero in-degree to it. These nodes have no dependencies and can be processed first.
Use a loop to process nodes from the queue until it is empty:
Remove a node from the front of the queue and add it to the topological order list.
For each neighbor of the removed node, reduce its in-degree by one.
If a neighbor's in-degree becomes zero, all its parent nodes are processed so add it to the queue.
After processing all nodes, the topological order list will contain a valid topological sorting of the graph.



# For a Directed graph to be cyclic , the node has to be revisited on the same path.