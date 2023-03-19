class WordDictionary {
    class TrieNode {
    boolean eof;
    TrieNode[] children;
    
    public TrieNode() {
        eof = false; // when the word is complete (mark that node as true)
        children = new TrieNode[26]; // for 26 possible Childrens (for next letter)
    }
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.eof = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        return helper(0, curr, word.toCharArray());
    }
    public boolean helper(int index, TrieNode curr, char[] wordArray){
        if(index == wordArray.length) return curr.eof;
        if(wordArray[index] != '.'){
            int newIndex = wordArray[index] - 'a';
            TrieNode node = curr.children[newIndex];
            return (node != null && helper(index + 1, node, wordArray));
        }else{
            for(int i = 0; i < curr.children.length; i++){
                TrieNode node = curr.children[i];
                if(node != null){
                    if(helper(index + 1, node, wordArray)) return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */