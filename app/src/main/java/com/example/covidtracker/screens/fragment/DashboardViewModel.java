package com.example.covidtracker.screens.fragment;

import android.graphics.Color;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.covidtracker.data.ServiceApi;
import com.example.covidtracker.data.ServiceApiManager;
import com.example.covidtracker.data.model.CovidData;
import com.example.covidtracker.data.model.CovidDataResponse;
import com.example.covidtracker.data.model.Regional;
import com.richpath.RichPath;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class DashboardViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private ServiceApiManager mServiceApiManager;

    private CompositeDisposable disposable;

    private final MutableLiveData<CovidDataResponse> covidDataResponseMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<Regional> regionalMutableLiveData = new MutableLiveData<>();

    @Inject
    DashboardViewModel(ServiceApiManager serviceApiManager) {
        this.mServiceApiManager = serviceApiManager;
        disposable = new CompositeDisposable();
    }


    public MutableLiveData<Regional> getRegionalMutableLiveData() {
        return regionalMutableLiveData;
    }

    MutableLiveData<CovidDataResponse> getCovidDataResponseMutableLiveData() {
        return covidDataResponseMutableLiveData;
    }



    void fetchData(){

        disposable.add(mServiceApiManager.fetchData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<CovidDataResponse>() {
                    @Override
                    public void onSuccess(CovidDataResponse value) {

                        Log.d("Viewmodel ", "****** onSuccess: called *****");
                        covidDataResponseMutableLiveData.setValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.d("Viewmodel ", "****** onError: called ***** \n"+ e.getMessage());
                        covidDataResponseMutableLiveData.setValue(null);
                    }
                }));
    }

    void onStateClick(final String selectedState){

        if(covidDataResponseMutableLiveData.getValue() != null) {

            CovidData covidData = covidDataResponseMutableLiveData.getValue().getData();

            List<Regional> regionalData = covidData.getRegional();
            for(Regional regional : regionalData){

                if(regional.getLoc().equals(selectedState)){
                    regionalMutableLiveData.setValue(regional);
                }
            }
        }
    }


    void onDestroy(){
        disposable.dispose();
    }


}
