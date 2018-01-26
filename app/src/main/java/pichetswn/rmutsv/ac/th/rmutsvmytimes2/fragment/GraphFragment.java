package pichetswn.rmutsv.ac.th.rmutsvmytimes2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONObject;

import pichetswn.rmutsv.ac.th.rmutsvmytimes2.R;
import pichetswn.rmutsv.ac.th.rmutsvmytimes2.utility.GetAllData;

/**
 * Created by pichet.s on 26-Jan-18.
 */

public class GraphFragment extends Fragment{

    //    Explit
    private GraphView graphView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create GraphView
        try {

            String strURL = "http://androidthai.in.th/piw/getAllFirebaseKen.php";

            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(strURL);
            String strJSON = getAllData.get();
            Log.d("26Jan", "JSON ==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            int[] xInts = new int[jsonArray.length()];
            int[] yInts = new int[jsonArray.length()];
            DataPoint[] dataPoints = new DataPoint[jsonArray.length()];

            for (int i=0; i<jsonArray.length(); i+=1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String strX = jsonObject.getString("X");
                String strY = jsonObject.getString("Y");
                xInts[i] = Integer.parseInt(strX);
                yInts[i] = Integer.parseInt(strY);

                dataPoints[i] = new DataPoint(xInts[i], yInts[i]);

                
            } //for

            graphView = getView().findViewById(R.id.graphViewMyData);
            LineGraphSeries<DataPoint> dataPointLineGraphSeries = new LineGraphSeries<>(dataPoints);
            graphView.addSeries(dataPointLineGraphSeries);

        } catch (Exception e) {
            e.printStackTrace();
        }


    } // Main Method

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graph, container, false);
        return view;
    }
}  // Main Class
