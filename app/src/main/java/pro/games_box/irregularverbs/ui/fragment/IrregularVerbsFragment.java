package pro.games_box.irregularverbs.ui.fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import pro.games_box.irregularverbs.R;
import pro.games_box.irregularverbs.model.ProgressEvent;
import pro.games_box.irregularverbs.service.IrregularVerbsSync;

/**
 * Created by Tesla on 18.05.2017.
 */

public class IrregularVerbsFragment extends BaseFragment {
    public static IrregularVerbsFragment newInstance() {
        final IrregularVerbsFragment fragment = new IrregularVerbsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.verbs_fragment, container, false);
        ButterKnife.bind(this, rootView);
        EventBus.getDefault().register(this);

        Intent intent = new Intent(getContext(), IrregularVerbsSync.class);
        getContext().startService(intent);
        showProgress();

        return rootView;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ProgressEvent event) {
        removeProgress();
    }
}
