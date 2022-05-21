// Full Name (StudentNum), Full Name (StudentNum)
//Linh Trinh (23234683), Thai Hoang Long Nguyen(23147438)
/*
 * An implementation of the Cargo problem from the 2022 CITS2200 Project
 */

public class CargoImpl implements Cargo {
  /**
   * {@inheritdoc}
   */
  public int[] departureMasses(int stops, Query[] queries) {
    // TODO: Implement your solution
      int [] mass = new int[queries.length];
      fenwicktree fwt = new fenwicktree(stops);   
      for (int i =0; i < queries.length; i ++) {
          if (queries[i].collect < queries[i].deliver) {
              fwt.update(queries[i].collect, queries[i].cargoMass);
              mass[i] = fwt.getSum(queries[i].collect);
            }
          else if (queries[i].collect == queries[i].deliver){
             mass[i] = fwt.getSum(queries[i].collect);
            }
          }
      return mass;
  }
  
  
  class fenwicktree{
      private int[] tree;
      public fenwicktree( int n) {
          this.tree = new int[n];
          }

      public void update(int i, int x) {
          while (i < tree.length) {
              tree[i] = tree[i] + x;
              i += i & -i;
          }          
      }
      
   
      public int getSum(int i) { // calculates the prefix sum array from 0 to i
          int sum = 0;
          while (i!= 0){
              sum += tree[i];
              i -= i & -i;
          }
          return sum;
      }
      
      }
    
}

