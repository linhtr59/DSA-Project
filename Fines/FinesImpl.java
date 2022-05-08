// Full Name (StudentNum), Full Name (StudentNum)

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
  }
  
  private void merge(int[] priorities, int left, int middle, int right) {
	  int n = middle - left +1;
	  int m = right - middle;
	  int[] first = new int[n];
	  int[] second = new int[m];
	  for (int i =0; i <n; i++) {
		  first[i] = priorities[left+1];
		  
	  }
	  
	  for (int i =0; i< m; i++) {
		  second[i] = priorities[middle+1+i];
	  }
	  
	  int j = 0;
	  int i = 0;
	  for (int k = left; k< right; k++) {
		  if (i == n) {
			  priorities[k] = second[j++];
		  }
		  else if(j ==m || first[i] < second[j]) {
			  priorities[k] = first[i++];
		  }
		  else {
			  priorities[k] = second[j++];
			  
		  }
	  }  
  }
  
  private void mergeSort(int[] priorities, int left, int right) {
	  if (right>left) {
		  int mid = (left+right)/2;
		  mergeSort
	  }
  }
}