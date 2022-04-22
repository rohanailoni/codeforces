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
                // write code here
				int n=in.nextInt();
				int[] p=new int[n+5];
				int[] d=new int[n+5];
				for(int i=0;i<n;i++){
					p[i]=in.nextInt();
					d[i]=p[i];
				}
				Queue<Integer>odd=new LinkedList<>();
				for(int i=1;i<n-1;i++){
					if(p[i]%2!=0)odd.add(i);
				}
				if(n==3){
					if(p[1]%2==1){
						out.println(-1);
					}else{
						out.println(p[1]/2);
					}
				}else{
					int k=1;
					while(k<n-1 && p[k]==1)k++;
					out.println(k);
					if(k==n-1){
						out.println(-1);
					}else{

					    int ans=0;
						for(int i=1;i<n-1;i++){
							ans+=(p[i]+1)/2;
						}
						out.println(ans);
					}
					
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


