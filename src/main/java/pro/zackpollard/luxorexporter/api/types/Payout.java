
package pro.zackpollard.luxorexporter.api.types;

import lombok.Data;

@Data
public class Payout {

    private String username;
    private String amount;
    private String txId;
    private String time;
}
