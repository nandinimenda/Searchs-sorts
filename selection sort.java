class Selection
{
  public static void SelectionSort(int arr[])
  {
    int n = arr.length;
    for(int i=0;i<n-1;i++)
    {
      int min_idx = i;
      for(int j=i+1;j<n;j++)
      {
        if(arr[j] < arr[min_idx])
        {
          min_idx = j;
        }
      }
      int temp = arr[min_idx];
      arr[min_idx] = arr[i];
      arr[i] = temp;
    }
  }
  public static void main(String[]args)
  {
    int arr[] = {25,45,87,34,88};
    System.out.println("Unsorted Array");
    for(int i=0;i<arr.length;i++)
    {
      System.out.println(arr[i]+" ");
    }
    System.out.println();
    SelectionSort(arr);
    System.out.println("Sorted Array");
    for(int i=0;i<arr.length;i++)
    {
      System.out.println(arr[i]+" ");
    }
  }
}
