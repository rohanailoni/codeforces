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
				int[] arr=string_to_array(in.nextLine().split(" "));
				int n=arr[0];
				int m=arr[1];
				arr=string_to_array(in.nextLine().split(" "));
				int[] forw=new int[n];
				int[] back=new int[n];
				forw[n-1]=-1;
				back[0]=-1;
				for(int i=0;i<n-1;i++){
					if(forw[i+1]<forw[i]){
						forw[i]=Math.abs(forw[i+1]-forw[i]);
					}
				}
				for(int i=n;i>0;i--){
					if(back==new_war){
						if(arr_war)
					}
				}

				for(int i=0;i<m;i++){
					int[] temp=string_to_array(in.nextLine().split(" "));
					int s=temp[0];
					int t=temp[1];

						int sum=0;
					if(s>t){
						for(int al=s-1;al>t-1;al--){
							if(arr[al-1]<arr[al]){
								sum+=Math.abs(arr[al-1]-arr[al]);
							}
						}

					}else{
						for(int al=s-1;al<t-1;al++){
							if(arr[al+1]<arr[al]){
								sum+=Math.abs(arr[al+1]-arr[al]);
							}
						}
					}	
					out.println(sum);
				}	
					
            out.close();
        } catch (Exception e) {
			System.out.println(e);
            return;
        }
    }
}

