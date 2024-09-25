class Solution {
  	class Trie{
		Trie child[];
		int count;
        public Trie(){
            child=new Trie[26];
            count=0;
        }
	}
	
	Trie root;
    public  int[] sumPrefixScores(String[] arr) {
    	root=new Trie();
    	int n=arr.length;
    	Trie curr=root;
    	int ans[]=new int[n];
    	for(String word: arr) {
    		curr=root;
    		for(char ch:word.toCharArray()) {
    			if(curr.child[ch-'a']==null) {
    				curr.child[ch-'a']=new Trie();    				
    			}   			
    			curr=curr.child[ch-'a'];    	
                curr.count++;    				
    		}   		
    	}
    	for(int i=0;i<n;i++) {
    		int cnt=0;
    		curr=root;	
    		for(char ch:arr[i].toCharArray()) {
    		     curr=curr.child[ch-'a']; 
                 cnt=cnt+curr.count;	
    		}
    		ans[i]=cnt;   		
    	}      
    	return ans;
    }
}