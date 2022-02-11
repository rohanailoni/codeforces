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
				int a=in.nextInt();
				int s=in.nextInt();
				String a_ss=Integer.toString(a);
				String s_ss=Integer.toString(s);
				int i=a_ss.length()-1;
				int j=s_ss.length()-1;
				String ans="";
				while(i>=0 && j>=0){
					if(Integer.parseInt(a_ss.substring(i,i+1))>=Integer.parseInt(s_ss.substring(j,j+1))){
						j--;
						int n=Integer.parseInt(s_ss.substring(j,j+2))-Integer.parseInt(a_ss.substring(i,i+1));
						if(n<10){
							ans+=Integer.toString(n);
						}else{
							break;
						}
					    out.println(ans+" "+n);
						i--;
						j--;

					}else{
						int n=Integer.parseInt(s_ss.substring(j,j+1))-Integer.parseInt(a_ss.substring(i,i+1));
						ans+=Integer.toString(n);
						i--;
						j--;


					out.println(ans+" "+n);
					}
				}
				//out.println(i+" "+j);
				if(i!=-1 || j!=-1){
					out.println(-1);
					continue;
				}
				char[] s1=ans.toCharArray();
				i=0;
				j=ans.length()-1;
				while(i<j){
					char temp=s1[j];
					s1[j]=s1[i];
					s1[i]=temp;
					i++;
					j--;

				}
				out.println(Integer.parseInt(String.valueOf(s1)));
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

