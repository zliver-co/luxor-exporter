package pro.zackpollard.luxorexporter;

import io.prometheus.client.Collector;
import io.prometheus.client.GaugeMetricFamily;
import pro.zackpollard.luxorexporter.api.rx.LuxorRxApi;
import pro.zackpollard.luxorexporter.api.types.LuxorApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuxorCollector extends Collector {

    private static final List<String> LABEL_NAMES = Arrays.asList("userHash");
    private static final List<String> LABEL_VALUES = Arrays.asList("ba1e9620ed77fb1cb323d9aa5943f1f8caae64e343f4239034dac925f6a0c30eac8e3bc716d0");
    private static final String LUXOR_BASE_URL = "https://mining.luxor.tech";

    @Override
    public List<MetricFamilySamples> collect() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LUXOR_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LuxorRxApi luxorRxApi = retrofit.create(LuxorRxApi.class);

        LuxorApi luxorApi = null;
        try {
            luxorApi = luxorRxApi.getUserStats("ba1e9620ed77fb1cb323d9aa5943f1f8caae64e343f4239034dac925f6a0c30eac8e3bc716d0").execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<MetricFamilySamples> mfs = new ArrayList<>();

        GaugeMetricFamily balanceGauge = new GaugeMetricFamily("balanceGauge", "Displays the current total balance of the account", LABEL_NAMES);
        balanceGauge.addMetric(LABEL_VALUES, luxorApi.getTotalPayouts()/Math.pow(10, 24));
        mfs.add(balanceGauge);

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