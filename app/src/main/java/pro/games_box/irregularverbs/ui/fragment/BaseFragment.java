package pro.games_box.irregularverbs.ui.fragment;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import pro.games_box.irregularverbs.ui.activity.BaseActivity;

/**
 * Created by Tesla on 18.05.2017.
 */

public class BaseFragment extends Fragment {
    protected BaseActivity getParentCompat() {
        return (BaseActivity) getActivity();
    }

    protected void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public void showProgress() {
        BaseActivity activity = getParentCompat();
        if (activity != null) activity.showProgress();
    }

    public void removeProgress() {
        BaseActivity activity = getParentCompat();
        if (activity != null) activity.removeProgress();
    }
}
