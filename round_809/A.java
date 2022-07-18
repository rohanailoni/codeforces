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
				int[] arr=string_to_array(in.nextLine().split(" "));
				int n=arr[0];
				int m=arr[1];
				arr=string_to_array(in.nextLine().split(" "));
				int[] rev=new int[n];
				for(int i=0;i<n;i++){
					rev[i]=m+1-arr[i];
				}
				int j=0;
				Character[] bb=new Character[m];
				for(int i=0;i<m;i++){
					bb[i]='B';
				}	

				for(int i=0;i<n;i++){
					if(arr[i]>rev[i]){
						if(bb[rev[i]-1]=='A'){
							bb[arr[i]-1]='A';
						}else{
							bb[rev[i]-1]='A';
						}
					}else if(arr[i]<rev[i]){
						if(bb[arr[i]-1]=='A'){
							bb[rev[i]-1]='A';
						}else{
							bb[arr[i]-1]='A';
						}
					}else{
						bb[arr[i]-1]='A';
					}
				}
				String ans="";
				for(char c:bb){
					ans+=c;
				}
				System.out.println(ans);
					
			}
            out.close();
        } catch (Exception e) {
			System.out.println(e);
            return;
        }
    }
}

