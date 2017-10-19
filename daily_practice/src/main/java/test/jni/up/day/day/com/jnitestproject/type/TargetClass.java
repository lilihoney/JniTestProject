package test.jni.up.day.day.com.jnitestproject.type;

import android.app.Activity;

/**
 * Created on 2017/10/19.
 * @author xiao qiang
 */

public class TargetClass {
    private String mName = null;
    private Class<? extends Activity> mTarget = null;

    public TargetClass(String name, Class<? extends Activity> targetClass){
        mName = name;
        mTarget = targetClass;
    }

    public Class<? extends Activity> getTargetClass(){
        return mTarget;
    }

    public String getName(){
        return mName;
    }
}
