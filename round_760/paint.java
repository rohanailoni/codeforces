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
   static int ecluid(int a,int b){
	   if(b==0){
		   return a;
	   }else{
		   return ecluid(b,a%b);
	   }
   }
   static int gcdof(List<Integer>arr,int idx){
	   if(idx==arr.size()-1){
		  return arr.get(idx);
	   }
	   int a=arr.get(idx);
	   int b=gcdof(arr,idx+1);
	   return ecluid(a,b);
   }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){
				int n=Integer.parseInt(in.nextLine());
				int[] arr=string_to_array(in.nextLine().split(" "));
				int v1=0;
				int v2=0;
				for(int i=0;i<n;i+=2)v1=ecluid(v1,arr[i]);
				for(int i=1;i<n;i+=2)v2=ecluid(v2,arr[i]);
				boolean ok=true;
				for(int i=0;i<n;i+=2){
					if(arr[i]%v2==0){
						ok=false;
						break;

					}
				}
				if(ok){
					out.println(v2);
					continue;
				}
				ok=true;
				for(int i=1;i<n;i+=2){
					if(arr[i]%v1==0){
						ok=false;
						break;
					}
				}
				if(ok){
					out.println(v1);
					continue;
				}
				else{
					out.println(0);
				}

            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
			return;
        }
    }
}

