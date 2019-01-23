package pro.zackpollard.luxorexporter.api.rx;

import pro.zackpollard.luxorexporter.api.types.LuxorApi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LuxorRetrofitApi {

    @GET("/api/SC/user/{userHash}")
    Call<LuxorApi> getUserStats(@Path("userHash") String userHash);
}
