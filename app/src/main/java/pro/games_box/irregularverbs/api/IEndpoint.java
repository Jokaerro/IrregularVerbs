package pro.games_box.irregularverbs.api;

import java.util.List;

import pro.games_box.irregularverbs.model.IrregularVerb;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Tesla on 18.05.2017.
 */

public interface IEndpoint {
    //https://gist.githubusercontent.com/kabunov/d446c5c9521ef0d5da7895ac1f89e999/raw/c456182f02f5d8c5744ca5042592c87a524a2f75/verbs.json
    @GET("kabunov/d446c5c9521ef0d5da7895ac1f89e999/raw/c456182f02f5d8c5744ca5042592c87a524a2f75/verbs.json")
    Call<List<IrregularVerb>> getVerbs();
}
