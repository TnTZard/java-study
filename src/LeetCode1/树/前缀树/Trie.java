package LeetCode1.树.前缀树;

/**
 * @Author: anzhi
 * @Date: 2021/4/14 9:28
 */
public class Trie {

    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("bb");
        System.out.println(trie.search("a"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("bb"));
        System.out.println(trie.startsWith("a"));
        System.out.println(trie.search("bb"));
    }






}
