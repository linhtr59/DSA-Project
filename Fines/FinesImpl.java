// Full Name (StudentNum), Full Name (StudentNum)
//Linh Trinh (23234683), Thai Hoang Long Nguyen(23147438)
/**
 * An implementation of the Fines problem from the 2022 CITS2200 Project
 */
public class FinesImpl implements Fines {
  /**
   * {@inheritdoc}
   */
	private long count;
  public long countFines(int[] priorities) {
    // TODO: Implement your solution
    quickSort(priorities, 0, (priorities.length -1));
	return count;
  }
  
  
  private void quickSort(int[] priorities, int p, int r ) {
	  if (p < r) {
		  int pivot = partition(priorities,p,r);
		  quickSort(priorities, p, pivot);
		  quickSort(priorities, pivot + 1, r);
	  }
  }
  
  
  private int partition(int[] priorities, int p, int r) {
	  //quicksort in descending order
	  int pivot = priorities[p]; // set pivot to be leftmost item
	  int i = p ;
	  for (int j = p + 1; j <= r ; j++) {
		  if (priorities[j] > pivot) { //if priority is greater than pivot and is placed on RHS, increment count
			  count ++;
			  i++;
			  int temp = priorities[i];//reference to current priority
			  priorities[i] = priorities[j];// swap i & j
			  priorities[j] = temp;


		  }

	  }
	  int temp = priorities[i];//swap i & p
	  priorities[i] = priorities[p];
	  priorities[p] = temp;
	  
	  return i;
}
}



/* Insertion sort implementation
	long count = 0; //intialise fine count
	for (int i = 1; i < priorities.length; i++) { //start from second, loop thru array
		int key = priorities[i]; // reference to current priority
		int j = i - 1; // pointer to previous priority
		while (j >= 0 && priorities[j] < key) { //as long as priority is smaller than current
			count ++; //increment count
			priorities[j+1] = priorities[j];
			j--;
		}
		priorities[j+1] = key;
	}
    return count;
  } */
