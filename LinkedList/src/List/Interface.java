/*
*初始化提示
 */

package List;

public class Interface {
    public static void Initialize()
    {
        System.out.print("创建链表（输入'0'结束）：");
    }
    public static void Options(){
        System.out.println("1       插入节点");
        System.out.println("2       删除节点");
        System.out.println("3       遍历链表");
        System.out.println("4       反转链表");
        System.out.println("5       成环链表");
        System.out.println("6       奇偶调换");
        System.out.println("7       中间节点");
        System.out.print("请输入你的选择：");
    }
}
