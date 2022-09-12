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
				String s=in.nextLine();
				int i=n-1;
				String ans="";
				while(i>=0){
					// if(i>=n-2){
					// 	ans+=(char)(s.charAt(i)-'0'+'a'-1);
					// 	i++;
					// }
					// else if(s.charAt(i+2)=='0'){
					// 	ans+=(char)('a'+Integer.parseInt(s.substring(i,i+2))-1);
					// 	i=i+3;
					// }else{
					// 	ans+=(char)(s.charAt(i)-'0'+'a'-1);
						
					// 	i++;
					// }
					if(s.charAt(i)=='0'){
						ans+=(char)('a'+Integer.parseInt(s.substring(i-2,i))-1);
						i=i-3;
					}else{
						ans+=(char)(s.charAt(i)-'0'+'a'-1);
						i--;
					}

					
	
				}
				String rev="";
				for(i=ans.length()-1;i>=0;i--){
					rev+=ans.charAt(i);
				}
					out.println(rev);


			}
            out.close();
        } catch (Exception e) {
			System.out.println(e);
            return;
        }
    }
}


