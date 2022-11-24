package org.example.util;

import java.net.SecureCacheResponse;
import java.util.Scanner;

public class ScanUtil {
    public  static Scanner scanStr=new Scanner(System.in);
    public  static Scanner scanInt=new Scanner(System.in);
    public  static Scanner scanChar=new Scanner(System.in);
    public static  int getAction(){
        System.out.print("Enter action: ");
        int act=scanInt.nextInt();
        return act;
    }
}
