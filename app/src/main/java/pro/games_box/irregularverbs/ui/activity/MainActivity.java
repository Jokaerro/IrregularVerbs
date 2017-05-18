package pro.games_box.irregularverbs.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import pro.games_box.irregularverbs.R;
import pro.games_box.irregularverbs.ui.fragment.IrregularVerbsFragment;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.rootLayout, IrregularVerbsFragment.newInstance(), "verbs")
                    .commit();
        }
    }
}
