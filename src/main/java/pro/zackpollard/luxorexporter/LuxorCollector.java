package pro.zackpollard.luxorexporter;

import io.prometheus.client.Collector;
import io.prometheus.client.GaugeMetricFamily;
import pro.zackpollard.luxorexporter.api.rx.LuxorRetrofitApi;
import pro.zackpollard.luxorexporter.api.types.LuxorApi;
import pro.zackpollard.luxorexporter.api.types.Miner;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LuxorCollector extends Collector {

    private static final List<String> BASE_LABEL_NAMES = Arrays.asList("user_hash");
    private static final List<String> BASE_LABEL_VALUES = Arrays.asList("ba1e9620ed77fb1cb323d9aa5943f1f8caae64e343f4239034dac925f6a0c30eac8e3bc716d0");
    private static final List<String> MINER_LABEL_NAMES = Arrays.asList("user_hash", "miner_name");
    private static final String LUXOR_BASE_URL = "https://mining.luxor.tech";

    @Override
    public List<MetricFamilySamples> collect() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LUXOR_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LuxorRetrofitApi luxorRetrofitApi = retrofit.create(LuxorRetrofitApi.class);

        LuxorApi luxorApi = new LuxorApi();
        try {
            luxorApi = luxorRetrofitApi.getUserStats("ba1e9620ed77fb1cb323d9aa5943f1f8caae64e343f4239034dac925f6a0c30eac8e3bc716d0").execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(luxorApi == null) throw new NullPointerException("LuxorAPI response was null");

        List<MetricFamilySamples> mfs = new ArrayList<>();

        GaugeMetricFamily balanceGauge = new GaugeMetricFamily("luxor_balance", "The current total balance of the account", BASE_LABEL_NAMES);
        balanceGauge.addMetric(BASE_LABEL_VALUES, luxorApi.getTotalPayouts());
        mfs.add(balanceGauge);

        GaugeMetricFamily blocksFoundGauge = new GaugeMetricFamily("luxor_blocks_found", "The total blocks that this account has found", BASE_LABEL_NAMES);
        blocksFoundGauge.addMetric(BASE_LABEL_VALUES, luxorApi.getBlocksFound());
        mfs.add(blocksFoundGauge);

        GaugeMetricFamily lastShareTimeGauge = new GaugeMetricFamily("luxor_last_share_time", "The timestamp of when the last share was received by luxor", BASE_LABEL_NAMES);
        lastShareTimeGauge.addMetric(BASE_LABEL_VALUES, luxorApi.getLastShareTime());
        mfs.add(lastShareTimeGauge);

        GaugeMetricFamily unpaidBalanceGauge = new GaugeMetricFamily("luxor_unpaid_balance", "The total unpaid balance on the account currently", BASE_LABEL_NAMES);
        unpaidBalanceGauge.addMetric(BASE_LABEL_VALUES, luxorApi.getBalance());
        mfs.add(unpaidBalanceGauge);

        GaugeMetricFamily minerLastShareTimeGauge = new GaugeMetricFamily("luxor_miner_last_share_time", "The timestamp of when the miner sent its last share", MINER_LABEL_NAMES);
        GaugeMetricFamily minerTotalSharesGauge = new GaugeMetricFamily("luxor_miner_total_shares", "Total shares sent to luxor by this miner", MINER_LABEL_NAMES);

        for(Miner miner : luxorApi.getMiners()) {
            List<String> minerLabelValues = new ArrayList<>(BASE_LABEL_VALUES);
            minerLabelValues.add(miner.getName());

            minerLastShareTimeGauge.addMetric(minerLabelValues, miner.getLastShareTime());
            minerTotalSharesGauge.addMetric(minerLabelValues, miner.getTotalShares());
        }

        mfs.add(minerLastShareTimeGauge);
        mfs.add(minerTotalSharesGauge);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        GaugeMetricFamily lastPayoutTimeGauge = new GaugeMetricFamily("luxor_last_payout_time", "The timestamp of the last payout that was sent from luxor", BASE_LABEL_NAMES);
        try {
            lastPayoutTimeGauge.addMetric(BASE_LABEL_VALUES, df.parse(luxorApi.getPayouts().get(luxorApi.getPayouts().size() - 1).getTime()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mfs.add(lastPayoutTimeGauge);

        GaugeMetricFamily lastPayoutAmountGauge = new GaugeMetricFamily("luxor_last_payout_amount", "The amount of the last payout that was sent from luxor", BASE_LABEL_NAMES);
        lastPayoutAmountGauge.addMetric(BASE_LABEL_VALUES, Double.parseDouble(luxorApi.getPayouts().get(luxorApi.getPayouts().size() - 1).getAmount()));
        mfs.add(lastPayoutAmountGauge);

        GaugeMetricFamily hashrateGauge = new GaugeMetricFamily("luxor_hashrate", "The total hashrate of the account as observed by luxor", BASE_LABEL_NAMES);
        hashrateGauge.addMetric(BASE_LABEL_VALUES, luxorApi.getHashrate().get(luxorApi.getHashrate().size() - 1).getHashrate());
        mfs.add(hashrateGauge);

        return mfs;
    }
}