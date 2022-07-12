import java.util.*;


public class Solution{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int test=Integer.parseInt(sc.nextLine());
		while(test-->0){
			String s=sc.nextLine();
			char a=s.charAt(0);
			char b=s.charAt(1);
			char c=s.charAt(2);
			if((a==89 || a==121) && (b==101 || b==69) && (c==83 || c==115)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}
