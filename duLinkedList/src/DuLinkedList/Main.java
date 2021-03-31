/*
*主函数
* 作用：初始化链表，提供功能选项
 */
package DuLinkedList;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyduLinkedList  list=new MyduLinkedList();
        String str;
        Scanner sc=new Scanner(System.in);
        System.out.print("创建链表（以'0'结束）：");
        str=sc.next();
        while(str.equals("0")!=true){
            list.InitList_DuL(str);
            str=sc.next();
        }
        System.out.println("1       遍历链表");
        System.out.println("2       删除节点");
        System.out.println("3       向前插入节点");
        System.out.println("4       向后插入节点");
        System.out.print("请输入你的选择：");
        int n=sc.nextInt();
        try {
            switch (n) {
                case 1:list.TraverseList_DuL();break;
                case 2:list.DeleteList_DuL();break;
                case 3:list.InsertBeforeList_DuL();break;
                case 4:list.InsertAfterList_DuL();break;
                default:
                    System.out.println("输入有误！");
            }
        }catch(NullPointerException e){
            System.out.println("空链表！");
        }
    }
}
