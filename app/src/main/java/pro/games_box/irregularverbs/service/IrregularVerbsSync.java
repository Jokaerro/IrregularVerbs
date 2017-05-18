package pro.games_box.irregularverbs.service;

import org.greenrobot.eventbus.EventBus;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;

import pro.games_box.irregularverbs.model.ProgressEvent;


public class IrregularVerbsSync extends IntentService {
    private Context context;

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
        Thread.sleep(2000);
        EventBus.getDefault().post(new ProgressEvent("Done!"));
        return false;
    }


}
