# Kosaraju Algorithm

Strongly connected components are only valid for directed graphs
In a strongly connected component, each of the nodes are reachable via every other node.

- Steps
1. Sort all the edges according to the finishing time.
2. Reverse the graph.
3. Do a dfs


# Bridge 
Any edge on whose removal the graph is divided in two or more components.
The step at which we reach a node is known as the time of insertion.
Time[] : store the time of insertion during DFS.
Lowest time : low[] : Min/Lowest time insertion of all adjacent nodes  **apart from parent **.

# Articulation Points 
Nodes on whose removal the graph breaks into multiple components.
time[] : store the time of insertion during DFS.
Lowest time : Min/Lowest time insertion of all adjacent nodes  **apart from parent and visited nodes **.
