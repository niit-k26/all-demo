package vn.com.helloworld;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Lrandom on 5/31/18.
 */

public class ActivityFragmentDemo extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        MyFragment fragment =MyFragment.newInstance();

        FragmentManager fragmentManager =getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragmentcontent,fragment).commit();


    }
}
