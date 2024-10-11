class Solution {

    class TrieNode 
    {
        TrieNode[] children;
        int count;

        TrieNode()
        {
            children = new TrieNode[26];
            count =0;
        }
    }

    TrieNode root;


    private void insert(String s)
    {
        TrieNode node = root;
        for(char c:s.toCharArray())
        {
            if(node.children[c-'a']==null)
            {
                node.children[c-'a'] = new TrieNode();
            }
             node = node.children[c-'a'];
             node.count+=1;
        }
    }


    private int getSumScore(String s)
    {
          int count =0;
          TrieNode node = root;
        for(char c:s.toCharArray())
        {
             node = node.children[c-'a'];
             count+=node.count;
        }
        return count;
    }


    public int[] sumPrefixScores(String[] words) {
        root = new TrieNode();

        for(String s:words)
        {
            insert(s);
        }
        int ans[] = new int[words.length];
        for(int i=0; i<words.length;i++)
        {
            ans[i] = getSumScore(words[i]);
        }
        return ans;
    }
}