package pichetswn.rmutsv.ac.th.rmutsvmytimes2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;
import java.util.Random;

import pichetswn.rmutsv.ac.th.rmutsvmytimes2.GraphActivity;
import pichetswn.rmutsv.ac.th.rmutsvmytimes2.R;
import pichetswn.rmutsv.ac.th.rmutsvmytimes2.utility.PostData;

/**
 * Created by pichet.s on 25-Jan-18.
 */

public class MainFragment extends Fragment{

    //  Explicit
    private TextView textView;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private String myTimesString;
    private Button button;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Initial View
        textView = getView().findViewById(R.id.txtShowMyTimes);

//        Get Data From Firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map map = (Map) dataSnapshot.getValue();
                myTimesString = String.valueOf(map.get("myTimes"));
                textView.setText(myTimesString);

//                Get and Post Data From Firebase to mySQL
                try {

                    String strURL = "http://androidthai.in.th/piw/addGraphKen.php";
                    Random random = new Random();

                    int intX = Integer.parseInt(myTimesString);
                    int intY = random.nextInt(10) + intX;

                    PostData postData = new PostData(getActivity());
                    postData.execute(Integer.toString(intX), Integer.toString(intY), strURL);
                    String strResult = postData.get();
                    Log.d("26Jan", "Result ==> " + strResult);


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }  // onDataChange

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        Graph Controller
        button = getView().findViewById(R.id.btnShowGraph);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(),"Show Graph",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), GraphActivity.class);
                startActivity(intent);
            }
        });

    } //Main Method


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

} // Main Class
