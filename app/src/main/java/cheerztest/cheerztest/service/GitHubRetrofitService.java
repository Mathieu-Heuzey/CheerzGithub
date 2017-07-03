package cheerztest.cheerztest.service;

import java.util.List;

import cheerztest.cheerztest.model.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Mateo on 02/07/2017.
 */
public interface GitHubRetrofitService {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}