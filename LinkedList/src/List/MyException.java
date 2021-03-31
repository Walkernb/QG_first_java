/*
*自定义的异常类
* 作用：处理MyLinkedList类的searchList方法返回null的情况。
 */

package List;

public class MyException extends Exception{
    public MyException(){
        super();
    }
    public MyException(String str){
        super(str);
    }
}
