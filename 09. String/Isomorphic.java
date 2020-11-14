// { Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Isomorphic {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            MyClass obj = new MyClass();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}
// } Driver Code Ends


class MyClass{
    // This function returns true if str1 and str2 are ismorphic
    // else returns false
    public static boolean areIsomorphic(String S1,String S2)
    {
        // Your code here
        if(S1.length() != S2.length())
            return false;
        
        int count1[] = new int[256];
        int count2[] = new int[256];

        for(int i=0;i<S1.length();i++){
            count1[S1.charAt(i)]++;
            count2[S2.charAt(i)]++;
        }

        for(int i=0;i<S1.length();i++){
            if(count1[S1.charAt(i)] != count2[S2.charAt(i)])
                return false;
        }
        return true;
    }
}