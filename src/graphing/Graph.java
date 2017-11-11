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
public class Graph<T>
{
    private final List<Edge<T>> allEdges;
    private final Map<Long,Vertex<T>> allVertex;
    boolean isDirected = false;
    
    public Graph(boolean isDirected)
    {
        allEdges = new ArrayList<>();
        allVertex = new HashMap<>();
        this.isDirected = isDirected;
    }
    
    public void addEdge(long id1, long id2)
    {
        addEdge(id1,id2,0);
    }
    
    //This works only for directed graph because for undirected graph we can end up
    //adding edges two times to allEdges
    public void addVertex(Vertex<T> vertex)
    {
        if(allVertex.containsKey(vertex.getId()))
        {
            return;
        }
        allVertex.put(vertex.getId(), vertex);
        for(Edge<T> edge : vertex.getEdges())
        {
            allEdges.add(edge);
        }
    }
    
    public Vertex<T> addSingleVertex(long id)
    {
        if(allVertex.containsKey(id))
        {
            return allVertex.get(id);
        }
        Vertex<T> v = new Vertex<>(id);
        allVertex.put(id, v);
        return v;
    }
    
    public Vertex<T> getVertex(long id)
    {
        return allVertex.get(id);
    }
    
    public void addEdge(long id1,long id2, int weight)
    {
        Vertex<T> vertex1 = null;
        if(allVertex.containsKey(id1))
        {
            vertex1 = allVertex.get(id1);
        }
        else
        {
            vertex1 = new Vertex<>(id1);
            allVertex.put(id1, vertex1);
        }
        Vertex<T> vertex2 = null;
        if(allVertex.containsKey(id2))
        {
            vertex2 = allVertex.get(id2);
        }
        else
        {
            vertex2 = new Vertex<>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<>(vertex1,vertex2,isDirected,weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected)
        {
            vertex2.addAdjacentVertex(edge, vertex1);
        }

    }
    
    //add edge between two given vertices when weight is 0
    public void addEdge(Vertex<T> v1,Vertex<T> v2)
    {
        addEdge(v1,v2, 0);
    }
    
    //add edge between two given vertices and there weight
    public void addEdge(Vertex<T> v1,Vertex<T> v2, int weight)
    {
        if(!allVertex.containsValue(v1))
        {
            allVertex.put(v1.getId(), v1);
        }
        
        if(!allVertex.containsValue(v2))
        {
            allVertex.put(v2.getId(), v2);
        }

        Edge<T> edge = new Edge<>(v1,v2,isDirected,weight);
        allEdges.add(edge);
        v1.addAdjacentVertex(edge, v2);
        if(!isDirected)
        {
            v2.addAdjacentVertex(edge, v1);
        }

    }
    
    public List<Edge<T>> getAllEdges(){
        return allEdges;
    }
    
    public Collection<Vertex<T>> getAllVertices()
    {
        return allVertex.values();
    }
    
    public void setDataForVertex(long id, int data)
    {
        if(allVertex.containsKey(id))
        {
            Vertex<T> vertex = allVertex.get(id);
            vertex.setData(data);
        }
    }

    @Override
    public String toString(){
        StringBuilder buffer = new StringBuilder();
        for(Edge<T> edge : getAllEdges()){
            buffer.append(edge.getVertex1()).append(" ")
                    .append(edge.getVertex2()).append(" ")
                    .append(edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
