package com.emeryc.repos.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

public class RetrofitUtil {


    public static Service get(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build();

        NetworkBehavior behavior = NetworkBehavior.create(); //Permet de simuler des trucs au réseau (Ex: délai, % erreur, etc.)
        MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit).networkBehavior(behavior).build();
        BehaviorDelegate<Service> delegate = mockRetrofit.create(Service.class);

        return new Mock(delegate);
    }

}
