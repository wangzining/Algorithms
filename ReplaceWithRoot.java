package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * This program replaces a sentence with root word using the structure of Trie
 */

public class ReplaceWithRoot {
	 public static String replaceWords(List<String> dict, String sentence) {
	        Trie t = new Trie();
		for(int i=0;i<dict.size();i++){
			t.add(dict.get(i));
		}
		String[] a = sentence.split("\\s+");
		System.out.println(Arrays.toString(a));
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<a.length;i++){
			a[i] = a[i].toLowerCase();
			a[i] = t.contains(a[i]);
		    sb.append(a[i]);
		    if(i<a.length-1) sb.append(" ");
		}
		return sb.toString();
	    }
	 
	 	public static void main(String[] args){
	 		//test here
	 		List <String> l = new ArrayList<String>();
	 		l.add("dog");
	 		l.add("cat");
	 		String s = "I saw a dogs and a cats";
	 		System.out.println(replaceWords(l,s));
	 	}
}

class Trie{
	Node root = new Node();
	public void add(String s){
		Node cur  = root;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(cur.children[c-'a']==null){
				cur.children[c-'a'] = new Node();
			}
			cur = cur.children[c-'a'];
		}
		cur.isWord = true;
	}

	public String contains(String s){
		Node cur = root;
        StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++){
            if(cur.isWord){
                return sb.toString();
            }
			char c = s.charAt(i);
			if(cur==null||cur.children[c-'a']==null){
				return s;
			}
            sb.append(c);
			cur = cur.children[c-'a'];
		}
        return cur.isWord?sb.toString():s;
	}

}

class Node{
	public Node[] children = new Node[26];
	public boolean isWord;
}

