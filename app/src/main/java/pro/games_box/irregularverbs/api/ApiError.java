package pro.games_box.irregularverbs.api;

import com.google.gson.annotations.Expose;

/**
 * Created by Tesla on 18.05.2017.
 */

public class ApiError {
    @Expose
    private String message;

    @Expose
    private String description;

    public ApiError() {
    }

    public String getMessage() {
        return message;
    }

    public String getDescription(){
        return description;
    }
}
