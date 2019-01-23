
package pro.zackpollard.luxorexporter.api.types.stats;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class LuxorStats {

    private long blocksFound;
    private List<GlobalStat> globalStats;
    private double hashrate;
    private String price;
    private long totalMiners;
}
