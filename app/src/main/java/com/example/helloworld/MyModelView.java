package com.example.helloworld;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyModelView extends ViewModel {
    private MutableLiveData<Integer> number;
    private MutableLiveData<ArrayList<String>> arrayList;
    public LiveData<Integer> getNumber(){
        if(number == null) {
            number = new MutableLiveData<Integer>();
            number.setValue(0);
        }
        return number;
    }

    public LiveData<ArrayList<String>> getArrayList(){
        if(arrayList == null){
            arrayList = new MutableLiveData<ArrayList<String>>();
            arrayList.setValue(new ArrayList<String>());
        }
        return arrayList;
    }

    public void increaseNumber(){
        number.setValue(number.getValue() + 1);
    }

    public void arrayListNumber(){
        arrayList.getValue().add(number.getValue().toString());
        arrayList.setValue(arrayList.getValue());

    }
}
