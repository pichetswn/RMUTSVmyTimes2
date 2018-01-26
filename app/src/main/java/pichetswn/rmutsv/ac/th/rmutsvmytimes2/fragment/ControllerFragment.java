package pichetswn.rmutsv.ac.th.rmutsvmytimes2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import pichetswn.rmutsv.ac.th.rmutsvmytimes2.R;

/**
 * Created by pichet.s on 25-Jan-18.
 */

public class ControllerFragment extends Fragment{

//    Explicit
    private Button zeroButton, onButton, offButton;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Initial View
        zeroButton = getView().findViewById(R.id.btnZero);
        onButton = getView().findViewById(R.id.btnOn);
        offButton = getView().findViewById(R.id.btnOff);

//            Setup Firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> stringObjectMap = new HashMap<>();
                stringObjectMap.put("myTimes", "0");
                databaseReference.updateChildren(stringObjectMap);

            }
        });

//        On Controller
         onButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Map<String, Object> stringObjectMap = new HashMap<>();
                 stringObjectMap.put("Switch", 1);
                 databaseReference.updateChildren(stringObjectMap);

//                 Map<Integer, Object> integerObjectMap =
             }
         });

//        Off Controller
        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> stringObjectMap = new HashMap<>();
                stringObjectMap.put("Switch", 0);
                databaseReference.updateChildren(stringObjectMap);

            }
        });

    }  // Main Method


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_controller, container, false);
        return view;
    }
}  // Main Class
