package pro.games_box.irregularverbs.model;

/**
 * Created by Tesla on 18.05.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IrregularVerb {
    @SerializedName("infinitive")
    @Expose
    private String infinitive;
    @SerializedName("past_simple")
    @Expose
    private String pastSimple;
    @SerializedName("past_simple2")
    @Expose
    private String pastSimple2;
    @SerializedName("past_participle")
    @Expose
    private String pastParticiple;
    @SerializedName("group")
    @Expose
    private Integer group;
    @SerializedName("past_participle2")
    @Expose
    private String pastParticiple2;

    public String getInfinitive() {
        return infinitive;
    }

    public void setInfinitive(String infinitive) {
        this.infinitive = infinitive;
    }

    public String getPastSimple() {
        return pastSimple;
    }

    public void setPastSimple(String pastSimple) {
        this.pastSimple = pastSimple;
    }

    public String getPastSimple2() {
        return pastSimple2;
    }

    public void setPastSimple2(String pastSimple2) {
        this.pastSimple2 = pastSimple2;
    }

    public String getPastParticiple() {
        return pastParticiple;
    }

    public void setPastParticiple(String pastParticiple) {
        this.pastParticiple = pastParticiple;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getPastParticiple2() {
        return pastParticiple2;
    }

    public void setPastParticiple2(String pastParticiple2) {
        this.pastParticiple2 = pastParticiple2;
    }
}
