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
				int[] arr=string_to_array(in.nextLine().split(" "));
				HashMap<Integer,List<Integer>>map=new HashMap<>();
				for(int i=0;i<n;i++){
					if(map.containsKey(arr[i])==false){
						List<Integer>temp=new ArrayList<>();
						temp.add(i);
						map.put(arr[i],temp);
					}else{
						List<Integer>temp=map.get(arr[i]);
						temp.add(i);
						map.put(arr[i],temp);
					}
				}
				int[] ans=new int[n];
				for(Map.Entry<Integer,List<Integer>>mm:map.entrySet()){
					List<Integer>temp=mm.getValue();
					int a=0;
					for(int i=0;i<temp.size()-1;i++){
						if(((temp.get(i+1)-temp.get(i))+1)%2==0){
							a++;	
						}
					}
					ans[mm.getKey()-1]=++a;
				}
				// System.out.println(Arrays.toString(ans)+" "+map);
				for(int i:ans){
					System.out.print(i+" ");
				}
				System.out.println();
					
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

