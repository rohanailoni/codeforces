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
				in.next();
				String[][] arr=new String[8][8];
				for(int i=0;i<8;i++){
					arr[i]=in.nextLine().split("");
				}
				int[][] dir={{-1,-1},{-1,1},{1,-1},{1,1}};
				boolean is=false;
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
						if(arr[i][j].equals("#")){
							int count=0;
							for(int[] r:dir){
								int new_x=i+r[0];
								int new_y=j+r[1];
								if(new_x>=0 && new_y>=0 && new_x<8 && new_y<8 ){
									if(arr[new_x][new_y].equals("#")){count++;}
								}
							}
							if(count==4){
								i++;j++;
								out.println(i+" "+j);
								is=true;
								break;
							}
						}
						if(is){break;}
					}
					if(is)break;
				}
					
			}
            out.close();
        } catch (Exception e) {
			System.out.println(e);
            return;
        }
    }
}

