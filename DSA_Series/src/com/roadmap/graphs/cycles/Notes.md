### Bipartite Graph - A bipartite graph is a graph that can be colored using 2 colors such that no adjacent nodes have the same color. 
- Any linear graph with no cycle is always a bipartite graph.
- With a cycle, any graph with an even cycle length can also be a bipartite graph. So, any graph with an odd cycle length can never be a bipartite graph.



## Topological Sort
The topological sorting of a directed acyclic graph is nothing but the linear ordering of vertices such that if there is an edge between node u and v(u -> v), node u appears before v in that ordering.

Why does topological sort only exist in DAG?

If the edges are undirected: An undirected edge between node u and v signifies an edge from u to v (u->v) as well as from v to u (v->u) making it practically impossible to write such orderings where u appears before v and v appears before u simultaneously.
If the directed graph contains a cycle: There is no linear ordering possible for nodes in cycles, making it impossible for topological sorting to exist.