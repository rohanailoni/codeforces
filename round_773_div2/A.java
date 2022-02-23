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
	static double distance(int x1,int x2,int y1,int y2){
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            List<String>answer=new ArrayList<>();
            while(testCases-- > 0){
                // write code here
				int[][] arr=new int[3][2];
				for(int i=0;i<3;i++){	
					int[] temp=string_to_array(in.nextLine().split(" "));
					arr[i]=temp;
				}
				int a,b,c;
				try{
				a=(arr[0][1]-arr[1][1]);
				}catch(ArithmeticException e){
					a=-1;
				}
				try{
				b=(arr[1][1]-arr[2][1]);
				}catch(ArithmeticException e){
					b=-1;
				}
				try{
				c=(arr[2][1]-arr[0][1]);
				}catch(ArithmeticException e){
					c=-1;
				}
				//out.println(a+" "+b+" "+c);
				double ans=0;
				if(a==0 && (arr[0][1]!=0 || arr[1][1]!=0)){
					ans+=distance(arr[0][0], arr[1][0], arr[0][1], arr[1][1]);
				}if(b==0 &&(arr[1][1]!=0 || arr[2][1]!=0)){
					ans+=distance(arr[1][0], arr[2][0], arr[1][1], arr[2][1]);
				}if(c==0 && (arr[2][1]!=0 || arr[0][1]!=0)){
					ans+=distance(arr[2][0], arr[0][0], arr[2][1], arr[0][1]);
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

