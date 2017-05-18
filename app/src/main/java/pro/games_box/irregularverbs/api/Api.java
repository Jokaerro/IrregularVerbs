package pro.games_box.irregularverbs.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import pro.games_box.irregularverbs.BuildConfig;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tesla on 18.05.2017.
 */

public class Api {
    public static final String BASE_URL = "https://gist.githubusercontent.com/";

    private static volatile IEndpoint apiServiceInstance;
    public static IEndpoint getApiService() {
        IEndpoint localInstance = apiServiceInstance;
        if (localInstance == null) {
            synchronized (IEndpoint.class) {
                localInstance = apiServiceInstance;
                if (localInstance == null) {
                    Retrofit retrofit = Api.getRetrofit();
                    apiServiceInstance = localInstance = retrofit.create(IEndpoint.class);
                }
            }
        }
        return localInstance;
    }

    static Retrofit getRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) builder.addInterceptor(interceptor);
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                Request request = builder.build();

                return chain.proceed(request);
            }
        });

        Gson gson = new GsonBuilder().create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

}
