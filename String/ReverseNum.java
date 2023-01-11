package String;

import java.util.*;

public class ReverseNum {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sba= new StringBuilder();
        StringBuilder sbb=new StringBuilder();
        sba.append(a).reverse();
        sbb.append(b).reverse();

        if(Integer.parseInt(String.valueOf(sba))>Integer.parseInt(String.valueOf(sbb))) System.out.println(sba);
        else System.out.println(sbb);
    }
}