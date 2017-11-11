/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci_chap4_routebetweennodes;

import graphing.Graph;
import graphing.Vertex;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ali
 */
public class DepthFirstSearch 
{
    
    public DepthFirstSearch()
    {
    }
    
    public boolean DFSTraversal(Graph graph, Vertex<Integer> v1, Vertex<Integer> v2)
    {
        // Check if both the vertices exist in the graph
        if (graph.getVertex(v1.getId()) == null ||
                graph.getVertex(v2.getId()) == null)
        {
            return false;
        }
        
        //initialize color of all vertices as WHITE
        Set<Vertex<Integer>> visited = new HashSet<>();
        return DFSUtil(visited, v1, v2);
    }
    
    private boolean DFSUtil(Set<Vertex<Integer>> visited, Vertex<Integer> v1, Vertex<Integer> v2)
    {
        if (visited.contains(v1))
        {
            return false;
        }
        
        if (v1 == v2)
            return true;
        
        //remove v1 from whiteSet
        visited.add(v1);
        
        for (Vertex<Integer> v : v1.getAdjacentVertices()) 
        {
            return DFSUtil(visited, v, v2);
        }
        
        return false;
    }
    
}
