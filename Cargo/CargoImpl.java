// Full Name (StudentNum), Full Name (StudentNum)
//Linh Trinh (23234683), Thai Hoang Long Nguyen(23147438)
/*
 * An implementation of the Cargo problem from the 2022 CITS2200 Project
 */
import java.util.*;

public class CargoImpl implements Cargo {
  /**
   * {@inheritdoc}
   */
  public int[] departureMasses(int stops, Query[] queries) {
    // TODO: Implement your solution
      int [] ports = new int[stops];
      for (int i =0; i < ports.length; i++){
          ports[i] =0;
      }
      
      int [] m1 = new int[queries.length];
      int [] m2 = new int[queries.length];
      int [] m3 = new int[queries.length];

      FenwickTree tree1 = new FenwickTree();
      tree1.addFenTree (ports,stops);
      FenwickTree tree2 = new FenwickTree();
      tree2.addFenTree (ports,stops);

      for (int i =0; i < queries.length; i ++){
          tree1.updateFenwick(stops, queries[i].collect, queries[i].cargoMass);
          m1[i] = tree1.getSum(queries[i].collect);
          tree2.updateFenwick(stops, queries[i].deliver, queries[i].cargoMass);
          m2[i] = tree2.getSum(queries[i].collect);
          m3[i] = m1[i] - m2[i];
       }

       return m3;
    }

    class FenwickTree{
        private static final int max = 9999999;
        private int[] tree = new int[max];

        public int getSum(int i){
            i++;
            int sum = 0;
            while (i > 0){
                sum += tree[i];
                i -= i & (-i);
            }
            return sum;
        }

        public void updateFenwick (int s, int i, int val){
            i ++; 
            while (i <= s){
                tree[i] += val;
                i += i & (-i);
            }
        }

        public void addFenTree(int [] arr, int s){
            for (int i = 0; i < s; i ++){
                tree[i] = 0;
            }
            for (int i = 0; i < s; i ++){
                updateFenwick(s, i, arr[i]);
            }
        }
    }
}
