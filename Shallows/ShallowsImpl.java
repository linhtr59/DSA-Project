// Full Name (StudentNum), Full Name (StudentNum)
//Linh Trinh (23234683), Thai Hoang Long Nguyen(23147438)

/**
 * An implementation of the Shallows problem from the 2022 CITS2200 Project
 */
import java.util.*;

public class ShallowsImpl implements Shallows {
    
  public int[] maximumDraughts(int ports, Lane[] lanes, int origin) {
    // TODO: Implement your solution 
      int[] seen = new int[ports];
      int [] d = new int[ports];

      PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
      pq.add(new Edge(origin,Integer.MAX_VALUE));
      d[origin] = Integer.MAX_VALUE;
  
      while (!pq.isEmpty()) {
          Edge e = pq.poll(); // origin vertex
          int vertex = e.vertex;
          if (seen[vertex] != 0) {
              continue;
          }
          seen[vertex] = 1; //set vertex just dequeued to visited
          for (int i =0; i < lanes.length; i++) {
              Lane l = lanes[i];
              int depth = l.depth;
              if (l.depart == vertex & seen[l.arrive] != 1) { // if vertex is connected to current vertex and has not been vistied before
                  if(l.depart == origin) { //special case inspecting vertex connected to source node
                      if(depth > d[l.arrive]) {
                          d[l.arrive] = depth;
                          pq.add(new Edge(l.arrive, d[l.arrive]));
                      }
                  }
                  
                  else {//vertex from none source node
                      if(d[l.depart] > d[l.arrive] && l.depth > d[l.arrive])  {
                          if(d[l.depart] <= depth) {
                              d[l.arrive] = d[l.depart];
                              pq.add(new Edge(l.arrive, d[l.arrive]));
                              }
                          else {
                              d[l.arrive] = depth;
                              pq.add(new Edge(l.arrive, d[l.arrive]));
                              }
                  }
                  }  
              }
          }
      }
      
      return d;

    }
  
  class Edge implements Comparable<Edge>{
      int vertex;
      private int depth;
  public Edge(int v, int depth){
        vertex = v;
        this.depth =  depth;
        
    }
    public int compareTo(Edge current){
            int currentd = current.depth;
            if(depth < currentd){
                return 1;
            } else if(depth > currentd){
                return -1;
            } else {
                return 0;
            }
        }
  }
  
  
}
