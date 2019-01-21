
package pro.zackpollard.luxorexporter.api.types;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LuxorApi {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("balance")
    @Expose
    private Double balance;
    @SerializedName("estimated_balance")
    @Expose
    private Object estimatedBalance;
    @SerializedName("hashrate_1h")
    @Expose
    private Double hashrate1h;
    @SerializedName("hashrate_24h")
    @Expose
    private Double hashrate24h;
    @SerializedName("valid_shares_five_min")
    @Expose
    private Integer validSharesFiveMin;
    @SerializedName("valid_shares_fifteen_min")
    @Expose
    private Integer validSharesFifteenMin;
    @SerializedName("valid_shares_one_hour")
    @Expose
    private Integer validSharesOneHour;
    @SerializedName("valid_shares_six_hour")
    @Expose
    private Integer validSharesSixHour;
    @SerializedName("valid_shares_one_day")
    @Expose
    private Integer validSharesOneDay;
    @SerializedName("invalid_shares_five_min")
    @Expose
    private Integer invalidSharesFiveMin;
    @SerializedName("invalid_shares_fifteen_min")
    @Expose
    private Integer invalidSharesFifteenMin;
    @SerializedName("invalid_shares_one_hour")
    @Expose
    private Integer invalidSharesOneHour;
    @SerializedName("invalid_shares_six_hour")
    @Expose
    private Integer invalidSharesSixHour;
    @SerializedName("invalid_shares_one_day")
    @Expose
    private Integer invalidSharesOneDay;
    @SerializedName("stale_shares_five_min")
    @Expose
    private Integer staleSharesFiveMin;
    @SerializedName("stale_shares_fifteen_min")
    @Expose
    private Integer staleSharesFifteenMin;
    @SerializedName("stale_shares_one_hour")
    @Expose
    private Integer staleSharesOneHour;
    @SerializedName("stale_shares_six_hour")
    @Expose
    private Integer staleSharesSixHour;
    @SerializedName("stale_shares_one_day")
    @Expose
    private Integer staleSharesOneDay;
    @SerializedName("payouts_five_min")
    @Expose
    private Integer payoutsFiveMin;
    @SerializedName("payouts_fifteen_min")
    @Expose
    private Integer payoutsFifteenMin;
    @SerializedName("payouts_one_hour")
    @Expose
    private Integer payoutsOneHour;
    @SerializedName("payouts_six_hour")
    @Expose
    private Double payoutsSixHour;
    @SerializedName("payouts_one_day")
    @Expose
    private Double payoutsOneDay;
    @SerializedName("total_payouts")
    @Expose
    private Double totalPayouts;
    @SerializedName("blocks_found")
    @Expose
    private Integer blocksFound;
    @SerializedName("last_share_time")
    @Expose
    private Integer lastShareTime;
    @SerializedName("payouts")
    @Expose
    private List<Payout> payouts = null;
    @SerializedName("miners")
    @Expose
    private List<Miner> miners = null;
    @SerializedName("hashrate")
    @Expose
    private List<Hashrate> hashrate = null;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Object getEstimatedBalance() {
        return estimatedBalance;
    }

    public void setEstimatedBalance(Object estimatedBalance) {
        this.estimatedBalance = estimatedBalance;
    }

    public Double getHashrate1h() {
        return hashrate1h;
    }

    public void setHashrate1h(Double hashrate1h) {
        this.hashrate1h = hashrate1h;
    }

    public Double getHashrate24h() {
        return hashrate24h;
    }

    public void setHashrate24h(Double hashrate24h) {
        this.hashrate24h = hashrate24h;
    }

    public Integer getValidSharesFiveMin() {
        return validSharesFiveMin;
    }

    public void setValidSharesFiveMin(Integer validSharesFiveMin) {
        this.validSharesFiveMin = validSharesFiveMin;
    }

    public Integer getValidSharesFifteenMin() {
        return validSharesFifteenMin;
    }

    public void setValidSharesFifteenMin(Integer validSharesFifteenMin) {
        this.validSharesFifteenMin = validSharesFifteenMin;
    }

    public Integer getValidSharesOneHour() {
        return validSharesOneHour;
    }

    public void setValidSharesOneHour(Integer validSharesOneHour) {
        this.validSharesOneHour = validSharesOneHour;
    }

    public Integer getValidSharesSixHour() {
        return validSharesSixHour;
    }

    public void setValidSharesSixHour(Integer validSharesSixHour) {
        this.validSharesSixHour = validSharesSixHour;
    }

    public Integer getValidSharesOneDay() {
        return validSharesOneDay;
    }

    public void setValidSharesOneDay(Integer validSharesOneDay) {
        this.validSharesOneDay = validSharesOneDay;
    }

    public Integer getInvalidSharesFiveMin() {
        return invalidSharesFiveMin;
    }

    public void setInvalidSharesFiveMin(Integer invalidSharesFiveMin) {
        this.invalidSharesFiveMin = invalidSharesFiveMin;
    }

    public Integer getInvalidSharesFifteenMin() {
        return invalidSharesFifteenMin;
    }

    public void setInvalidSharesFifteenMin(Integer invalidSharesFifteenMin) {
        this.invalidSharesFifteenMin = invalidSharesFifteenMin;
    }

    public Integer getInvalidSharesOneHour() {
        return invalidSharesOneHour;
    }

    public void setInvalidSharesOneHour(Integer invalidSharesOneHour) {
        this.invalidSharesOneHour = invalidSharesOneHour;
    }

    public Integer getInvalidSharesSixHour() {
        return invalidSharesSixHour;
    }

    public void setInvalidSharesSixHour(Integer invalidSharesSixHour) {
        this.invalidSharesSixHour = invalidSharesSixHour;
    }

    public Integer getInvalidSharesOneDay() {
        return invalidSharesOneDay;
    }

    public void setInvalidSharesOneDay(Integer invalidSharesOneDay) {
        this.invalidSharesOneDay = invalidSharesOneDay;
    }

    public Integer getStaleSharesFiveMin() {
        return staleSharesFiveMin;
    }

    public void setStaleSharesFiveMin(Integer staleSharesFiveMin) {
        this.staleSharesFiveMin = staleSharesFiveMin;
    }

    public Integer getStaleSharesFifteenMin() {
        return staleSharesFifteenMin;
    }

    public void setStaleSharesFifteenMin(Integer staleSharesFifteenMin) {
        this.staleSharesFifteenMin = staleSharesFifteenMin;
    }

    public Integer getStaleSharesOneHour() {
        return staleSharesOneHour;
    }

    public void setStaleSharesOneHour(Integer staleSharesOneHour) {
        this.staleSharesOneHour = staleSharesOneHour;
    }

    public Integer getStaleSharesSixHour() {
        return staleSharesSixHour;
    }

    public void setStaleSharesSixHour(Integer staleSharesSixHour) {
        this.staleSharesSixHour = staleSharesSixHour;
    }

    public Integer getStaleSharesOneDay() {
        return staleSharesOneDay;
    }

    public void setStaleSharesOneDay(Integer staleSharesOneDay) {
        this.staleSharesOneDay = staleSharesOneDay;
    }

    public Integer getPayoutsFiveMin() {
        return payoutsFiveMin;
    }

    public void setPayoutsFiveMin(Integer payoutsFiveMin) {
        this.payoutsFiveMin = payoutsFiveMin;
    }

    public Integer getPayoutsFifteenMin() {
        return payoutsFifteenMin;
    }

    public void setPayoutsFifteenMin(Integer payoutsFifteenMin) {
        this.payoutsFifteenMin = payoutsFifteenMin;
    }

    public Integer getPayoutsOneHour() {
        return payoutsOneHour;
    }

    public void setPayoutsOneHour(Integer payoutsOneHour) {
        this.payoutsOneHour = payoutsOneHour;
    }

    public Double getPayoutsSixHour() {
        return payoutsSixHour;
    }

    public void setPayoutsSixHour(Double payoutsSixHour) {
        this.payoutsSixHour = payoutsSixHour;
    }

    public Double getPayoutsOneDay() {
        return payoutsOneDay;
    }

    public void setPayoutsOneDay(Double payoutsOneDay) {
        this.payoutsOneDay = payoutsOneDay;
    }

    public Double getTotalPayouts() {
        return totalPayouts;
    }

    public void setTotalPayouts(Double totalPayouts) {
        this.totalPayouts = totalPayouts;
    }

    public Integer getBlocksFound() {
        return blocksFound;
    }

    public void setBlocksFound(Integer blocksFound) {
        this.blocksFound = blocksFound;
    }

    public Integer getLastShareTime() {
        return lastShareTime;
    }

    public void setLastShareTime(Integer lastShareTime) {
        this.lastShareTime = lastShareTime;
    }

    public List<Payout> getPayouts() {
        return payouts;
    }

    public void setPayouts(List<Payout> payouts) {
        this.payouts = payouts;
    }

    public List<Miner> getMiners() {
        return miners;
    }

    public void setMiners(List<Miner> miners) {
        this.miners = miners;
    }

    public List<Hashrate> getHashrate() {
        return hashrate;
    }

    public void setHashrate(List<Hashrate> hashrate) {
        this.hashrate = hashrate;
    }

}
