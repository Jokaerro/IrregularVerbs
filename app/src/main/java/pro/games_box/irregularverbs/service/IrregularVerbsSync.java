package pro.games_box.irregularverbs.service;

import org.greenrobot.eventbus.EventBus;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;

import java.io.IOException;
import java.util.List;

import pro.games_box.irregularverbs.api.Api;
import pro.games_box.irregularverbs.api.ApiError;
import pro.games_box.irregularverbs.api.ErrorUtils;
import pro.games_box.irregularverbs.model.IrregularVerb;
import pro.games_box.irregularverbs.model.ProgressEvent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class IrregularVerbsSync extends IntentService {
    private Context context;
    private Call<List<IrregularVerb>> verbsResponseCall;

    public IrregularVerbsSync() {
        super("IrregularVerbsSync");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent == null ){
            return;
        }
        context = getApplicationContext();
        try {
            onSync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean onSync() throws InterruptedException {
        verbsResponseCall = Api.getApiService().getVerbs();
        try {
            Response<List<IrregularVerb>> response = verbsResponseCall.execute();
            if(response.isSuccessful()) {
                List<IrregularVerb> irregularVerbs = response.body();
                Thread.sleep(2000);
                EventBus.getDefault().post(irregularVerbs);
            }
            if(response.errorBody() != null){
                ApiError error = ErrorUtils.parseError(response);
                EventBus.getDefault().post(new ProgressEvent("Error: " + error.getMessage()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}
