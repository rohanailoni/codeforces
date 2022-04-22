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
	public static double distance(int x1,int x2){
		return Math.sqrt(x1*x1+x2*x2);
	}
	
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            List<String>answer=new ArrayList<>();
            while(testCases-- > 0){
				int n=Integer.parseInt(in.nextLine());
				String s=in.nextLine();
				int oper=0;
				int poin=0;
				//out.println(palind("()"));	
				String temp="";
				for(int i=0;i<n;i++){
					temp+=s.charAt(i);
					int temp_len=temp.length();
					if(temp.equals("()") || temp.equals("((") || temp.equals("))")){
						poin+=2;
						oper+=1;
						temp="";

					}
					else if(temp_len>1){
						if(s.charAt(i)==')'){
							poin+=temp_len;
							oper+=1;
							temp="";
						}
					}
				}
				out.println(oper+" "+(n-poin));
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

