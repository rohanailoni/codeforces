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
				cool c=new cool(arr);
				c.dfs(1,0,0);
				c.print();

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
class cool{
	int[] build;
	int[] rem;
	int n;
	HashMap<Integer,Integer>map;
	cool(int[] b){
		this.build=b;
		rem=new int[b.length];
		Arrays.fill(rem,-1);
		for(int i=1;i<b.length-1;i++){
			rem[i]=b[i]>Math.max(b[i-1], b[i+1])?0:Math.abs(b[i]-Math.max(b[i-1],b[i+1]))+1;
		}
		n=b.length;
		map=new HashMap<>();
		System.out.println(Arrays.toString(rem));
	}
	public int dfs(int index,int depth,int brick){
		if(index>=build.length-1){
			System.out.println(map+" "+depth+" "+brick);
			if(map.containsKey(depth)){
				map.put(depth,Math.min(map.get(depth),brick));
				return 0;
			}
			map.put(depth,brick);
			return 0;
		}

		for(int i=index;i<n-1;i++){
			if(rem[i]!=0)
				{
					if(rem[i-1]!=0 && rem[i+1]!=0)dfs(i+2,depth+1, brick+rem[i]);
					else{
						dfs(i+2,depth,brick);
					}
				}else{
					dfs(i+2,depth,brick);
				}

		}
		return 1;
	}
	public void print(){
		System.out.println(map);
	}
}
