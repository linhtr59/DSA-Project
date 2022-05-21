// Full Name (StudentNum), Full Name (StudentNum)
//Linh Trinh (23234683), Thai Hoang Long Nguyen(23147438)
/**
 * An implementation of the Subsidiaries problem from the 2022 CITS2200 Project
 */

import java.util.*;
public class SubsidiariesImpl implements Subsidiaries {
  /**
   * {@inheritdoc}
   */
  public int[] sharedOwners(int[] owners, Query[] queries) {
      
    // TODO: Implement your solution
    int [] result = new int [queries.length];
    Graph graph = new Graph(owners.length);
    for (int i =0; i < owners.length; i++){
        if (owners[i] != -1){
            graph.addEdge(i, owners[i]);
        }
    }
    for (int i = 0; i < queries.length; i++){
        result[i] = -1;
        int payer = queries[i].payer;
        int payee = queries[i].payee;
        Stack stack1 = new Stack(owners.length);
        Stack stack2 = new Stack (owners.length);
        
        if (payer == payee){
            result[i] = payer;
        }
        else{
            if (!graph.isAdjacent(payer)){
                stack1.push(payer);
            }
        
            else{
                while(graph.isAdjacent(payer)){
                    stack1.push(payer);
                    stack1.push(owners[payer]);
                    payer = owners[payer];
                }
            }
             if(!graph.isAdjacent(payee)){
                stack2.push(payee);
            }
            else{
                while(graph.isAdjacent(payee)){
                    stack2.push(payee);
                    stack2.push(owners[payee]);
                    payee = owners[payee];
                    
                }
            }
            
            while(stack1.peek() == stack2.peek()){
                result[i] = stack1.peek();
                if (!stack1.isEmpty()){
                stack1.pop();}
                if (!stack2.isEmpty()){
                stack2.pop();}
            }
        }
        
        
        
    }
    return result;
    
  }

  public class Graph{
      private boolean adjacencyMatrix[][];
      private boolean hasAdjacent[];
      private int vertexCount;
      
      public Graph(int vertexCount){
          this.vertexCount = vertexCount;
          adjacencyMatrix = new boolean[vertexCount][vertexCount];
          hasAdjacent = new boolean[vertexCount];
      
      }
      
      public void addEdge(int from, int to){
          adjacencyMatrix[from][to]= true;
          hasAdjacent[from] = true;
      }
      
      public boolean isAdjacent(int i){
          return hasAdjacent[i];
      }
      
  }
  
  class Stack{
      private int top;
      private int a[];
      private int size;
      
      public Stack(int size){
          this.size = size;
          a = new int[size];
          top = -1;
      }
      
      public boolean isEmpty(){
          return top == -1;
      }
      
      public boolean push(int x){
          if (top >= (size -1)){
              return false;
          }
          else {
              a[++top] = x;
              return true;
          }
      }
      
      public int pop(){
          if (top == -1){
              return -1;
          }
          else{
              return a[top--];
          }
      }
      public int peek(){
          if (top == -1){
              return -1;
          }
          else {
              return a[top];
          }
      }
      
  }
  
