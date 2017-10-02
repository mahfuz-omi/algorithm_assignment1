/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1primsalgorithmdemo;

import java.util.ArrayList;

/**
 *
 * @author omi
 */
public class Graph {
    
    // It's an undirected and weighted graph represented by adjacency matrix
    
    private Vertex [] vertices;
    private int [][] edgesArray;
    private int numOfVertices;
    private PriorityQueueByHeap priorityQueueByHeap;
    private ArrayList<Edge> mst;
    private int mstWeight;
    
    
    public Graph(int numOfVertices)
    {
        this.numOfVertices = numOfVertices;
        this.mstWeight = 0;
        this.vertices = new Vertex[numOfVertices+1];
        
        // adding vertices
        for(int i=1;i<=numOfVertices;i++)
        {
            Vertex vertex = new Vertex(i);
            this.vertices[i] = vertex;   
        }
        
        this.edgesArray = new int[numOfVertices+1][numOfVertices+1];
        
        // initialize edgesArray
        for(int i=1;i<=numOfVertices;i++)
        {
            for(int j=1;j<=numOfVertices;j++)
            {
                this.edgesArray[i][j] = -1;
            }
        }
    }
    
    
    public void addEdge(int sourceVertexId, int destinationVertexId, int weight)
    {
        this.edgesArray[sourceVertexId][destinationVertexId] = weight;
        this.edgesArray[destinationVertexId][sourceVertexId] = weight;
    }
    
  
    
    public int getWeight(Vertex sourceVertex,Vertex destinationVertex)
    {
        return this.edgesArray[sourceVertex.getId()][destinationVertex.getId()];
    }
    
    public ArrayList<Vertex> getAdjacentVertices(Vertex vertex)
    {
        ArrayList<Vertex> vertices = new ArrayList<>();
        for(int i=1;i<=this.numOfVertices;i++)
        {
            if(this.edgesArray[vertex.getId()][i] > 0)
                vertices.add(this.getVertexById(i));
        }
        
      
        return vertices;    
    }
    
    
    public Vertex getVertexById(int vertexId)
    {
        return this.vertices[vertexId];
    }
    
    
    
    
    public Vertex[] getVertices()
    {
        return this.vertices;
    }
    
    public int[][] getEdgesArray()
    {
        return this.edgesArray;
    }
    
    
    public void initializeSingleSource()
    {
        // source vertex id is 1
        this.vertices[1].key.keyValue = 0;
    }
    
    public void initializePriorityQueue()
    {
        this.priorityQueueByHeap = new PriorityQueueByHeap(this.numOfVertices);
        for(int i=1;i<=this.numOfVertices;i++)
        {
            this.priorityQueueByHeap.pushNew(this.vertices[i]);    
        } 
    }
    
    
    public ArrayList<Edge> getMSTByPrimsAlgorithm()
    {
        this.initializeSingleSource();
        this.initializePriorityQueue();
        
        this.priorityQueueByHeap.printQueue();
        
        this.mst = new ArrayList<>();
        
        while(!this.priorityQueueByHeap.isEmpty())
        {
            //System.out.println("");
            //System.out.println("popping....");
            Vertex min = this.priorityQueueByHeap.popNew();
            if(min.key.keyValue != 0)
            {
                Edge edge = new Edge(min, min.key.fromVertex, min.key.keyValue);
                mst.add(edge);
                mstWeight += min.key.keyValue;    
            }
            
            //System.out.println(min.getId());
            
            for(Vertex adjacentVertex:this.getAdjacentVertices(min))
            {
                int weight = this.getWeight(min, adjacentVertex);
                if(this.priorityQueueByHeap.isVertexAvailable(adjacentVertex) && weight < adjacentVertex.key.keyValue)
                {
                    adjacentVertex.key.keyValue = weight;
                    adjacentVertex.key.fromVertex = min;
                    this.priorityQueueByHeap.changeKey(adjacentVertex, weight);  
                }   
            }
               
        }
        return mst;   
    }
    
    
    public int getMSTWeight()
    {
        return this.mstWeight;
    }
       
}
