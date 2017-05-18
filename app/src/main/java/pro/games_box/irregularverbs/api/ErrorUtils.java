package pro.games_box.irregularverbs.api;

import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by Tesla on 18.05.2017.
 */

public class ErrorUtils {
    public static ApiError parseError(Response<?> response) {
        Converter<ResponseBody, ApiError> converter = Api.getRetrofit().responseBodyConverter(ApiError.class, new Annotation[0]);
        ApiError error = null;
        try {
            error = converter.convert(response.errorBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return error;
    }
}
