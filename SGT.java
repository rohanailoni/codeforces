
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
