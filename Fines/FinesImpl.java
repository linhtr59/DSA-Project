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
      mergeSort(priorities, 0, priorities.length-1);
      return count;
  }
  
  private void merge(int[] priorities, int left, int middle, int right) {
      int[] leftArray = new int[middle - left +1];
      int[] rightArray = new int[right - middle];
      for (int i =0; i < leftArray.length; i++) {
          leftArray[i] = priorities[left+i]; 
      }
      for (int i =0; i<rightArray.length; i++) {
          rightArray[i] = priorities[middle+1+i];
      }
      
      int leftIndex = 0;
      int rightIndex = 0;
      int subIndex = left;
      while( leftIndex < leftArray.length && rightIndex < rightArray.length) { 
          if (leftArray[leftIndex] < rightArray[rightIndex]) { // if first item of left index < first item of right index
              count += leftArray.length - leftIndex;
              priorities[subIndex] = rightArray[rightIndex]; // move to correct position
              rightIndex ++; 
          }
          else {
              priorities[subIndex] = leftArray[leftIndex];
              leftIndex++;
          }
          subIndex++;
      }
      
      while (leftIndex < (middle - left +1)) {
          priorities[subIndex] = leftArray[leftIndex];
          leftIndex++;
          subIndex++;
      }
      
      while (rightIndex < (right - middle)) {
          priorities[subIndex] = rightArray[rightIndex];
          rightIndex++;
          subIndex++;
      }
      
  
  }
  private void mergeSort(int[] priorities, int left, int right) {
      if (right>left) {
          int mid = (left+right)/2;
          mergeSort(priorities, left, mid);
          mergeSort(priorities, mid+1, right);
            merge(priorities, left, mid, right);
      }
  }
}
