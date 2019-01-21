
package pro.zackpollard.luxorexporter.api.types;

import lombok.Data;

import java.util.List;

@Data
public class LuxorApi {

    private String address;
    private Double balance;
    private Object estimatedBalance;
    private Double hashrate1h;
    private Double hashrate24h;
    private Integer validSharesFiveMin;
    private Integer validSharesFifteenMin;
    private Integer validSharesOneHour;
    private Integer validSharesSixHour;
    private Integer validSharesOneDay;
    private Integer invalidSharesFiveMin;
    private Integer invalidSharesFifteenMin;
    private Integer invalidSharesOneHour;
    private Integer invalidSharesSixHour;
    private Integer invalidSharesOneDay;
    private Integer staleSharesFiveMin;
    private Integer staleSharesFifteenMin;
    private Integer staleSharesOneHour;
    private Integer staleSharesSixHour;
    private Integer staleSharesOneDay;
    private Integer payoutsFiveMin;
    private Integer payoutsFifteenMin;
    private Integer payoutsOneHour;
    private Double payoutsSixHour;
    private Double payoutsOneDay;
    private Double totalPayouts;
    private Integer blocksFound;
    private Integer lastShareTime;
    private List<Payout> payouts = null;
    private List<Miner> miners = null;
    private List<Hashrate> hashrate = null;
}
