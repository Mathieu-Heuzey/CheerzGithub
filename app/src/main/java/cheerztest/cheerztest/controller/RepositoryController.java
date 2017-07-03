package cheerztest.cheerztest.controller;

import android.support.annotation.NonNull;

import java.util.List;

import cheerztest.cheerztest.event.BusProvider;
import cheerztest.cheerztest.event.RepoListFailureEvent;
import cheerztest.cheerztest.event.RepoListSuccessEvent;
import cheerztest.cheerztest.model.Repo;
import cheerztest.cheerztest.service.NetworkCallback;
import cheerztest.cheerztest.service.RetrofitService;

/**
 * Created by Mateo on 02/07/2017.
 */
public class RepositoryController {
    RetrofitService retrofitService;

    //Singleton implementation
    private static RepositoryController instance = new RepositoryController();

    private RepositoryController() {
        retrofitService = new RetrofitService();
    }

    public static RepositoryController getInstance() {
        return instance;
    }

    public void loadRepository(@NonNull String user) {
        retrofitService.requestRepository(user, new NetworkCallback<List<Repo>>() {
            @Override
            public void onSuccess(List<Repo> result) {
                BusProvider.post(new RepoListSuccessEvent(result));
            }

            @Override
            public void onError(int httpCode, String errorMsg) {
                BusProvider.post(new RepoListFailureEvent(errorMsg));
            }
        });
    }
}
