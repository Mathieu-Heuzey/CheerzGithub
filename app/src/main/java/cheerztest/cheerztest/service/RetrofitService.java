package cheerztest.cheerztest.service;

import java.io.IOException;
import java.util.List;

import cheerztest.cheerztest.model.Repo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Mateo on 02/07/2017.
 */
public class RetrofitService {
    Retrofit retrofit;
    GitHubRetrofitService service;

    public RetrofitService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(GitHubRetrofitService.class);
    }

    public void requestRepository(String user, final NetworkCallback<List<Repo>> callback) {
        Call<List<Repo>> repos = service.listRepos(user);
        repos.enqueue(new retrofit2.Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if(response.isSuccessful()) {
                    List<Repo> repoList = response.body();
                    callback.onSuccess(repoList);
                } else {
                    try {
                        //TODO check if errorBody not null
                        ResponseBody errorBody = response.errorBody();
                        String errorMsg = errorBody.string();
                        //TODO parse error and get error msg
                        callback.onError(response.code(), errorMsg);
                    } catch (IOException e) {
                        //TODO handle properly and call
                        //TODO mettre un msg qui correct -> unexpected error si ca rentre dans le catch
                        e.printStackTrace();
                        callback.onError(response.code(), null /*TODO*/);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                //i.e No internet
                //TODO proper msg
                callback.onError(0, null);
            }
        });
    }
}
