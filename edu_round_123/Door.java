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
            
            while(testCases-- > 0){
               
				HashMap<Character,Integer>map=new HashMap<>();
				String s=in.nextLine();
				boolean isgo=false;
				for(int i=0;i<s.length();i++){
					char temp=s.charAt(i);
					if(temp=='r'){
						map.put('r',map.getOrDefault('r', 0)+1);
					}else if(temp=='g'){

						map.put('g',map.getOrDefault('g', 0)+1);
					}else if(temp=='b'){
						map.put('b',map.getOrDefault('b', 0)+1);


					}else if(temp=='R'){
						if(map.containsKey('r')&& map.get('r')==1){
							isgo=true;
						}else{
							isgo=false;
							break;
						}
					}else if(temp=='G'){
						if(map.containsKey('g')&& map.get('g')==1){
							isgo=true;
						}else{
							isgo=false;
							break;
						}
					}else if(temp=='B'){
						if(map.containsKey('b') && map.get('b')==1){
							isgo=true;
						}else{
							isgo=false;
							break;
						}
					}
                    //out.println(map.containsKey('r'));
				}
                //out.print(isgo);
				if(isgo){
					out.println("YES");
				}else{
					out.println("NO");
				}
            }
            
            out.close();
        } catch (Exception e) {
            System.out.print(e);
			return;

        }
    }
}

