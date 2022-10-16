package com.chetv.fooddeliveryapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chetv.fooddeliveryapp.data.RetrofitClient
import com.chetv.fooddeliveryapp.data.json.DodoPizzaJson
import com.chetv.fooddeliveryapp.data.service.PizzaService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    private val jsonResponseFromServer: MutableLiveData<DodoPizzaJson> = MutableLiveData()

    fun getJsonResultObserver(): MutableLiveData<DodoPizzaJson> {
        return jsonResponseFromServer
    }

    fun makeRequest() {
        val requestRetrofit = RetrofitClient.getInstance().create(PizzaService::class.java)
        requestRetrofit.getFoodItems()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getFoodObserverRx())
    }

    private fun getFoodObserverRx(): Observer<DodoPizzaJson>{
        return object : Observer<DodoPizzaJson> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: DodoPizzaJson) {
                jsonResponseFromServer.postValue(t)
            }

            override fun onError(e: Throwable) {
                jsonResponseFromServer.postValue(null)
            }

            override fun onComplete() {

            }

        }
    }
}