package bo.com.cognos.quakeradar;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bo.com.cognos.quakeradar.adapter.QuakeAdapter;
import bo.com.cognos.quakeradar.domain.Quake;
import bo.com.cognos.quakeradar.persistence.AppDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {

    private RecyclerView recyclerView;
    private QuakeAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        // Para el RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewQuake);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Obtener una instancia del AppDatabase
        AppDatabase database = Room.databaseBuilder(getActivity(), AppDatabase.class, "quakes-db")
                .allowMainThreadQueries()
                .build();

        List<Quake> quakes = database.getQuakeDAO().getFavorites();

        adapter = new QuakeAdapter(getActivity(), quakes);
        recyclerView.setAdapter(adapter);

        return view;
    }

}
