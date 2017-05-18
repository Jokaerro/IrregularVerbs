package pro.games_box.irregularverbs.ui.fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.games_box.irregularverbs.R;
import pro.games_box.irregularverbs.model.IrregularVerb;
import pro.games_box.irregularverbs.model.ProgressEvent;
import pro.games_box.irregularverbs.service.IrregularVerbsSync;
import pro.games_box.irregularverbs.ui.adapter.IrregularVerbsAdapter;

/**
 * Created by Tesla on 18.05.2017.
 */

public class IrregularVerbsFragment extends BaseFragment {
    private IrregularVerbsAdapter verbsAdapter;
    @BindView(R.id.verbsRecycler) RecyclerView verbsRecycler;

    public static IrregularVerbsFragment newInstance() {
        final IrregularVerbsFragment fragment = new IrregularVerbsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.verbs_fragment, container, false);
        ButterKnife.bind(this, rootView);

        Intent intent = new Intent(getContext(), IrregularVerbsSync.class);
        getContext().startService(intent);
        showProgress();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ProgressEvent event) {
        removeProgress();
        showToast(event.message);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void verbsIncoming(List<IrregularVerb> irregularVerbs) {
        removeProgress();
        verbsAdapter = new IrregularVerbsAdapter(getActivity(), irregularVerbs);
        verbsRecycler.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        verbsRecycler.setLayoutManager(llm);
        verbsRecycler.setAdapter(verbsAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(verbsRecycler.getContext(),
                llm.getOrientation());
        verbsRecycler.addItemDecoration(dividerItemDecoration);
    }
}
