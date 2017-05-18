package pro.games_box.irregularverbs.ui.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import pro.games_box.irregularverbs.R;
import pro.games_box.irregularverbs.model.IrregularVerb;

/**
 * Created by Tesla on 18.05.2017.
 */

public class VerbsHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.circle) public CircleImageView circleIcon;
    @BindView(R.id.title) TextView title;
    @BindView(R.id.infinitive) TextView infinitive;
    @BindView(R.id.pastForm) TextView pastForm;

    public Context context;

    public VerbsHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        context = itemView.getContext();
    }

    public void fill(final IrregularVerb verb) {
        title.setText(verb.getInfinitive().substring(0,1).toUpperCase());
        infinitive.setText(verb.getInfinitive());
        pastForm.setText(verb.getAllPastForms());
        circleIcon.setImageResource(colors[verb.getGroup()]);
    }

    int[] colors = new int[]{R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark,
                             R.color.A700, R.color.deepOrange, R.color.orange, R.color.blueGray,
                             R.color.cyan, R.color.brown};
}
