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
    
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
			List<storage>answer=new ArrayList<>();
            while(testCases-- > 0){
                // write code here
				Okea ok=new Okea();
				int curr=0;
				int[] arr=ok.string_to_array(in.nextLine().split(" "));
				//int[][] ans=new int[arr[0]+1][arr[1]+1];
				
				int k=arr[1];
				int n=arr[0];
				if(k==1){
					int c=0;
					int[][] ans=new int[n][k];
					for(int i=0;i<n;i++){
						
						c++;
						
						ans[i][0]=c;
						//System.out.print(ans[i][0]);
					}

					answer.add(new storage("YES",ans));
				
				}
				else if(n%2!=0){
					answer.add(new storage("NO",new int[1][1]));
				}else{
					int count=0;
					int[][] ans=new int[n][k];
					for(int i=0;i<k;i++){
						for(int j=0;j<n;j++){
							ans[j][i]=++count;
						}
					}
					answer.add(new storage("YES",ans));
				}
			}
			for(storage s:answer){
				if(s.res=="NO"){
					out.println("NO");
					continue;
				}else{
					out.println("YES");
					//out.println(s.ans.length+" "+s.ans[0].length);
					for(int i=0;i<s.ans.length;i++){
						for(int j=0;j<s.ans[0].length;j++){

							out.print(s.ans[i][j]+" ");
						}
						out.print("\n");
					}
				}
			}
            out.close();
        } catch (Exception e) {
			e.printStackTrace(System.out);	
        }
    }
}
class Okea{
	 int[] string_to_array(String[] arr){
        int[] ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i]=Integer.parseInt(arr[i]);
        }
        return ans;
	}
}
class storage{
	String res;
	int[][] ans;
	storage(String res,int[][] ans){
		this.res=res;
		this.ans=ans;
	}
}
