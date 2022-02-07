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
                    e.printStackTrace(); } }
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
			Solution ans=new Solution();
            List<String>answer=new ArrayList<>();
            while(testCases-- > 0){
               int[] constr= ans.string_to_array(in.nextLine().split(" "));
			   int n=constr[0];
			   int x=constr[1];
			   int y=constr[2];
			   int[] arr=ans.string_to_array(in.nextLine().split(" "));
				sol soll=new sol(arr,y,x);
				if(soll.dfs(0,x)){
					out.println("Alice");
				}else{
					out.println("Bob");
				}

            }
            for(String s:answer){
				out.println(s);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}

class sol{
	int[] arr;
	int dest;
	int ele;
	sol(int[] arr,int d,int ele){
		this.arr=arr;
		this.dest=d;
		this.ele=ele;
	}
	
	public boolean dfs(int pos,int number){
		if(number==dest && ){
			return true;
		}
		if(pos>arr.length){
			return false;
		}
		int n=number+arr[pos];
		if(dfs(pos+1,number+arr[pos]) || dfs(pos+1,number^arr[pos]))
		{
			return true;
		}else{
			return false;
		}
			

	}
}
