
package pro.zackpollard.luxorexporter.api.types;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Payout {

    private String amount;
    private String time;
    @SerializedName("tx_id")
    private String txId;
    private String username;
}
