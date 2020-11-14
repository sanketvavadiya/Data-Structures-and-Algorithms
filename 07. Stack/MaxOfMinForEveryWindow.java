// { Driver Code Starts
import java.util.*;
import java.io.*;

class MaxOfMinForEveryWindow {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            int[] res = new MaximumOfWindow().printMaxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}// } Driver Code Ends


class MaximumOfWindow {

    static int[] printMaxOfMin(int[] arr, int N) {
        // Your code here
        int ps[] = new int[N];
        int ns[] = new int[N];
        calps(ps, arr);
        calns(ns, arr);
        int ans[] = new int[N+1];
        for (int i=0; i<N; i++) {
            int len = ns[i] - ps[i] - 1;
            ans[len] = ans[len] > arr[i] ? ans[len] : arr[i];
        }

        for (int i=N-1; i>=1; i--) {
            ans[i] = ans[i] > ans[i+1] ? ans[i] : ans[i+1];
        }

        int res[] = new int[N];
        for(int i=0;i<N;i++)
            res[i] = ans[i+1];
        return res;
    }

    static void calps(int ps[], int arr[]){
        Stack<Integer> s = new Stack<Integer>();
        s.push(0);
        ps[0] = -1;
        for(int i=1;i<arr.length;i++){
            while(!s.empty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            ps[i] = s.empty() ? -1 :s.peek();
            s.push(i);
        }

        // for(int i=0;i<ps.length;i++){
        //  System.out.print(ps[i]+" ");
        // }
        // System.out.println();
    } 

    static void calns(int ns[], int arr[]) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(arr.length-1);
        ns[arr.length-1] = arr.length;
        for (int i=arr.length-2; i>=0; i--) {
            while (!s.empty() && arr[s.peek()]>=   arr[i]) {
                s.pop();
            }
            ns[i] = s.empty() ? arr.length : s.peek();
            s.push(i);
        }

        // for(int i=0;i<ns.length;i++){
        //  System.out.print(ns[i]+" ");
        // }
    }
}