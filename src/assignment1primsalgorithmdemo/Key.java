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
public class Key {
    public int keyValue;
    public Vertex fromVertex;
    
    public Key(int keyValue)
    {
        this.keyValue = keyValue;
        this.fromVertex = null;
    }
    
}
