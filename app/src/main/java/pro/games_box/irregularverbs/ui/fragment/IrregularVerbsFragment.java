package pro.games_box.irregularverbs.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import pro.games_box.irregularverbs.R;

/**
 * Created by Tesla on 18.05.2017.
 */

public class IrregularVerbsFragment extends Fragment {
    public static IrregularVerbsFragment newInstance() {
        final IrregularVerbsFragment fragment = new IrregularVerbsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.verbs_fragment, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }
}
