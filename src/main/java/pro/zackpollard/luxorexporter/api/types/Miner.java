
package pro.zackpollard.luxorexporter.api.types;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Miner {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("affinity")
    @Expose
    private String affinity;
    @SerializedName("miner_type")
    @Expose
    private String minerType;
    @SerializedName("last_share_time")
    @Expose
    private Integer lastShareTime;
    @SerializedName("total_shares")
    @Expose
    private Double totalShares;
    @SerializedName("hashrate_five_min")
    @Expose
    private Double hashrateFiveMin;
    @SerializedName("hashrate_fifteen_min")
    @Expose
    private Double hashrateFifteenMin;
    @SerializedName("hashrate_one_hour")
    @Expose
    private Double hashrateOneHour;
    @SerializedName("hashrate_six_hour")
    @Expose
    private Double hashrateSixHour;
    @SerializedName("hashrate_one_day")
    @Expose
    private Double hashrateOneDay;
    @SerializedName("stale_five_min")
    @Expose
    private Integer staleFiveMin;
    @SerializedName("stale_fifteen_min")
    @Expose
    private Integer staleFifteenMin;
    @SerializedName("stale_one_hour")
    @Expose
    private Integer staleOneHour;
    @SerializedName("stale_six_hour")
    @Expose
    private Integer staleSixHour;
    @SerializedName("stale_one_day")
    @Expose
    private Integer staleOneDay;
    @SerializedName("revenue_five_min")
    @Expose
    private String revenueFiveMin;
    @SerializedName("revenue_fifteen_min")
    @Expose
    private String revenueFifteenMin;
    @SerializedName("revenue_one_hour")
    @Expose
    private String revenueOneHour;
    @SerializedName("revenue_six_hour")
    @Expose
    private String revenueSixHour;
    @SerializedName("revenue_one_day")
    @Expose
    private String revenueOneDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAffinity() {
        return affinity;
    }

    public void setAffinity(String affinity) {
        this.affinity = affinity;
    }

    public String getMinerType() {
        return minerType;
    }

    public void setMinerType(String minerType) {
        this.minerType = minerType;
    }

    public Integer getLastShareTime() {
        return lastShareTime;
    }

    public void setLastShareTime(Integer lastShareTime) {
        this.lastShareTime = lastShareTime;
    }

    public Double getTotalShares() {
        return totalShares;
    }

    public void setTotalShares(Double totalShares) {
        this.totalShares = totalShares;
    }

    public Double getHashrateFiveMin() {
        return hashrateFiveMin;
    }

    public void setHashrateFiveMin(Double hashrateFiveMin) {
        this.hashrateFiveMin = hashrateFiveMin;
    }

    public Double getHashrateFifteenMin() {
        return hashrateFifteenMin;
    }

    public void setHashrateFifteenMin(Double hashrateFifteenMin) {
        this.hashrateFifteenMin = hashrateFifteenMin;
    }

    public Double getHashrateOneHour() {
        return hashrateOneHour;
    }

    public void setHashrateOneHour(Double hashrateOneHour) {
        this.hashrateOneHour = hashrateOneHour;
    }

    public Double getHashrateSixHour() {
        return hashrateSixHour;
    }

    public void setHashrateSixHour(Double hashrateSixHour) {
        this.hashrateSixHour = hashrateSixHour;
    }

    public Double getHashrateOneDay() {
        return hashrateOneDay;
    }

    public void setHashrateOneDay(Double hashrateOneDay) {
        this.hashrateOneDay = hashrateOneDay;
    }

    public Integer getStaleFiveMin() {
        return staleFiveMin;
    }

    public void setStaleFiveMin(Integer staleFiveMin) {
        this.staleFiveMin = staleFiveMin;
    }

    public Integer getStaleFifteenMin() {
        return staleFifteenMin;
    }

    public void setStaleFifteenMin(Integer staleFifteenMin) {
        this.staleFifteenMin = staleFifteenMin;
    }

    public Integer getStaleOneHour() {
        return staleOneHour;
    }

    public void setStaleOneHour(Integer staleOneHour) {
        this.staleOneHour = staleOneHour;
    }

    public Integer getStaleSixHour() {
        return staleSixHour;
    }

    public void setStaleSixHour(Integer staleSixHour) {
        this.staleSixHour = staleSixHour;
    }

    public Integer getStaleOneDay() {
        return staleOneDay;
    }

    public void setStaleOneDay(Integer staleOneDay) {
        this.staleOneDay = staleOneDay;
    }

    public String getRevenueFiveMin() {
        return revenueFiveMin;
    }

    public void setRevenueFiveMin(String revenueFiveMin) {
        this.revenueFiveMin = revenueFiveMin;
    }

    public String getRevenueFifteenMin() {
        return revenueFifteenMin;
    }

    public void setRevenueFifteenMin(String revenueFifteenMin) {
        this.revenueFifteenMin = revenueFifteenMin;
    }

    public String getRevenueOneHour() {
        return revenueOneHour;
    }

    public void setRevenueOneHour(String revenueOneHour) {
        this.revenueOneHour = revenueOneHour;
    }

    public String getRevenueSixHour() {
        return revenueSixHour;
    }

    public void setRevenueSixHour(String revenueSixHour) {
        this.revenueSixHour = revenueSixHour;
    }

    public String getRevenueOneDay() {
        return revenueOneDay;
    }

    public void setRevenueOneDay(String revenueOneDay) {
        this.revenueOneDay = revenueOneDay;
    }

}
