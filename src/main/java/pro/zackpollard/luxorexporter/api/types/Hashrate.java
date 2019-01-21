
package pro.zackpollard.luxorexporter.api.types;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hashrate {

    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("hashrate")
    @Expose
    private Double hashrate;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Double getHashrate() {
        return hashrate;
    }

    public void setHashrate(Double hashrate) {
        this.hashrate = hashrate;
    }

}
