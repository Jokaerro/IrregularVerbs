package pro.games_box.irregularverbs.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pro.games_box.irregularverbs.R;
import pro.games_box.irregularverbs.model.IrregularVerb;
import pro.games_box.irregularverbs.ui.adapter.holder.VerbsHolder;

/**
 * Created by Tesla on 18.05.2017.
 */

public class IrregularVerbsAdapter extends RecyclerView.Adapter<VerbsHolder>{
    private final Context context;
    private static List<IrregularVerb> data;

    public IrregularVerbsAdapter(Context context, List<IrregularVerb> data) {
        this.context = context;
        if (data != null)
            IrregularVerbsAdapter.data = new ArrayList<>(data);
        else IrregularVerbsAdapter.data = new ArrayList<>();
    }

    @Override
    public VerbsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.verb_layout, parent, false);
        return new VerbsHolder(view);
    }

    @Override
    public void onBindViewHolder(VerbsHolder viewHolder, int position) {
        final VerbsHolder holder = viewHolder;
        viewHolder.fill(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
