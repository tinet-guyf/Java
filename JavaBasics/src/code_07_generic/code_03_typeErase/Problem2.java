package code_07_generic.code_03_typeErase;

/**
 * Created by 18351 on 2018/12/24.
 */
public class Problem2 {
    public static void main(String[] args) {
        MyNode<Integer> my=new MyNode<Integer>(5);
        Node node=my;
        node.setData(1);
        //node.setData("aaa");
        //Exception in thread "main" java.lang.ClassCastException:java.lang.String cannot be cast to java.lang.Integer
        /*原因：
        因为MyNode中不存在setData(String data)方法，所以只能调用父类Node的setData(Object data)方法，
        既然这样上面的第12行代码不应该报错，因为String当然可以转换成Object。
        实际上Java编译器对上面代码自动还做了一个处理：
        class MyNode extends Node {
            //TODO： Bridge method generated by the compiler
            public void setData(Object data) {
                setData((Integer) data);
                //TODO:setData((Integer) data);这造成了String无法转换成Integer。
                //TODO:所以上面第7行编译器提示unchecked warning的时候，我们不能选择忽略，不然要等到运行期间才能发现异常。
            }
            public void setData(Integer data) {
                System.out.println("MyNode.setData");
                super.setData(data);
            }
        }
        * */
    }
}