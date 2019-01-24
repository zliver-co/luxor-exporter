
package pro.zackpollard.luxorexporter.api.types.stats;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class LuxorStats {

    private long blocksFound;
    private double hashrate;
    private String price;
    private long totalMiners;
    private List<GlobalStat> globalStats;
}
