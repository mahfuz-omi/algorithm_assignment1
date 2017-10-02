/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1primsalgorithmdemo;

/**
 *
 * @author omi
 */
public class Edge {
    
    // edge is from source vertex to destination vertex
    public Vertex v1;
    
    // edge is from source vertex to destination vertex
    public Vertex v2;
    
    // isVisited indicated whether this edge is visited or not
    private boolean isVisited;
    
    // indicated weight of this edge
    private int weight;

    public Edge(Vertex v1, Vertex v2,int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
        this.isVisited = false;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
 

    public boolean isIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
    
    
    
    
}
