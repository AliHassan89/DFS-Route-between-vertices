/*
 Route Between Nodes: Given a directed graph, design an algorithm to find out 
 whether there is a route between two nodes.
 */
package cci_chap4_routebetweennodes;

import graphing.Graph;
import graphing.Vertex;


/**
 *
 * @author Ali
 */
public class CCI_Chap4_RouteBetweenNodes 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Graph<Integer> graph = new Graph<>(true);
        
        //create vertices
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        
        //add edges between vertices
        graph.addEdge(v1, v2);
        graph.addEdge(v2, v3);
        graph.addEdge(v3, v4);
        graph.addEdge(v4, v5);
        // Call to DFS method
        DepthFirstSearch dfs = new DepthFirstSearch();
        System.out.println(dfs.DFSTraversal(graph, v1, v4));
    }    
}
