package pro.zackpollard.luxorexporter.api.rx;

import pro.zackpollard.luxorexporter.api.types.stats.LuxorStats;
import pro.zackpollard.luxorexporter.api.types.user.LuxorUser;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LuxorRetrofitApi {

    @GET("/api/SC/user/{userHash}")
    Call<LuxorUser> getUser(@Path("userHash") String userHash);

    @GET("/api/SC/stats")
    Call<LuxorStats> getStats();
}
