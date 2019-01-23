package pro.zackpollard.luxorexporter;

import io.prometheus.client.Collector;
import io.prometheus.client.GaugeMetricFamily;
import io.prometheus.client.Histogram;
import pro.zackpollard.luxorexporter.api.rx.LuxorRxApi;
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

        LuxorRxApi luxorRxApi = retrofit.create(LuxorRxApi.class);

        LuxorApi luxorApi = new LuxorApi();
        try {
            luxorApi = luxorRxApi.getUserStats("ba1e9620ed77fb1cb323d9aa5943f1f8caae64e343f4239034dac925f6a0c30eac8e3bc716d0").execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(luxorApi == null) throw new NullPointerException("LuxorAPI response was null");

        List<MetricFamilySamples> mfs = new ArrayList<>();

        GaugeMetricFamily balanceGauge = new GaugeMetricFamily("balance", "The current total balance of the account", BASE_LABEL_NAMES);
        balanceGauge.addMetric(BASE_LABEL_VALUES, luxorApi.getTotalPayouts());
        mfs.add(balanceGauge);

        GaugeMetricFamily blocksFoundGauge = new GaugeMetricFamily("blocks_found", "The total blocks that this account has found", BASE_LABEL_NAMES);
        blocksFoundGauge.addMetric(BASE_LABEL_VALUES, luxorApi.getBlocksFound());
        mfs.add(blocksFoundGauge);

        GaugeMetricFamily lastShareTimeGauge = new GaugeMetricFamily("last_share_time", "The timestamp of when the last share was received by luxor", BASE_LABEL_NAMES);
        lastShareTimeGauge.addMetric(BASE_LABEL_VALUES, luxorApi.getLastShareTime());
        mfs.add(lastShareTimeGauge);

        GaugeMetricFamily unpaidBalanceGauge = new GaugeMetricFamily("unpaid_balance", "The total unpaid balance on the account currently", BASE_LABEL_NAMES);
        unpaidBalanceGauge.addMetric(BASE_LABEL_VALUES, luxorApi.getBalance());
        mfs.add(unpaidBalanceGauge);

        GaugeMetricFamily minerLastShareTimeGauge = new GaugeMetricFamily("miner_last_share_time", "The timestamp of when the miner sent its last share", MINER_LABEL_NAMES);
        GaugeMetricFamily minerTotalSharesGauge = new GaugeMetricFamily("miner_total_shares", "Total shares sent to luxor by this miner", MINER_LABEL_NAMES);

        for(Miner miner : luxorApi.getMiners()) {
            List<String> minerLabelValues = new ArrayList<>(BASE_LABEL_VALUES);
            minerLabelValues.add(miner.getName());

            minerLastShareTimeGauge.addMetric(minerLabelValues, miner.getLastShareTime());
            minerTotalSharesGauge.addMetric(minerLabelValues, miner.getTotalShares());
        }

        mfs.add(minerLastShareTimeGauge);
        mfs.add(minerTotalSharesGauge);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        GaugeMetricFamily lastPayoutTimeGauge = new GaugeMetricFamily("last_Payout_time", "The timestamp of the last payout that was sent from luxor", BASE_LABEL_NAMES);
        try {
            lastPayoutTimeGauge.addMetric(BASE_LABEL_VALUES, df.parse(luxorApi.getPayouts().get(luxorApi.getPayouts().size() - 1).getTime()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mfs.add(lastPayoutTimeGauge);

        GaugeMetricFamily lastPayoutAmountGauge = new GaugeMetricFamily("last_payout_amount", "The amount of the last payout that was sent from luxor", BASE_LABEL_NAMES);
        lastPayoutAmountGauge.addMetric(BASE_LABEL_VALUES, Double.parseDouble(luxorApi.getPayouts().get(luxorApi.getPayouts().size() - 1).getAmount()));
        mfs.add(lastPayoutAmountGauge);

        GaugeMetricFamily hashrateGauge = new GaugeMetricFamily("hashrate", "The total hashrate of the account as observed by luxor", BASE_LABEL_NAMES);
        hashrateGauge.addMetric(BASE_LABEL_VALUES, luxorApi.getHashrate().get(luxorApi.getHashrate().size() - 1).getHashrate());
        mfs.add(hashrateGauge);

        return mfs;
    }
}

/**
 , a = function e(t) {
 var n = this;
 r(this, e),
 this.MH = "MH",
 this.GH = "GH",
 this.TH = "TH",
 this.BaseUnit = "DEFAULT",
 this.hashrateTH = function(e) {
 return e / 1e12
 }
 ,
 this.hashrateGH = function(e) {
 return e / 1e9
 }
 ,
 this.hashrateMH = function(e) {
 return e / 1e6
 }
 ,
 this.toBaseUnit = function(e) {
 return 1e24
 }
 ,
 this.validAddress = function(e) {
 return !1
 }
 ,
 this.parseHashrate = function(e) {
 return e <= 1e9 ? n.hashrateMH(e).toFixed(2) + " " + n.MH : e <= 1e12 ? n.hashrateGH(e).toFixed(2) + " " + n.GH : n.hashrateTH(e).toFixed(2) + " " + n.TH
 }
 ,
 this.parsePrice = function(e) {
 var t = parseFloat(e);
 return t > 1 ? "$" + t.toFixed(2) : "¢" + (100 * t).toFixed(2)
 }
 ,
 this.getStats = function() {
 return new Promise(function(e, t) {
 n.client.get("/stats").then(function(t) {
 return e(n.parseStats(t.data))
 }).catch(function(e) {
 return t(e)
 })
 }
 )
 }
 ,
 this.getMiners = function() {
 return new Promise(function(e, t) {
 n.client.get("/miners").then(function(t) {
 return e(n.parseMiners(t.data))
 }).catch(function(e) {
 return t(e)
 })
 }
 )
 }
 ,
 this.getBlocks = function() {
 return new Promise(function(e, t) {
 n.client.get("/blocks").then(function(t) {
 return e(t.data)
 }).catch(function(e) {
 return t(e)
 })
 }
 )
 }
 ,
 this.getAddress = function(e) {
 return new Promise(function(t, r) {
 n.client.get("/user/" + e).then(function(e) {
 return t(e.data)
 }).catch(function(e) {
 return r(e)
 })
 }
 )
 }
 ,
 this.parseStats = function(e) {
 return {
 price: n.parsePrice(e.price),
 hashrate: n.parseHashrate(parseInt(e.hashrate, 10)),
 blocksFound: e.blocksFound,
 totalMiners: e.totalMiners,
 globalStats: e.globalStats
 }
 }
 ,
 this.parseMiners = function(e) {
 return e.map(function(e) {
 return {
 hashrate: e.hashrate,
 validShares: e.validShares,
 invalidShares: e.invalidShares,
 lastActive: e.lastActive,
 address: e.address
 }
 })
 }
 ;
 var o = "/api/" + t;
 this.client = i.default.create({
 baseURL: o,
 timeout: 2e4
 })
 };
 t.default = a
 */