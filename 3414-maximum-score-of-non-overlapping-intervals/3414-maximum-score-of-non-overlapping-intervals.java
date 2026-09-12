class Solution {
    static class Interval {
        int s,e,w,idx;
        Interval(int s,int e,int w,int idx) {
            this.s=s;
            this.e=e;
            this.w=w;
            this.idx=idx;
        }
    }
    static class State {
        long score;
        List<Integer> list;
        State(long score,List<Integer> list) {
            this.score=score;
            this.list=list;
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n=intervals.size();
        List<Interval> arr=new ArrayList<>();
        for(int i=0;i<n;i++)
            arr.add(new Interval(intervals.get(i).get(0),intervals.get(i).get(1),intervals.get(i).get(2),i));
        arr.sort((a,b)->{
            if(a.s!=b.s) return Integer.compare(a.s,b.s);
            if(a.e!=b.e) return Integer.compare(a.e,b.e);
            return Integer.compare(a.idx,b.idx);
        });
        State[][] dp=new State[n+1][5];
        for(int i=0;i<=n;i++)
            dp[i][0]=new State(0,new ArrayList<>());
        for(int k=1;k<=4;k++)
            dp[n][k]=new State(0,new ArrayList<>());
        for(int i=n-1;i>=0;i--) {
            for(int k=1;k<=4;k++) {
                State skip=dp[i+1][k];
                int next=findNext(arr,i+1,arr.get(i).e);
                State ns=dp[next][k-1];
                List<Integer> list=new ArrayList<>(ns.list);
                list.add(arr.get(i).idx);
                Collections.sort(list);
                State take=new State(arr.get(i).w+ns.score,list);
                dp[i][k]=better(take,skip);
            }
        }
        List<Integer> ans=dp[0][4].list;
        int[] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            res[i]=ans.get(i);
        return res;
    }
    private int findNext(List<Interval> arr,int l,int end) {
        int r=arr.size();
        while(l<r) {
            int m=l+(r-l)/2;
            if(arr.get(m).s>end)
                r=m;
            else
                l=m+1;
        }
        return l;
    }
    private State better(State a,State b) {
        if(a.score!=b.score)
            return a.score>b.score?a:b;
        for(int i=0;i<Math.min(a.list.size(),b.list.size());i++) {
            if(!a.list.get(i).equals(b.list.get(i)))
                return a.list.get(i)<b.list.get(i)?a:b;
        }
        return a.list.size()<=b.list.size()?a:b;
    }
}