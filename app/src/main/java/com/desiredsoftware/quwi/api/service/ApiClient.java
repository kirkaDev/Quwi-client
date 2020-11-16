package com.desiredsoftware.quwi.api.service;

import com.desiredsoftware.quwi.data.model.api.in.ApiError;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.Executors;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private final String endpointUrl = "https://api.quwi.com/v2/";

    private final String ContentTypeValue = "application/json";
    private final String ClientTimezoneOffsetValue = "60";
    private final String localeValue = "ru-RU";
    private final String ClientCompanyValue = "udimiteam";
    private final String ClientDeviceValue = "Android";


    private ApiService service;
    private Retrofit retrofit;
    private OkHttpClient.Builder httpClientBuilder;

    public ApiClient()
    {
        httpClientBuilder = new OkHttpClient.Builder();

        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().
                        addHeader(Headers.ContentType, ContentTypeValue).
                        addHeader(Headers.ClientTimezoneOffset, ClientTimezoneOffsetValue).
                        addHeader(Headers.ClientLanguage, localeValue).
                        addHeader(Headers.ClientCompany, ClientCompanyValue).
                        addHeader(Headers.ClientDevice, ClientDeviceValue).build();
                return chain.proceed(request);
            }
        });
        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(endpointUrl).client(httpClientBuilder.build()).build();

        service = retrofit.create(ApiService.class);
    }

    public ApiError getError(retrofit2.Response<?> response)
    {
        retrofit2.Converter<okhttp3.ResponseBody, ApiError> converter = retrofit.responseBodyConverter(ApiError.class, new Annotation[0]);

        ApiError error;

        try
        {
            error = converter.convert(response.errorBody());
        }
        catch (Throwable e)
        {
            error = new ApiError();
            error.setCode(response.code());
            error.setDescription(response.message());
        }

        return error;
    }

    public class Headers
    {
        public final static String ContentType = "Content-Type";
        public final static String ClientTimezoneOffset = "Client-Timezone-Offset";
        public final static String ClientLanguage = "Client-Language";
        public final static String ClientCompany = "Client-Company";
        public final static String ClientDevice = "Client-Device";
    }

    public ApiService getService() {
        return service;
    }


}
