package pichetswn.rmutsv.ac.th.rmutsvmytimes2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pichetswn.rmutsv.ac.th.rmutsvmytimes2.R;

/**
 * Created by pichet.s on 26-Jan-18.
 */

public class GraphFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graph, container, false);
        return view;
    }
}  // Main Class