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
    int[] string_to_array(String[] arr){
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
            //List<String>answer=new ArrayList<>();
            Solution sol=new Solution();
			int n;
			int k;
			while(testCases-- > 0){
                // write code here
				int[] arr=sol.string_to_array(in.nextLine().split(" "));
				n=arr[0];
				k=arr[1];
				String s=in.nextLine();
                solu soll=new solu();

				//soll.dfs(s,k);
				if(k==0){
					out.println(1);;
				}else if(k==1){
					if(soll.isPalindrome(s)==true){
						out.println(1);
					}else{
						out.println(2);
					}
				}else{
					if(soll.isPalindrome(s)){
						out.println(1);
					}else{
						out.println(2);
					}
				}
            }
            
			
            
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
class solu{
	int ans=0;
    //HashSet<String>set=new HashSet<>();
    String reverse(String s){
        StringBuilder sc=new StringBuilder();
        sc.append(s);
        sc.reverse();
        return sc.toString();
    }
    String dfs(String s,int k){
        if(k==0){
            //set.add(s);
            return s;
        }
        k--;
        String s1=dfs(s+reverse(s),k);
        String s2=dfs(reverse(s)+s,k);
		if(k==0 && s1.compareTo(s2)==0){
			ans+=1;
		}else if(k==0 && s1.compareTo(s2)==1){
			ans+=2;
		}
        return s;
    }
	boolean isPalindrome(String str)
    {
 
        int i = 0, j = str.length() - 1;
        while (i < j) {
 
            if (str.charAt(i) != str.charAt(j))
                return false;
 
            i++;
            j--;
        }
 
        return true;
    }


}
