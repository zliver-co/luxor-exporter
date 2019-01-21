package pro.zackpollard.luxorexporter.api.rx;

import pro.zackpollard.luxorexporter.api.types.LuxorApi;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

import java.util.List;

public interface LuxorRxApi {

    @GET("/api/SC/user/{userHash}")
    Observable<LuxorApi> getUserStats(@Path("userHash") String userHash);
}
