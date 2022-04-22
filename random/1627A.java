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
                int[] inp=string_to_array(in.nextLine().split(" "));
				int n=inp[0];
				int m=inp[1];
				int r=inp[2];
				int c=inp[3];
				char[][] arr=new char[n][m];
				for(int i=0;i<n;i++){
					arr[i]=in.nextLine().toCharArray();
					
				}
				boolean isgot=false;
				for(int i=0;i<n;i++){
					for(int j=0;j<m;j++){
						if(arr[i][j]=='B'){
							isgot=true;
							break;
						}
					}
				}
				if(!isgot){
					out.println(-1);
				}
				else if(arr[r-1][c-1]=='B'){
					out.println(0);
				}else{
					isgot=false;
					for(int i=0;i<m;i++){
						if(arr[r-1][i]=='B'){
							isgot=true;
							break;
						}
					}
					if(!isgot){
						for(int i=0;i<n;i++){
							if(arr[i][c-1]=='B'){
								isgot=true;
								break;
							}
						}
					}
					if(isgot){
						out.println(1);
					}else{
						out.println(2);
					}
				}
				//Shading sc=new Shading(r,c,n,m,arr);
				//int ans=sc.dfs(0,r, c);
				//out.println(ans);
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
class Shading{
	int r;int c;int n;int m;
	char[][] arr;
	int[][] dir={{-1,0},{0,-1},{1,0},{0,-1}};
	Shading(int r,int c,int n,int m,char[][] arr){
		this.r=r;
		this.c=c;
		this.n=n;
		this.m=m;
		this.arr=arr;
	}

}
