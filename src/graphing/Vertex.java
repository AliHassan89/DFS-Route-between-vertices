/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphing;

import java.util.*;

/**
 *
 * @author Ali
 * @param <T>
 */
public class Vertex<T> 
{
    long id;
    private int data;
    private final List<Edge<T>> edges = new ArrayList<>();
    //Using adjecency list
    private final List<Vertex<T>> adjacentVertex = new ArrayList<>();
    
    public Vertex(long id)
    {
        this.id = id;
    }
    
    public long getId()
    {
        return id;
    }
    
    public void setData(int data)
    {
        this.data = data;
    }
    
    public int getData()
    {
        return data;
    }
    
    public void addAdjacentVertex(Edge<T> e, Vertex<T> v)
    {
        edges.add(e);
        adjacentVertex.add(v);
    }
    
    @Override
    public String toString()
    {
        return String.valueOf(id);
    }
    
    public List<Vertex<T>> getAdjacentVertices()
    {
        return adjacentVertex;
    }
    
    public List<Edge<T>> getEdges()
    {
        return edges;
    }
    
    public int getDegree()
    {
        return edges.size();
    }
    
    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        
        return id == other.id;
    }
}
