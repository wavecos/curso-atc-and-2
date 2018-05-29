package bo.com.cognos.quakeradar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bo.com.cognos.quakeradar.adapter.QuakeAdapter;
import bo.com.cognos.quakeradar.domain.Quake;
import bo.com.cognos.quakeradar.domain.QuakeTime;
import bo.com.cognos.quakeradar.domain.Result;
import bo.com.cognos.quakeradar.service.QuakeAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private TextView textViewTitle;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<Quake> quakes = new ArrayList<>();
    private QuakeTime timeSelected = QuakeTime.LAST_HOUR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshQuakes(timeSelected);
                Toast.makeText(MainActivity.this, "Datos actualizados", Toast.LENGTH_SHORT).show();
            }
        });

        tabLayout = findViewById(R.id.tabLayout);

        viewPager = findViewById(R.id.viewPager);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d("TEST", "tab selecionado");
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.d("TEST", "tab deselecionado");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.d("TEST", "tab re-selecionado");
            }
        });

        // Progress Bar
//        progressBar = findViewById(R.id.progressBar);
//        progressBar.setIndeterminate(true);

//        textViewTitle = findViewById(R.id.textViewTitle);

        // Para el RecyclerView
//        recyclerView = findViewById(R.id.recyclerViewQuake);
//
//        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//
//        adapter = new QuakeAdapter(this, quakes);
//        recyclerView.setAdapter(adapter);
//
//        refreshQuakes(timeSelected);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_lastHour) {
            refreshQuakes(QuakeTime.LAST_HOUR);
            return true;
        }

        if (id == R.id.action_lastDay) {
            refreshQuakes(QuakeTime.LAST_DAY);
            return true;
        }

        if (id == R.id.action_lastWeek) {
            refreshQuakes(QuakeTime.LAST_WEEK);
            return true;
        }

        if (id == R.id.action_lastMonth) {
            refreshQuakes(QuakeTime.LAST_MONTH);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void refreshQuakes(QuakeTime time) {
        Call<Result> allQuakesByTime = null;

        switch (time) {
            case LAST_HOUR:
                allQuakesByTime = QuakeAPI.getQuakeService().getAllQuakesLastHour();
                textViewTitle.setText("Terremotos de la última hora");
                break;
            case LAST_DAY:
                allQuakesByTime = QuakeAPI.getQuakeService().getAllQuakesLastDay();
                textViewTitle.setText("Terremotos del último día");
                break;
            case LAST_WEEK:
                allQuakesByTime = QuakeAPI.getQuakeService().getAllQuakesLastWeek();
                textViewTitle.setText("Terremotos de la última semana");
                break;
            case LAST_MONTH:
                allQuakesByTime = QuakeAPI.getQuakeService().getAllQuakesLastMonth();
                textViewTitle.setText("Terremotos del último mes");
                break;
        }

        timeSelected = time;

        progressBar.setVisibility(View.VISIBLE);

        allQuakesByTime.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                quakes.clear();
                quakes.addAll(result.getQuakes());
                adapter.notifyDataSetChanged();

                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "error : " + t.getMessage(), Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });
    }

}
