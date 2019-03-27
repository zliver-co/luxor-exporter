package pro.zackpollard.luxorexporter;

import io.prometheus.client.Collector;
import io.prometheus.client.GaugeMetricFamily;
import pro.zackpollard.luxorexporter.api.rx.LuxorRetrofitApi;
import pro.zackpollard.luxorexporter.api.types.stats.LuxorStats;
import pro.zackpollard.luxorexporter.api.types.user.LuxorUser;
import pro.zackpollard.luxorexporter.api.types.user.Miner;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LuxorCollector extends Collector {

    private static final List<String> USER_LABEL_NAMES = Arrays.asList("user_hash");
    private static final List<String> USER_LABEL_VALUES = Arrays.asList("ba1e9620ed77fb1cb323d9aa5943f1f8caae64e343f4239034dac925f6a0c30eac8e3bc716d0");
    private static final List<String> MINER_LABEL_NAMES = Arrays.asList("user_hash", "miner_name");
    private static final String LUXOR_BASE_URL = "https://mining.luxor.tech";

    @Override
    public List<MetricFamilySamples> collect() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LUXOR_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LuxorRetrofitApi luxorRetrofitApi = retrofit.create(LuxorRetrofitApi.class);

        LuxorUser luxorUser = new LuxorUser();
        LuxorStats luxorStats = new LuxorStats();
        try {
            luxorUser = luxorRetrofitApi.getUser("ba1e9620ed77fb1cb323d9aa5943f1f8caae64e343f4239034dac925f6a0c30eac8e3bc716d0").execute().body();
            luxorStats = luxorRetrofitApi.getStats().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(luxorUser == null || luxorStats == null) throw new NullPointerException("LuxorAPI response was null");

        List<MetricFamilySamples> mfs = new ArrayList<>();

        //User Stats

        GaugeMetricFamily balanceGauge = new GaugeMetricFamily("luxor_user_balance", "The current total balance of the account", USER_LABEL_NAMES);
        balanceGauge.addMetric(USER_LABEL_VALUES, luxorUser.getTotalPayouts());
        mfs.add(balanceGauge);

        GaugeMetricFamily usdBalanceGauge = new GaugeMetricFamily("luxor_user_balance_usd", "The current total balance of the account in USD", USER_LABEL_NAMES);
        usdBalanceGauge.addMetric(USER_LABEL_VALUES, luxorUser.getTotalPayouts() * luxorStats.getPrice());
        mfs.add(usdBalanceGauge);

        GaugeMetricFamily blocksFoundGauge = new GaugeMetricFamily("luxor_user_blocks_found", "The total blocks that this account has found", USER_LABEL_NAMES);
        blocksFoundGauge.addMetric(USER_LABEL_VALUES, luxorUser.getBlocksFound());
        mfs.add(blocksFoundGauge);

        GaugeMetricFamily lastShareTimeGauge = new GaugeMetricFamily("luxor_user_last_share_time", "The timestamp of when the last share was received by luxor", USER_LABEL_NAMES);
        lastShareTimeGauge.addMetric(USER_LABEL_VALUES, luxorUser.getLastShareTime());
        mfs.add(lastShareTimeGauge);

        GaugeMetricFamily unpaidBalanceGauge = new GaugeMetricFamily("luxor_user_unpaid_balance", "The total unpaid balance on the account currently", USER_LABEL_NAMES);
        unpaidBalanceGauge.addMetric(USER_LABEL_VALUES, luxorUser.getBalance());
        mfs.add(unpaidBalanceGauge);

        GaugeMetricFamily minerLastShareTimeGauge = new GaugeMetricFamily("luxor_user_miner_last_share_time", "The timestamp of when the miner sent its last share", MINER_LABEL_NAMES);
        GaugeMetricFamily minerTotalSharesGauge = new GaugeMetricFamily("luxor_user_miner_total_shares", "Total shares sent to luxor by this miner", MINER_LABEL_NAMES);

        for(Miner miner : luxorUser.getMiners()) {
            List<String> minerLabelValues = new ArrayList<>(USER_LABEL_VALUES);
            minerLabelValues.add(miner.getName());

            minerLastShareTimeGauge.addMetric(minerLabelValues, miner.getLastShareTime());
            minerTotalSharesGauge.addMetric(minerLabelValues, miner.getTotalShares());
        }

        mfs.add(minerLastShareTimeGauge);
        mfs.add(minerTotalSharesGauge);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        GaugeMetricFamily lastPayoutTimeGauge = new GaugeMetricFamily("luxor_user_last_payout_time", "The timestamp of the last payout that was sent from luxor", USER_LABEL_NAMES);
        try {
            lastPayoutTimeGauge.addMetric(USER_LABEL_VALUES, df.parse(luxorUser.getPayouts().get(luxorUser.getPayouts().size() - 1).getTime()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mfs.add(lastPayoutTimeGauge);

        GaugeMetricFamily lastPayoutAmountGauge = new GaugeMetricFamily("luxor_user_last_payout_amount", "The amount of the last payout that was sent from luxor", USER_LABEL_NAMES);
        lastPayoutAmountGauge.addMetric(USER_LABEL_VALUES, Double.parseDouble(luxorUser.getPayouts().get(luxorUser.getPayouts().size() - 1).getAmount()));
        mfs.add(lastPayoutAmountGauge);

        GaugeMetricFamily hashrateGauge = new GaugeMetricFamily("luxor_user_hashrate", "The total hashrate of the account as observed by luxor", USER_LABEL_NAMES);
        hashrateGauge.addMetric(USER_LABEL_VALUES, luxorUser.getHashrate().get(luxorUser.getHashrate().size() - 1).getHashrate());
        mfs.add(hashrateGauge);

        //Global Stats

        GaugeMetricFamily globalBlocksGauge = new GaugeMetricFamily("luxor_global_blocks_found", "The total blocks found by the entire luxor siacoin pool", luxorStats.getBlocksFound());
        mfs.add(globalBlocksGauge);

        GaugeMetricFamily globalHashrateGauge = new GaugeMetricFamily("luxor_global_hashrate", "The total hashrate of the entire luxor network", luxorStats.getHashrate());
        mfs.add(globalHashrateGauge);

        GaugeMetricFamily globalPriceGauge = new GaugeMetricFamily("luxor_global_siacoin_price", "The current price of siacoin in USD", luxorStats.getPrice());
        mfs.add(globalPriceGauge);

        GaugeMetricFamily globalTotalMiners = new GaugeMetricFamily("luxor_global_total_miners", "The total amount of miners on the luxor pool currently", luxorStats.getTotalMiners());
        mfs.add(globalTotalMiners);

        GaugeMetricFamily globalTotalDifficulty = new GaugeMetricFamily("luxor_global_difficulty", "The current difficulty of the siacoin network", luxorStats.getGlobalStats().get(luxorStats.getGlobalStats().size() - 1).getNetworkDifficulty());
        mfs.add(globalTotalDifficulty);

        return mfs;
    }
}