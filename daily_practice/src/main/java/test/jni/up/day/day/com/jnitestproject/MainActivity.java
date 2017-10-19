package test.jni.up.day.day.com.jnitestproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import test.jni.up.day.day.com.jnitestproject.type.TargetClass;
import test.jni.up.day.day.com.jnitestproject.view.TargetAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mClassList = null;
    private TargetAdapter mAdapter = null;

    private TargetClass[] mTargetClass = new TargetClass[]{
            new TargetClass("简单的JNI实现示例", JniTestActivity.class),
            new TargetClass("内部类和静态内部类示例", InnerClassTestActivity.class)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("日常练习");

        mClassList = (RecyclerView)findViewById(R.id.recycler_target_activity);
        mClassList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TargetAdapter(mTargetClass);
        mAdapter.setOnItemClickListener(new TargetAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(MainActivity.this, mTargetClass[position].getTargetClass()));
            }
        });
        mClassList.setAdapter(mAdapter);
    }
}
