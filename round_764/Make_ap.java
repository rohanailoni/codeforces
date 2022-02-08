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
				int[] arr=string_to_array(in.nextLine().split(" "));
				int a=arr[0];
				int b=arr[1];
				int c=arr[2];
				int d=(2*b-c)%a;
				int e=(a+c)%(2*b);
				int f=(2*b-a)%c;
                int g=(2*b-c);
                int h=(a+c);
                int i=(2*b-a);
                // System.out.println(d+" "+g);
                // System.out.println(e+" "+h);
                // System.out.println(f+" "+i);
				if(d==0 && g>0){
					answer.add("YES");
				}else if(e==0 && h>0){
					answer.add("YES");
				}else if(f==0 && i>0){
					answer.add("YES");
				}else{
					answer.add("NO");
				}
            }
            for(String s:answer){
				out.println(s);
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
			return;
        }
    }
}

