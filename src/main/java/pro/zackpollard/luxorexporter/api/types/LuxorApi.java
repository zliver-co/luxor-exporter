
package pro.zackpollard.luxorexporter.api.types;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class LuxorApi {

    private String address;
    private double balance;
    @SerializedName("blocks_found")
    private long blocksFound;
    @SerializedName("estimated_balance")
    private Object estimatedBalance;
    private List<Hashrate> hashrate;
    @SerializedName("hashrate_1h")
    private double hashrate1H;
    @SerializedName("hashrate_24h")
    private double hashrate24H;
    @SerializedName("invalid_shares_fifteen_min")
    private long invalidSharesFifteenMin;
    @SerializedName("invalid_shares_five_min")
    private long invalidSharesFiveMin;
    @SerializedName("invalid_shares_one_day")
    private long invalidSharesOneDay;
    @SerializedName("invalid_shares_one_hour")
    private long invalidSharesOneHour;
    @SerializedName("invalid_shares_six_hour")
    private long invalidSharesSixHour;
    @SerializedName("last_share_time")
    private long lastShareTime;
    private List<Miner> miners;
    private List<Payout> payouts;
    @SerializedName("payouts_fifteen_min")
    private long payoutsFifteenMin;
    @SerializedName("payouts_five_min")
    private long payoutsFiveMin;
    @SerializedName("payouts_one_day")
    private double payoutsOneDay;
    @SerializedName("payouts_one_hour")
    private long payoutsOneHour;
    @SerializedName("payouts_six_hour")
    private double payoutsSixHour;
    @SerializedName("stale_shares_fifteen_min")
    private long staleSharesFifteenMin;
    @SerializedName("stale_shares_five_min")
    private long staleSharesFiveMin;
    @SerializedName("stale_shares_one_day")
    private long staleSharesOneDay;
    @SerializedName("stale_shares_one_hour")
    private long staleSharesOneHour;
    @SerializedName("stale_shares_six_hour")
    private long staleSharesSixHour;
    @SerializedName("total_payouts")
    private double totalPayouts;
    @SerializedName("valid_shares_fifteen_min")
    private long validSharesFifteenMin;
    @SerializedName("valid_shares_five_min")
    private long validSharesFiveMin;
    @SerializedName("valid_shares_one_day")
    private long validSharesOneDay;
    @SerializedName("valid_shares_one_hour")
    private long validSharesOneHour;
    @SerializedName("valid_shares_six_hour")
    private long validSharesSixHour;

}
