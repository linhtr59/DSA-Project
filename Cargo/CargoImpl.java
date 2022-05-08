// Full Name (StudentNum), Full Name (StudentNum)
//Linh Trinh (23234683), Thai Hoang Long Nguyen(23147438)
/**
 * An implementation of the Cargo problem from the 2022 CITS2200 Project
 */
public class CargoImpl implements Cargo {
  /**
   * {@inheritdoc}
   */
  private int[] mass;
  public int[] departureMasses(int stops, Query[] queries) {
    // TODO: Implement your solution
    for (int i = 0; i < queries.length; i++) {
    	Query q = queries[i];
    	int m;
        if (q.collect < q.deliver) {
        		m += q.cargoMass;
        			mass[i] = m;
        		}
    }
    return mass;
}
}
