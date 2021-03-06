package vn.com.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/**
 * Created by Lrandom on 5/24/18.
 */

public class ActivityHome extends Activity {
    public static final String TAG="ActivityHome";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate");
        setContentView(R.layout.activity_home);
    }

    public void goToDemoListView(View v){
        Intent intent = new Intent(ActivityHome.this,ActivityDemoListView.class);
        startActivity(intent);
    }

    public void goToDemoGridView(View v){
        Intent intent = new Intent(ActivityHome.this,ActivityDemoGridView.class);
        startActivity(intent);
    }

    public void goToDemoRecycleView(View v){
        Intent intent = new Intent(ActivityHome.this,ActivityDemoRecycleView.class);
        startActivity(intent);
    }

    public void goToDemoFragment(View v){
        Intent intent = new Intent(ActivityHome.this,ActivityFragmentDemo.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }
}
