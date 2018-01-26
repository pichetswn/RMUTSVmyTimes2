package pichetswn.rmutsv.ac.th.rmutsvmytimes2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pichetswn.rmutsv.ac.th.rmutsvmytimes2.fragment.GraphFragment;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

//        Add Fragment
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentGraphFragment, new GraphFragment())
                    .commit();
        }

    }  // Main Method

}  // Main Class
