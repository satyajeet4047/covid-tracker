package com.example.covidtracker.screens.fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.covidtracker.R;
import com.example.covidtracker.data.model.CovidDataResponse;
import com.example.covidtracker.screens.Factory.ViewModelFactory;
import com.example.covidtracker.screens.base.BaseFragment;
import com.richpath.RichPath;
import com.richpath.RichPathView;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardFragment extends BaseFragment implements RichPath.OnPathClickListener{


    private static final String TAG = "DashboardFragment";

    @Inject
    ViewModelFactory viewModelFactory;

    private DashboardViewModel mViewModel;


    @BindView(R.id.tv_active_case_count)
    TextView activeCasesView;

    @BindView(R.id.tv_recovered_cased_count)
    TextView recoveredCasesView;

    @BindView(R.id.tv_state_name)
    TextView selectedStateNameView;


    @BindView(R.id.tv_sate_active_count)
    TextView stateActivecasesView;

    @BindView(R.id.tv_deceased_case_count)
    TextView deceasedCasesView;

    @BindView(R.id.ic_india_map)
    RichPathView richPathView ;


    Dialog dialog;

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v=  inflater.inflate(R.layout.dashboard_fragment, container, false);
        ButterKnife.bind(this, v);
        return v;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity()),viewModelFactory).get(DashboardViewModel.class);

        ButterKnife.bind(view);

        showLoadingDialog();

        richPathView.setOnPathClickListener(this);

        mViewModel.fetchData();
        setObservables();
    }

    private void setObservables() {

        mViewModel.getCovidDataResponseMutableLiveData().observe(getViewLifecycleOwner(), covidDataResponse -> {


            if(covidDataResponse != null){

                int activeCount = covidDataResponse.getData().getUnofficial_summary().get(0).getActive();
                int recoveredCount = covidDataResponse.getData().getUnofficial_summary().get(0).getRecovered();
                int deceasedCount = covidDataResponse.getData().getUnofficial_summary().get(0).getDeaths();


                activeCasesView.setText(String.valueOf(activeCount));
                recoveredCasesView.setText(String.valueOf(recoveredCount));
                deceasedCasesView.setText(String.valueOf(deceasedCount));

                dialog.dismiss();

            }
        });



        mViewModel.getRegionalMutableLiveData().observe(getViewLifecycleOwner(),regional -> {

            selectedStateNameView.setText(regional.getLoc());

            int active = regional.getTotalConfirmed()- regional.getDischarged()- regional.getDeaths();
            stateActivecasesView.setText(String.valueOf(active));

        });



    }

    @Override
    public ViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onClick(RichPath richPath) {
        mViewModel.onStateClick(richPath.getName());

        int mapColor = getActivity().getResources().getColor(R.color.colorMap);
        int selectedReginColor = getActivity().getResources().getColor(R.color.yellow);
        for (RichPath richPaths: richPathView.findAllRichPaths()) {
            richPaths.setFillColor(mapColor);
        }
        richPath.setFillColor(selectedReginColor);

    }


    void showLoadingDialog(){

         dialog = ProgressDialog.show(getActivity(), "Loading...", "Please wait...", true);
    }

}
