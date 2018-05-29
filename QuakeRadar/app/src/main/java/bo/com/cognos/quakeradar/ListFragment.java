package bo.com.cognos.quakeradar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bo.com.cognos.quakeradar.domain.Quake;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private List<Quake> quakes;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

}
