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
				String s="";
				boolean[] check=new boolean[10];
				while(n>0){
					if(n>=0 && n<=9){
					//ystem.out.println(Arrays.toString(check)+" "+n+" "+s);
						if(check[n]){
							for(int i=n-1;i>=1;i--){
								
								if(check[i]==false){s+=Integer.toString(i);check[i]=true;n-=i;break;}
							}	
						}else{
							s+=n;
							n=0;
						}
					}else{
					for(int i=9;i>=1;i--){
						if(!check[i]){
							s+=Integer.toString(i);
							n-=i;
							check[i]=true;
							break;
							}
						}


					}
				}
				StringBuilder input1 = new StringBuilder();
				input1.append(s);
				input1.reverse();
				System.out.println(input1);

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

