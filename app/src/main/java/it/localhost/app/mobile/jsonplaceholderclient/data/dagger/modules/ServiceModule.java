package it.localhost.app.mobile.jsonplaceholderclient.data.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.ActivityScope;
import it.localhost.app.mobile.jsonplaceholderclient.data.ApiService;
import it.localhost.app.mobile.jsonplaceholderclient.data.RetrofitService;
import retrofit2.Retrofit;

/**
 *
 */
@Module
public class ServiceModule {

    @Provides
    @ActivityScope
    public RetrofitService provideRetrofitService() {
        return new RetrofitService();
    }

    @Provides
    @ActivityScope
    public ApiService provideApiService(RetrofitService retrofitService) {
        Retrofit retrofit = retrofitService.buildApiRetrofit();
        return retrofit.create(ApiService.class);
    }
}
