package pro.games_box.irregularverbs.ui.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by admin on 18.05.2017.
 */

public class BaseActivity extends AppCompatActivity {
    protected ProgressDialog progressDialog;

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showProgress() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Пожалуйста, подождите");
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
        }
        progressDialog.show();
    }

    public void removeProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
