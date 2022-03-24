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
				int[] inp=string_to_array(in.nextLine().split(" "));
				int n,b,x,y;
				n=inp[0];
				b=inp[1];
				x=inp[2];
				y=inp[3];
				int[] a=new int[n+1];
				a[0]=0;
				for(int i=1;i<n+1;i++){
					boolean aa=a[i-1]+x<=b;
					boolean bb=a[i-1]-y<=b;
					if(aa && bb){
						a[i]=Math.max(a[i-1]+x,a[i-1]-y);
						continue;
					}else if(aa){
						a[i]=a[i-1]+x;
						continue;
						
					}else if(bb){
						a[i]=a[i-1]-y;
						continue;
					}
				}
				double sum=0;
				for(int i=0;i<n+1;i++){
					//out.println(a[i]);
					sum+=a[i];
				}
				//out.println(sum);
				System.out.printf("%.0f\n",sum);
				//answer.add(Integer.parseInt(sum));
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

