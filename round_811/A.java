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
				int[] arr=string_to_array(in.nextLine().split(" "));
				int nn=arr[0];
				int H=arr[1];
				int M=arr[2];
				List<node>temp=new ArrayList<>();
				for(int i=0;i<n;i++){
					temp.add(new node(Integer.parseInt(in.nextLine()),Integer.parseInt(in.nextLine())));
					temp.get(i).xx=temp.get(i).h*60+temp.get(i).m

				}	
				int tur=H*60+M;
				int min=Integer.MIN_VALUE;
				for(int i=0;i<n;i++){
					int tt=temp.get(i).xx-tur;
					if(tt<0){
						min=Math.min(min,Math.abs(tt)+24*60);
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
class node{
	int h;
	int m;
	int xx;
	node(int h,int m){
		this.h=h;
		this.m=m;
	}
}
