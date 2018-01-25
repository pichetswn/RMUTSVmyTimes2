package pichetswn.rmutsv.ac.th.rmutsvmytimes2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pichetswn.rmutsv.ac.th.rmutsvmytimes2.fragment.ControllerFragment;
import pichetswn.rmutsv.ac.th.rmutsvmytimes2.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Add Fragment of Activity
        if (savedInstanceState == null) {

//            for MainFragment
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentMainFragment, new MainFragment())
                    .commit();

//            for ControllerFragment
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentControllerFragment, new ControllerFragment())
                    .commit();

        }


    } //Main Method


} // Main Class
