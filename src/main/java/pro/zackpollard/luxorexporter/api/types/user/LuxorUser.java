
package pro.zackpollard.luxorexporter.api.types.user;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class LuxorUser {

    private String address;
    private double balance;
    @SerializedName("blocks_found")
    private double blocksFound;
    @SerializedName("estimated_balance")
    private double estimatedBalance;
    @SerializedName("hashrate_1h")
    private double hashrate1H;
    @SerializedName("hashrate_24h")
    private double hashrate24H;
    @SerializedName("invalid_shares_fifteen_min")
    private double invalidSharesFifteenMin;
    @SerializedName("invalid_shares_five_min")
    private double invalidSharesFiveMin;
    @SerializedName("invalid_shares_one_day")
    private double invalidSharesOneDay;
    @SerializedName("invalid_shares_one_hour")
    private double invalidSharesOneHour;
    @SerializedName("invalid_shares_six_hour")
    private double invalidSharesSixHour;
    @SerializedName("last_share_time")
    private double lastShareTime;
    @SerializedName("payouts_fifteen_min")
    private double payoutsFifteenMin;
    @SerializedName("payouts_five_min")
    private double payoutsFiveMin;
    @SerializedName("payouts_one_day")
    private double payoutsOneDay;
    @SerializedName("payouts_one_hour")
    private double payoutsOneHour;
    @SerializedName("payouts_six_hour")
    private double payoutsSixHour;
    @SerializedName("stale_shares_fifteen_min")
    private double staleSharesFifteenMin;
    @SerializedName("stale_shares_five_min")
    private double staleSharesFiveMin;
    @SerializedName("stale_shares_one_day")
    private double staleSharesOneDay;
    @SerializedName("stale_shares_one_hour")
    private double staleSharesOneHour;
    @SerializedName("stale_shares_six_hour")
    private double staleSharesSixHour;
    @SerializedName("total_payouts")
    private double totalPayouts;
    @SerializedName("valid_shares_fifteen_min")
    private double validSharesFifteenMin;
    @SerializedName("valid_shares_five_min")
    private double validSharesFiveMin;
    @SerializedName("valid_shares_one_day")
    private double validSharesOneDay;
    @SerializedName("valid_shares_one_hour")
    private double validSharesOneHour;
    @SerializedName("valid_shares_six_hour")
    private double validSharesSixHour;
    private List<Miner> miners;
    private List<Payout> payouts;
    private List<Hashrate> hashrate;
}
