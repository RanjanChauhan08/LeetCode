class Solution {
    public void bubbleSort(int[] arr) {
        int n=arr.length;
        outerloop:
        for(int i=0;i<n-1;i++){
            boolean bt=false;
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    bt=true;
                }
            }
            if(!bt)break outerloop;
        }
    }
}