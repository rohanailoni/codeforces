import java.util.*;
import java.io.*;
import java.lang.*;
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
                int[] arr=string_to_array(in.nextLine().split(" "));
				int n=arr[0];
				int k=arr[1];
				List<obj>put=new ArrayList<>();
				int[] a=string_to_array(in.nextLine().split(" "));
				int[] b=string_to_array(in.nextLine().split(" "));
				for(int i=0;i<n;i++){
					put.add(new obj(a[i], b[i]));
				}
				Collections.sort(put,(obj o1,obj o2)->o1.want-o2.want);
				for(obj j:put){
					if(j.want<=k){
						k+=j.gives;
					}
				}
				out.println(k);

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
class obj{
	int want;
	int gives;
	obj(int w,int g){
		want=w;
		gives=g;
	}
}
class Sorting implements Comparator<obj>{
	@Override
	public int compare(obj o1,obj o2){
		return o1.want-o2.want;
	}
}

