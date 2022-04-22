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
				String[] arr=new String[n];
				for(int i=0;i<n;i++){
					arr[i]=in.nextLine();
				}
				//out.println(Arrays.toString(arr));
				long ans=0;
				HashMap<String,Integer>map=new HashMap<>();
				for(int i=0;i<n;i++){
					map.put(arr[i],map.getOrDefault(arr[i],0)+1);
				}
				//out.println(map);
				for(int i=0;i<n;i++){
					//first char;
					char c=arr[i].charAt(0);
					for(int j=c-'a'+1;j<26;j++){
						char jj=(char)(j+'a');
						String cc=jj+Character.toString(arr[i].charAt(1));
						//System.out.println(cc);
						if(map.containsKey(cc)){
							ans+=map.get(cc);
						}
					}
					//for second char;
					c=arr[i].charAt(1);
					for(int j=c-'a'+1;j<26;j++){
						char jj=(char)(j+'a');
						String cc=Character.toString(arr[i].charAt(0))+jj;
						if(map.containsKey(cc)){
							ans+=map.get(cc);
						}
					}
					//break;
				}
				out.println(ans);
					
			}
            out.close();
        } catch (Exception e) {
           System.out.println(e); 
			return;

        }
    }
}

