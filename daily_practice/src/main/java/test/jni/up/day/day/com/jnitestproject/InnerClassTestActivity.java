package test.jni.up.day.day.com.jnitestproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InnerClassTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_class_test);

        //inner class init test
        //can not access private inner class of BaseActivity
        BaseActivity baseActivity = new BaseActivity();
        BaseActivity.PublicInnerClass basePublicInnerClass = baseActivity.new PublicInnerClass();
        BaseActivity.ProtectedInnerClass baseProtectedInnerClass = baseActivity.new ProtectedInnerClass();

        BaseActivity.AbstractInnerClass baseAbstractInnerClass = baseActivity.new AbstractInnerClass() {

            @Override
            void playGame() {
                System.out.println("using abstract inner class of BaseActivity in InnerClassTestActivity");
            }
        };

        //static nested class test
        //can not access private static nested class of BaseActivity
        BaseActivity.StaticPublicInnerClass staticPublicInnerClass = new BaseActivity.StaticPublicInnerClass();
        BaseActivity.StaticProtectedInnerClass staticProtectedInnerClass = new BaseActivity.StaticProtectedInnerClass();

        //test method of inner class
        baseActivity.outSideCancel();

        basePublicInnerClass.innerCancel();
        basePublicInnerClass.printCancelValue();

    }
}
