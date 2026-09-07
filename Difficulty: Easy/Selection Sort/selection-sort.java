class Solution {
    void selectionSort(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int j=i;
            for(int k=i+1;k<n;k++){
                if(arr[k]<arr[j]){
                    j=k;
                }
            }
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
}