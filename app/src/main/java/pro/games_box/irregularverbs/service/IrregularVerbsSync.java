package pro.games_box.irregularverbs.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;


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
        onSync();
    }

    public boolean onSync() {
        return false;
    }


}
