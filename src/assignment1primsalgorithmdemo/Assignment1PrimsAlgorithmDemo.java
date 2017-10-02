/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1primsalgorithmdemo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author omi
 */
public class Assignment1PrimsAlgorithmDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int vertexCount = scanner.nextInt();
        
        Graph graph = new Graph(vertexCount);
        
        int edgeCount = scanner.nextInt();
        
        for(int i=1;i<=edgeCount;i++)
        {
            int sourceVertexId = scanner.nextInt();
            int destinationVertexId = scanner.nextInt();
            int weight = scanner.nextInt();
             
            graph.addEdge(sourceVertexId, destinationVertexId, weight);
        }
        
        ArrayList<Edge> mst = graph.getMSTByPrimsAlgorithm();
        int mstWeight = graph.getMSTWeight();
        
        for(int i=0;i<mst.size();i++)
        {
            Edge edge = mst.get(i);
            System.out.println(edge.v1.getId()+" "+edge.v2.getId());
        }
        
        System.out.println(mstWeight);
        
         
    }
    
}
