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
            while(testCases-- > 0){
				int n=Integer.parseInt(in.nextLine());
				int[] spending=string_to_array(in.nextLine().split(" "));
				int[] budget=string_to_array(in.nextLine().split(" "));
				ArrayList<pair>p=new ArrayList<>();
				for(int i=0;i<n;i++){
					pair temp=new pair(spending[i],budget[i]);
					p.add(temp);
				}
				Collections.sort(p,(pair a1,pair a2)->a2.s-a1.s);
				int poi=0;
				int curr_bud=0;
				int curr_spe=0;
				while(poi<n){

					if(curr_bud>=curr_spe){

					}
				}
					
			}
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}

class pair{
	int s;
	int b;
	pair(int s,int b){
		this.s=s;
		this.b=b;

	}
}
