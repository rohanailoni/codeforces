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
				int[] arr=string_to_array(in.nextLine().split(" "));
				int n=arr[0];
				int m=arr[1];
				int pow=(int)Math.pow(2,n);
				arr=string_to_array(in.nextLine().split(" "));
				SGT s=new SGT(pow, arr);
				if(n%2==0)s.build(0,pow-1,0,false);
				else{
					s.build(0,pow-1,0,true);
				}
				// out.println(s.seg[0]);
				for(int i=0;i<m;i++){
					// System.out.println("before"+Arrays.toString(s.seg));
					int[] sg=string_to_array(in.nextLine().split(" "));
					if(n%2==0){

						s.update(0,pow-1,sg[0]-1,sg[1],0,false);
					}else{

						s.update(0,pow-1,sg[0]-1,sg[1],0,true);
					}
					// System.out.println("After"+Arrays.toString(s.seg));
					out.println(s.seg[0]);
				}
					
            out.close();
        } catch (Exception e) {
			System.out.println(e);
            return;
        }
    }
}

class SGT{
	int[] seg;
	int[] arr;
	SGT(int n,int[] arr){
		seg=new int[4*n];
		this.arr=arr;
	}
	public void build(int l,int h,int index,boolean or){
		if(l==h){
			seg[index]=arr[l];
			return;
		}
		int mid=l+(h-l)/2;
		build(l,mid,2*index+1,!or);
		build(mid+1,h,2*index+2,!or);
		if(or){
			seg[index]=seg[2*index+1] | seg[2*index+2];
		}else{
			seg[index]=seg[2*index+1] ^ seg[2*index+2];
		}
		return;		
	}
	public void update(int low,int high,int index,int val,int i,boolean or){
		if(low>index || index>high){
			return ;
		}
		if(index>=low && index<=high){
			// System.out.println(low+ " "+high+" "+index+" "+seg[i]);
			if(low==high && index==low){
				seg[i]=val;
				return;
			}	
			int mid=low+(high-low)/2;
			update(low, mid, index, val, 2*i+1,!or);
			update(mid+1, high,index, val, 2*i+2,!or);
			if(or){
				seg[i]=seg[2*i+1] | seg[2*i+2];
			}else{
				seg[i]=seg[2*i+1] ^ seg[2*i+2];
			}
			return;

		}
		return;
	}

}






