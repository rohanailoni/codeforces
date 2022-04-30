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
				String q=in.nextLine();
				int n=q.length();
				char arr[]=q.toCharArray();
				int al=0;
				int bob=0;
				if(n%2==0){
					for(char c:arr){
						al+=c-'a'+1;
					}
					out.println("Alice "+al);
					continue;
				}
				if(n==1){
					for(char c:arr){
						bob+=c-'a'+1;
					}
					out.println("Bob "+bob);
				}else{
					if(arr[0]>arr[n-1]){
						for(int i=0;i<n-1;i++){
							
							al+=arr[i]-'a'+1;
						}
						int rem=al-(arr[n-1]-'a'+1);
						out.println("Alice "+rem);
					}else{
						for(int i=1;i<n;i++){
							al+=arr[i]-'a'+1;
						}
						int rem=al-(arr[0]-'a'+1);
						out.println("Alice "+rem);
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

