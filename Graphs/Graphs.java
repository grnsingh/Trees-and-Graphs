package Graphs;
import java.util.*;
public class Graphs {

    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src= s;
            this.dest = d;
        }

    }

    public static void createGraph(ArrayList<Edge> graph[]){
        // creating array of arraylists
        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));


        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,1));
    }

    public static void bfs(ArrayList<Edge> graph[], int V){
        Queue<Integer>  q = new LinkedList<>();
        // boolean visited[] = new boolean[V];
        HashSet<Integer> visited = new HashSet();

        q.offer(0);
        while(!q.isEmpty()){
            int curr = q.poll();
            if(!visited.contains(curr)){
                System.out.println(curr);
                visited.add(curr);

                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.offer(e.dest);
                }
            }

        }

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, HashSet<Integer> vis){
        System.out.println(curr);
        vis.add(curr);

        for(int i = 0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis.contains(e.dest)){
                dfs(graph, e.dest, vis );

            }
        }
    }

    
    public static void main(String args[]){
        int v=4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        System.out.println("BFS");
        bfs(graph, v);

        System.out.println("DFS ");
        HashSet<Integer> vis = new HashSet<>();
        dfs(graph, 0, vis);

        



    }
}

