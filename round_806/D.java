import java.util.*;
import java.io.*;
public class Solution{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
		private final BufferedWriter bw;

		public FastWriter() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(Object object) throws IOException {
			bw.append("" + object);
		}

		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}
    static int[] string_to_array(String[] arr){
        int[] ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i]=Integer.parseInt(arr[i]);
        }
        return ans;
    }
	
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            List<String>answer=new ArrayList<>();
            while(testCases-- > 0){
				int n=Integer.parseInt(in.nextLine());
				String[] arr=new String[n];
				Trie t=new Trie();
				for(int i=0;i<n;i++){
					arr[i]=in.nextLine();
					t.insert(arr[i]);
				}
				
				String ans="";
				// System.out.println(t.search("aba"));
				for(int i=0;i<n;i++){
					int len=arr[i].length();
					boolean flag=false;
					for(int j=1;j<len;j++){
						if(t.check(arr[i],0,j,len)){
							flag=true;
							break;
						}
					}
					if(flag){
						ans+="1";
					}else{
						ans+="0";
					}
					
				}
				out.println(ans);

				
			}
            out.close();
        } catch (Exception e) {
			System.out.println(e);
            return;
        }
    }
}

class TrieNode{
	TrieNode[] children = new TrieNode[26];
	boolean isEndOfWord;
          
        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < 26; i++)
                children[i] = null;
        }
}
class Trie{
	TrieNode root;
	Trie(){
		root=new TrieNode();
	}
	void insert(String key){
		int level;
		int length=key.length();
		int index;
		TrieNode p=root;
		for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (p.children[index] == null)
			{p.children[index] = new TrieNode();}
       
            p = p.children[index];
        }
		p.isEndOfWord=true;

	}
	boolean search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
       
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
       
            if (pCrawl.children[index] == null)
                return false;
       
            pCrawl = pCrawl.children[index];
        }
       
        return (pCrawl.isEndOfWord);
    }
	boolean search1(String a){
		int poi=0;
		TrieNode p=root;
		int s=1;
		while(poi<a.length()){
			int index=a.charAt(poi)-'a';

			if(p.children[index]!=null){
				System.out.println(a.charAt(poi)+" "+p.children[index].isEndOfWord+" "+s+" "+poi);
					p=p.children[index];
				if(p.isEndOfWord && s==1 && poi!=a.length()-1){
					p=root;
					s++;
				}
				else if(p.isEndOfWord && s==2 && poi==a.length()-1){
					return true;
				}
				else{
				}
			}
			poi++;
		}
		return false;
	}
	boolean check(String s,int start,int mid,int end){
		TrieNode p=root;
		int i;
		boolean first=false,second=false;;
		for(i=start;i<mid;i++){
			int index=s.charAt(i)-'a';
			if(p.children[index]!=null){
				p=p.children[index];
			}else{
				return false;
			}
		}
		if(p.isEndOfWord){
			first=true;
		}
		if(i==mid){
			p=root;
		}
		for(i=mid;i<end;i++){
			int index=s.charAt(i)-'a';
			if(p.children[index]!=null){
				p=p.children[index];
			}else{
				return false;
			}
		}
		if(p.isEndOfWord){
			second=true;
		}
		if(first && second){
			return true;
		}
		return false;

	}
}
