
package pro.zackpollard.luxorexporter.api.types;

import lombok.Data;

@Data
public class Miner {

    private String name;
    private String affinity;
    private String minerType;
    private Integer lastShareTime;
    private Double totalShares;
    private Double hashrateFiveMin;
    private Double hashrateFifteenMin;
    private Double hashrateOneHour;
    private Double hashrateSixHour;
    private Double hashrateOneDay;
    private Integer staleFiveMin;
    private Integer staleFifteenMin;
    private Integer staleOneHour;
    private Integer staleSixHour;
    private Integer staleOneDay;
    private String revenueFiveMin;
    private String revenueFifteenMin;
    private String revenueOneHour;
    private String revenueSixHour;
    private String revenueOneDay;
}
