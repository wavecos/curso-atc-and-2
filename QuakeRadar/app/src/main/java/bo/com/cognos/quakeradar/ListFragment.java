package bo.com.cognos.quakeradar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bo.com.cognos.quakeradar.adapter.QuakeAdapter;
import bo.com.cognos.quakeradar.domain.Quake;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private QuakeAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private TextView textViewTitle;

    private List<Quake> quakes = new ArrayList<>();

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // Progress Bar
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setIndeterminate(true);

        textViewTitle = view.findViewById(R.id.textViewTitle);

        // Para el RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewQuake);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new QuakeAdapter(getActivity(), quakes);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void updateList(List<Quake> quakes) {
        adapter.setQuakes(quakes);
        adapter.notifyDataSetChanged();
    }

}
