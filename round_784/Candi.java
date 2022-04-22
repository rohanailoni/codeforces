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
				int[] up=new int[n];
				int[] down=new int[n];
				up[0]=arr[0];
				for(int i=1;i<n;i++){
					up[i]=arr[i]+up[i-1];
				}
				down[n-1]=arr[n-1];
				for(int i=n-2;i>=0;i--){
					down[i]=down[i+1]+arr[i];
				}
				//System.out.println(Arrays.toString(up));
				//System.out.println(Arrays.toString(down));
				int i=0;
				int j=n-1;
				int ans=0;
				while(i<j){
					if(up[i]==down[j]){
						ans=(n-j)+(i+1);
						i++;
						j--;
						//out.println(i+" "+j);

					}
					if(up[i]>down[j]){
						j--;
					}else if(up[i]<down[j]){
						i++;
					}
					//out.println(i+" "+j);
				}
				out.println(ans);
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

