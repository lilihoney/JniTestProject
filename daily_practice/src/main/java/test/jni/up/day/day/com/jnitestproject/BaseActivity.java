package test.jni.up.day.day.com.jnitestproject;

import android.support.v7.app.AppCompatActivity;

/**
 * Created on 2017/10/19.
 * @author xiao qiang
 */

public class BaseActivity extends AppCompatActivity{

    private static final String TAG = "base activity";
    private boolean mIsCancel = true;


    public void outsideStart(){
        mIsCancel = true;
        System.out.println("outsideStart method in BaseActivity is called");
    }

    public void outSideCancel(){
        mIsCancel = false;
        System.out.println("outsideCancel method in BaseActivity is called");
    }

    //内部类可以声明public、protected、private等访问限制，其他类不可访问该类中private inner class，只能由所声明的外部类访问，完全对外隐藏
    //可以声明 为abstract的供其他内部类或外部类继承与扩展，
    //可以声明为static、final的，也可以实现特定的接口。

    //original inner class of BaseActivity
    //内部类持有对外部类的引用，因此可以直接访问外部类的成员
    private class PrivateInnerClass{
        public PrivateInnerClass(){
            System.out.println("This is a private inner class");
        }

        void innerCancel(){
            if(mIsCancel){
                System.out.println("private inner class can access member of outside class");
            }
        }
    }

    public class PublicInnerClass{
        private boolean mIsCancel = false;
        private static final String NAME = "public inner class";

        public PublicInnerClass(){
            System.out.println("This is a " + NAME);
        }
        void innerCancel(){
            if(mIsCancel){
                System.out.println("public inner class can access member of outside class");
            }
        }

        //inner class can not have static declarations
        /*static String getName(){
            return NAME;
        }*/

        //this in inner class express itself
        void printCancelValue(){
            System.out.println("printCancelValue in public inner class is called");
            System.out.println("out side mIsCancel = " + mIsCancel);
            System.out.println("inner class mIsCancel = " + this.mIsCancel);
        }
    }

    public class ProtectedInnerClass{
        public ProtectedInnerClass(){
            System.out.println("This is a protected inner class");
        }
        void innerCancel(){
            if(mIsCancel){
                System.out.println("public inner class can access member of outside class");
            }
        }
    }

    abstract class AbstractInnerClass{
        public AbstractInnerClass(){
            System.out.println("This is an abstract inner class");
        }

        abstract void playGame();

        void innerCancel(){
            if(mIsCancel){
                System.out.println("public inner class can access member of outside class");
            }
        }
    }

    //static nested class of BaseActivity 也称为嵌套（nest）类
    //不需要外部类就可以创建静态内部类对象
    //静态内部类只能访问外部类的静态成员
    //静态内部类实例化时不与外部类实例绑定
    private static class StaticPrivateInnerClass{
        public StaticPrivateInnerClass(){
            System.out.println("This is a satic private inner class");
        }
        //static nested class can't access Non-static member of outside class
        /*void innerCancel(){
            if(mIsCancel){
                System.out.println("public inner class can access member of outside class");
            }
        }*/
        //TAD is static
        String getOutSideTag(){
            return TAG;
        }


    }

    public static class StaticPublicInnerClass{
        private static final String NAME = "static public inner class";

        public StaticPublicInnerClass(){
            System.out.println("This is a static public inner class");
        }
        //TAD is static
        String getOutSideTag(){
            return TAG;
        }

        static String getName(){
            return NAME;
        }
    }

    public static class StaticProtectedInnerClass{
        public StaticProtectedInnerClass(){
            System.out.println("This is a static protected inner class");
        }
        //TAD is static
        String getOutSideTag(){
            return TAG;
        }
    }

    @Override
    protected void onDestroy() {
        mIsCancel = false;
        super.onDestroy();
    }

    //思考为什么用内部类
    // 1.   内部类一般只为其外部类使用；
    // 2.   内部类提供了某种进入外部类的窗户；
    // 3.   也是最吸引人的原因，每个内部类都能独立地继承一个接口，而无论外部类是否已经继承了某个接口。因此，内部类使多重继承的解决方案变得更加完整。
}
