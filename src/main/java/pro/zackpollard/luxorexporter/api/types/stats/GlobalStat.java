
package pro.zackpollard.luxorexporter.api.types.stats;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.math.BigInteger;

@Data
@SuppressWarnings("unused")
public class GlobalStat {

    @SerializedName("btc_price")
    private String btcPrice;
    @SerializedName("coin_price")
    private String coinPrice;
    @SerializedName("network_difficulty")
    private double networkDifficulty;
    @SerializedName("network_hashrate")
    private long networkHashrate;
    @SerializedName("pool_hashrate")
    private double poolHashrate;
    private String time;
    private long workers;

}
