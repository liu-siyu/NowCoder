// write your code here
//题目链接 https://www.nowcoder.com/questionTerminal/7b3728138a8f44fd832078138a7d60c3
//1-9全排列找素数 问题出在加入只排列奇数后发生了错误 很奇怪
import java.util.Scanner;
import java.util.TreeSet;
import java.util.ArrayList;
public class NowCoderPassword{
    static boolean[] isprime;
    static ArrayList<Integer> prime;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int p=(int)Math.sqrt(987654321)+1;
        isprime=new boolean[p];
        isprime[1]=true;
        prime=new ArrayList<>(p);
        for(int i=2;i<p;i++)
            if(!isprime[i]){
                prime.add(i);
                for(int j=i*i;j<p;j+=i)
                    isprime[j]=true;
            }
        int n=0;
        while((n=in.nextInt())!=0){
            int[] arr=new int[n];
            boolean flag=false;
            int sum=0;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                sum+=arr[i];
                if((arr[i]&1)==1) flag=true;
            }
            if(n!=1 && (!flag || sum%3==0)){
                System.out.println("NONE");
                continue;
            }
            TreeSet<Integer> set=new TreeSet<>();
            for(int i=0;i<n;i++)
                if((arr[i]&1)==1){
                    swap(arr,i,n-1);
                    dfs(0,arr,set);
                    swap(arr,i,n-1);
                }
            if(set.size()==0) System.out.println("NONE");
            else for(int i:set) System.out.println(i);
        }
        in.close();
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void dfs(int idx,int[] arr,TreeSet<Integer> set){
        if(idx==arr.length-2){
            int temp=arr[0];
            for(int i=1;i<arr.length;i++)
                temp=arr[i]+temp*10;
            if(temp<isprime.length){
                if(!isprime[temp]) set.add(temp);
                return;
            }
            for(int i:prime)
                if(temp%i==0) return;
            set.add(temp);
        }
        for(int i=idx;i<arr.length-1;i++){
            swap(arr,idx,i);
            dfs(idx+1,arr,set);
            swap(arr,idx,i);
        }
    }
}
