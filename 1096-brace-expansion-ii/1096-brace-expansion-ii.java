class Solution {
    int i=0;
    public List<String> braceExpansionII(String expression) {
        return new ArrayList<>(solve(expression));
    }
    Set<String> solve(String s) {
        Set<String> res=new TreeSet<>();
        Set<String> cur=new TreeSet<>();
        cur.add("");
        while(i<s.length()&&s.charAt(i)!='}'){
            if(s.charAt(i)==','){
                res.addAll(cur);
                cur.clear();
                cur.add("");
                i++;
            }else{
                Set<String> next=new TreeSet<>();
                if(s.charAt(i)=='{'){
                    i++;
                    next=solve(s);
                    i++;
                }else{
                    next.add(String.valueOf(s.charAt(i++)));
                }
                Set<String> temp=new TreeSet<>();
                for(String a:cur) for(String b:next) temp.add(a+b);
                cur=temp;
            }
        }
        res.addAll(cur);
        return res;
    }
}