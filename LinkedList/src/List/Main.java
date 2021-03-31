/*
*主函数
* 作用：初始化MyLinkedList类的对象和链表，以及提供程序的功能选项。
 */

package List;
import java.util.*;
public class Main extends Interface {
    public static void main(String[] args) {
            MyLinkedList    list=new MyLinkedList();
            Scanner sc=new Scanner(System.in);
            String n;
            boolean jg=true;
            Initialize();
            try{
            while(jg){
                    n=sc.next();
                    if(n.equals("0")!=true)
                        {list.initList(n);}
                    else    jg=false;

            }
            Options();
            int i=sc.nextInt();
            try{
            switch(i){
                case 1:list.InsertList();break;
                case 2:list.DeleteList();break;
                case 3:list.TraverseList();break;
                case 4:list.ReverseList();break;
                case 5:list.IsLoopList();break;
                case 6:list.ReverseEvenList();break;
                case 7:list.FindMidNode();break;
                default:
                    System.out.println("输入有误！");
            }
            }catch(NullPointerException e){
                System.out.println("空链表！");
            }
            }catch(InputMismatchException e){
                System.out.println("输入的数据只能是整数！");
            }
    }
}
