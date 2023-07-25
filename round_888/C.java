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
	static boolean canFormPath(int[] colors, int k) {
        int n = colors.length;
        int blockLen = 0;
        int prevColor = colors[0];

        for (int i = 0; i < n; i++) {
            if (colors[i] != prevColor) {
                if (blockLen % k != 0) {
                    return false;
                }
                blockLen = 1;
                prevColor = colors[i];
            } else {
                blockLen++;
            }
        }

        return blockLen % k == 0;
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            List<String>answer=new ArrayList<>();
            while(testCases-- > 0){
				//int n=Integer.parseInt(in.nextLine());
				int[] arr=string_to_array(in.nextLine().split(" "));
                int n=arr[0];
                int k=arr[1];
                arr=string_to_array(in.nextLine().split(" "));
				long last=n-1;
                long cnt=0;
                for(int i=0;i<n;i++){
                    if(arr[i]==arr[0]){
                        cnt++;
                    }
                    if(cnt==k){
                        last=i;
                        break;
                    }
                }
                if(cnt<k){
                    answer.add("No");
                    continue;
                }else{
                    if(arr[0]==arr[n-1]){
                        answer.add("Yes");
                        continue;
                    }
                }
                cnt=0;
                for(int i=n-1;i>last;i--){
                    if(arr[i]==arr[n-1]){
                        cnt++;
                    }
                }
                if(cnt>=k){
                    answer.add("Yes");
                }else{
                    answer.add("No");
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
