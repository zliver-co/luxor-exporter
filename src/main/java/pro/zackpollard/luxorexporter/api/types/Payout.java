
package pro.zackpollard.luxorexporter.api.types;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payout {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("tx_id")
    @Expose
    private String txId;
    @SerializedName("time")
    @Expose
    private String time;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
