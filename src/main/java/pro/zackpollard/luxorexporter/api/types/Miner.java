
package pro.zackpollard.luxorexporter.api.types;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Miner {

    private String affinity;
    @SerializedName("hashrate_fifteen_min")
    private double hashrateFifteenMin;
    @SerializedName("hashrate_five_min")
    private double hashrateFiveMin;
    @SerializedName("hashrate_one_day")
    private double hashrateOneDay;
    @SerializedName("hashrate_one_hour")
    private double hashrateOneHour;
    @SerializedName("hashrate_six_hour")
    private double hashrateSixHour;
    @SerializedName("last_share_time")
    private long lastShareTime;
    @SerializedName("miner_type")
    private String minerType;
    private String name;
    @SerializedName("revenue_fifteen_min")
    private String revenueFifteenMin;
    @SerializedName("revenue_five_min")
    private String revenueFiveMin;
    @SerializedName("revenue_one_day")
    private String revenueOneDay;
    @SerializedName("revenue_one_hour")
    private String revenueOneHour;
    @SerializedName("revenue_six_hour")
    private String revenueSixHour;
    @SerializedName("stale_fifteen_min")
    private long staleFifteenMin;
    @SerializedName("stale_five_min")
    private long staleFiveMin;
    @SerializedName("stale_one_day")
    private long staleOneDay;
    @SerializedName("stale_one_hour")
    private long staleOneHour;
    @SerializedName("stale_six_hour")
    private long staleSixHour;
    @SerializedName("total_shares")
    private double totalShares;

}
