package com.chetv.fooddeliveryapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chetv.fooddeliveryapp.data.RetrofitClient
import com.chetv.fooddeliveryapp.data.json.JsonGunterFoodApi
import com.chetv.fooddeliveryapp.data.service.PizzaService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    private val jsonResponseFromServer: MutableLiveData<JsonGunterFoodApi> = MutableLiveData()

    fun getJsonResultObserver(): MutableLiveData<JsonGunterFoodApi> {
        return jsonResponseFromServer
    }


    fun makeRequest() {
        val requestRetrofit = RetrofitClient.getInstance().create(PizzaService::class.java)
        requestRetrofit.getPizzaItems()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getFoodObserverRx())
    }

    private fun getFoodObserverRx(): Observer<JsonGunterFoodApi> {
        return object : Observer<JsonGunterFoodApi> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: JsonGunterFoodApi) {
                jsonResponseFromServer.postValue(t)
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {

            }

        }
    }
}