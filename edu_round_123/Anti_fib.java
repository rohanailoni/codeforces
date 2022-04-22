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
    static boolean fibcheck(int[] arr){
        for(int i=2;i<arr.length;i++){
            if(arr[i-2]+arr[i-1]==arr[i]){
                return false;
            }
        }
        return true;
    }
    static List<ArrayList<Integer>>ans;
    private static void permuteHelper(int[] arr, int index){
        if(index >= arr.length - 1){ 
            if(fibcheck(arr) && ans.size()<arr.length){
                ArrayList<Integer>arr1=new ArrayList<>();
                for(int i:arr)arr1.add(i);
                //System.out.print(arr1+"in list ");
                ans.add(arr1);
            }

            return;
            
        }
    
        for(int i = index; i < arr.length; i++){ 
    
           
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
    
            
            permuteHelper(arr, index+1);
    
            
            t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            
            while(testCases-- > 0){
               
				int n=Integer.parseInt(in.nextLine());
                ans=new ArrayList<>();
                if(n==3){
                    out.println("3 2 1");
                    out.println("1 3 2");
                    out.println("3 1 2");
                    continue;
                }
                int[] arr=new int[n];
                for(int i=1;i<n+1;i++)arr[i-1]=i;

                //permuteHelper(arr,0);
                // for(List<Integer>temp:ans){
                //     for(int i:temp){
                //         out.print(i+" ");
                //     }
                //     out.println(" ");
                // }
                for(int i=2;i<n;i++){
                    if(arr[i-2]+arr[i-1]==arr[i]){
                        int t=arr[i];
                        arr[i]=arr[i-1];
                        arr[i-1]=t;
                    }
                }
                int cou=1;
                
                for(int i=0;i<n;i++){
                    for(int j=n-i;j<n;j++){
                        out.print(arr[j]+" ");
                    }
                    for(int j=0;j<n-i;j++){
                        out.print(arr[j]+" ");
                    }
                    out.println(" ");
                }

            }
            
            out.close();
        } catch (Exception e) {
            System.out.print(e);
			return;

        }
    }
}

