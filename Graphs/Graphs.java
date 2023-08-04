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
    public static void main(String args[]){
        int v=4;
        // 4 vertices
        ArrayList<Edge> graph[] = new ArrayList[v];
        // Adjancey list of type array of ArrayList<Edge>

    }
}

