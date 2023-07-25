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
    static boolean check(List<Integer> arr){

        int n=arr.size();
        if(n==1){
            return true;
        }
        for(int i=0;i<n-1;i++){
            if(arr.get(i)>arr.get(i+1)){
                return false;
            }
        }
        return true;
    }
    static boolean canSortArray(int[] nums) {
        Map<Integer, Integer> evenCount = new HashMap<>();
        Map<Integer, Integer> oddCount = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount.put(num, evenCount.getOrDefault(num, 0) + 1);
            } else {
                oddCount.put(num, oddCount.getOrDefault(num, 0) + 1);
            }
        }

        for (int count : evenCount.values()) {
            if (count > 1) {
                return true;
            }
        }

        for (int count : oddCount.values()) {
            if (count > 1) {
                return true;
            }
        }

        return false;
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
                List<Integer>odd=new ArrayList<>();
                List<Integer>even=new ArrayList<>();
                for(int i=0;i<n;i++){
                    if(arr[i]%2==0){
                        even.add(arr[i]);
                    }else{
                        odd.add(arr[i]);
                    }
                }
                Collections.sort(odd);
                Collections.sort(even);
                int evenp=0,oddp=0;
                List<Integer>newarr=new ArrayList<>();
                for(int i=0;i<n;i++){
                    if((arr[i] & 1)==1){
                        newarr.add(odd.get(oddp));
                        oddp++;
                    }else{
                        newarr.add(even.get(evenp));
                        evenp++;
                    }
                }
                //System.out.println(newarr);
                if(check(newarr)){
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
