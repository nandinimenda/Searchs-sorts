import java.util.*;
class bubblesort
{
  static void bs(int arr[])
  {
    int n=arr.length;
    int temp=0;
    for(int i=0;i<n;i++)
    {
      for(int j=1;j<(n-i);j++)
      {
        if(arr[j-1]>arr[j])
        {
          temp=arr[j-1];
          arr[j-1]=arr[j];
          arr[j]=temp;
        }
      }
    }
  }
  public static void main(String[]args)
  {
    int arr[]=new int[5];
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter array size");
    int n=sc.nextInt();
    System.out.println("elements");
    for(int i=0;i<n;i++)
    {
      arr[i]=sc.nextInt();
    }
    System.out.println("before sort");
    for(int i=0;i<arr.length;i++)
    {
      System.out.println(arr[i] + "");
    }
    System.out.println();
    bs(arr);
    System.out.println("After sort");
    for(int i=0;i<arr.length;i++)
    {
      System.out.println(arr[i]+" ");
    }
  }
}
