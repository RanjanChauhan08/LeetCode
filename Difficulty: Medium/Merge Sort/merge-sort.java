class Solution {
    public void merge(int[]arr,int l,int r){
        if(r<=l)return;
        int mid=(l+r)/2;
        merge(arr,l,mid);
        merge(arr,mid+1,r);
        sort(arr,l,mid,r);
    }
    public void sort(int[]arr,int l,int m,int r){
        int[]temp=new int[r-l+1];
        int ind=l;
        int mid=m;
        int mid1=mid+1;
        int x=0;
        while(l<=mid && mid1<=r){
            if(arr[l]<arr[mid1]){
                temp[x++]=arr[l++];
            }
            else{
                temp[x++]=arr[mid1++];
            }
        }
        while(l<=mid){
            temp[x++]=arr[l++];
        }
        while(mid1<=r){
            temp[x++]=arr[mid1++];
        }
        x=0;
        for(int i=0;i<temp.length;i++){
            arr[ind+i]=temp[i];
        }
    }
    public void mergeSort(int arr[], int l, int r) {
        merge(arr,l,r);
    }
}