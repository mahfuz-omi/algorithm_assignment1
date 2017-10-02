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
public class Vertex {
    
    // id of the vertex. possible value ranges from 1 to n
    private int id;
    
    // isVisited indicated whether this vertex is visited or not
    private boolean isVisited;
    
    // this is the key value of this vertex
    public Key key;

    public Vertex(int id) {
        this.id = id;
        this.isVisited = false;
        this.key = new Key(10000);
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

   
    @Override
    public boolean equals(Object obj) {
         Vertex vertex = (Vertex)obj;
         return (this.key.keyValue == vertex.key.keyValue && this.id == vertex.getId());
    }
    
    
    
    
    
    
    
    
    
    
}
