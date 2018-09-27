public class Topk{//个人认为复杂度为O(n)
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(input.length==0 || k<=0 || k>input.length) return res;
        if(k!=input.length) {
	        int low=0;
	        int high=input.length-1;
	        int key=-1;
	        while(key!=k){
	        	if(low>=high) break;
	            if(key<k){
	                low=key+1;
	                key=quick(input,low,high);
	            }else if(key>k){
	                high=key-1;
	                key=quick(input,low,high);
	            }
	        }
        }
        for(int i=0;i<k;i++) res.add(input[i]);
        return res;
    }
    public int quick(int[] a,int low,int high){
        int key=a[low];
        while(low<high){
            while(low<high && a[high]>key) high--;
            a[low]=a[high];
            while(low<high && a[low]<key) low++;
            a[high]=a[low];
        }
        a[low]=key;
        return low;
    }
}
