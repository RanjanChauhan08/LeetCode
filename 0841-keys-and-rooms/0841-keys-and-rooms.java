class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        int sum=((n)*(n-1))/2;
        Queue<Integer>queue=new LinkedList<>();
        queue.add(0);
        int cur=0;
        Set<Integer>set=new HashSet<>();
        while(!queue.isEmpty()){
            int num=queue.poll();
            if(!set.contains(num)){
                set.add(num);
                cur=cur+num;
                if(cur==sum)return true;
            }
            for(int i=0;i<rooms.get(num).size();i++){
                int newNum=rooms.get(num).get(i);
                if(set.contains(newNum))continue;
                queue.add(newNum);
            }
        }
        return false;
    }
}