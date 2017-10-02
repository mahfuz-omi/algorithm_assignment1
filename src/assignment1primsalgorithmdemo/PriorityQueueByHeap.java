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
public class PriorityQueueByHeap {
    // It is a min priority heap
    
    public static final int MAX_SIZE = 100;
    private Vertex[] vertices;
    private int currentIndex;
   

    public PriorityQueueByHeap(int numOfVertices) {
       
        this.vertices = new Vertex[MAX_SIZE];
        this.currentIndex = 0;
    }
    
    private void swap(int childIndex,int parentIndex)
    {
        Vertex temp;
        temp = this.vertices[parentIndex];
        this.vertices[parentIndex] = this.vertices[childIndex];
        this.vertices[childIndex] = temp;    
    }
    
    private void trickle_up(int child)
    {
        swap(child,(child-1)/2);
        child = (child-1)/2;
        if(child == 0)
            return;
        if(this.vertices[child].key.keyValue < this.vertices[(child-1)/2].key.keyValue)
        {
            this.trickle_up(child);    
        }    
    }
    
    public void trickle_down(int index)
    {
        int smallerChildIndex =0;
        int leftChildIndex = 2*index + 1;
        int rightChildIndex = leftChildIndex + 1;
        if(this.currentIndex <= 2*index+1) // this node has no child
            return;
        if(this.vertices[leftChildIndex].key.keyValue < this.vertices[rightChildIndex].key.keyValue )
            smallerChildIndex = leftChildIndex;
        else
            smallerChildIndex = rightChildIndex;
        if(this.vertices[smallerChildIndex].key.keyValue > this.vertices[index].key.keyValue)
            return;    // end of trickle
        swap(index,smallerChildIndex);
        trickle_down(smallerChildIndex);    
    }
    
    public Vertex pop()
    {
        // delete the min node....here it is root
        Vertex node = this.vertices[0];
        this.currentIndex--;
        this.vertices[0] = this.vertices[this.currentIndex];
        this.trickle_down(0);
        return node;
    }
    
    public void changeKey(Vertex vertex, int newKey)
    {
        int index = 0;
        for(int i=0;i<currentIndex;i++)
        {
            if(this.vertices[i].equals(vertex))
            {
                index = i;
            }
        }
        
        int oldKey = vertex.key.keyValue;
        if(oldKey < newKey)
            trickleDownNew(index);
        else
            trickeUpNew(index);
        
    }
    
    
    public void push(Vertex node)
    {
        if(this.currentIndex == MAX_SIZE)
        {
            System.out.println("no place for new data...heap full");
            return;   
        }
        //HuffmanNode node = new HuffmanNode(data);
        this.vertices[this.currentIndex] = node;
        if(this.currentIndex == 0)
        {
            this.currentIndex++;
            return;
        }
        
        // if child is at x index, it's parent is at (x-1)/2 index.
        //for a node in x index, it's left child is at 2x+1 and right child is at 2x+2 index.
        if(this.vertices[this.currentIndex].key.keyValue < this.vertices[(this.currentIndex-1)/2].key.keyValue)
        {
            this.trickle_up(this.currentIndex);   
        }
        this.currentIndex++;
                
    }
    
    
    public void pushNew(Vertex node)
    {
        ////// new code
        if(this.currentIndex == 0)
        {
            this.vertices[this.currentIndex] = node;
            this.currentIndex++;
            return;
        }
        
        this.vertices[this.currentIndex] = node;
        this.trickeUpNew(currentIndex);
        this.currentIndex++;
          
    }
    
    public Vertex popNew()
    {
        // delete the min node....here it is root
        Vertex node = this.vertices[0];
        this.currentIndex--;
        this.vertices[0] = this.vertices[this.currentIndex];
        this.trickleDownNew(0);
        return node;
        
    }
    
    public void trickeUpNew(int index)
    {
        // confliction can only be happed with parent
        int childIndex = index;
        int parentIndex = (childIndex-1)/2;
        
        while(this.vertices[parentIndex].key.keyValue > this.vertices[childIndex].key.keyValue)
        {
            this.swap(childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;   
        }
        
    }
    
    
    public void trickleDownNew(int index)
    {
        int parentIndex = index;
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = leftChildIndex + 1;
        int smallerChildIndex = leftChildIndex; // default
        if(this.currentIndex <= 2*index+1) // this node has no child
            return;
        if(this.vertices[leftChildIndex].key.keyValue > this.vertices[index].key.keyValue && this.vertices[rightChildIndex].key.keyValue > this.vertices[index].key.keyValue)
        {
            // the heap is balanced
            // no need to trickleDown
            return;
        }
        if(this.vertices[leftChildIndex].key.keyValue < this.vertices[rightChildIndex].key.keyValue )
            smallerChildIndex = leftChildIndex;
        else
            smallerChildIndex = rightChildIndex;
        if(this.vertices[smallerChildIndex].key.keyValue > this.vertices[index].key.keyValue)
            return;    // end of trickle
        swap(index,smallerChildIndex);
        trickleDownNew(smallerChildIndex);
           
    }
    
    
    
    public boolean isEmpty()
    {
        if(this.currentIndex == 0)
            return true;
        else
            return false;
    }
    
    public boolean isVertexAvailable(Vertex vertex)
    {
        for(int i=0;i<this.currentIndex;i++)
        {
            if(vertex.equals(this.vertices[i]))
                return true;
        }
        return false;
    }
    
   
    public void printQueue()
    {
        System.out.println("current index: "+currentIndex);
        
        for(int i=0;i<currentIndex;i++)
        {
            System.out.println("id: "+this.vertices[i].getId()+" key: "+this.vertices[i].key.keyValue);
        }
        
    }
    
    
    
    
      
}






  