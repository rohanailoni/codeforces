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
				String s=in.nextLine();
				String c=in.nextLine();
				if(s.length()==1){
					if(s.equals(c)){
						out.println("YES");
					}else{
						out.println("NO");
					}
				}else{
					pq.peek();
					for(int i=0;i<n;i++){
						:
					}
					int n=s.length();
					boolean boo=false;
					for(int i=0;i<n;i++){
						if(s.charAt(i)==c.charAt(0)){
							int up=i;
							int down=n-i-1;
							//out.println(up+" "+down);
							if(up==0 || down==0){
								boo=true;
								break;
							}

							else if(up%2==0 && down%2==0){
								boo=true;
								break;
							}
						}
					}
					if(boo){
						out.println("YES");
					}else{
						out.println("NO");
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

