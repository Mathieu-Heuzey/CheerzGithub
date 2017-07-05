package cheerztest.cheerztest.presenter;

import android.support.annotation.NonNull;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import cheerztest.cheerztest.contract.MainContract;
import cheerztest.cheerztest.controller.RepositoryController;
import cheerztest.cheerztest.event.RepoListFailureEvent;
import cheerztest.cheerztest.event.RepoListSuccessEvent;
import cheerztest.cheerztest.model.Repo;
import cheerztest.cheerztest.presenter.vo.RepoVO;

/**
 * Created by Mateo on 02/07/2017.
 */
public class MainPresenter extends AbstractPresenter<MainContract.View> implements MainContract.Presenter {

    public MainPresenter(MainContract.View view) {
        super(view);
    }

    @Override
    public void loadRepository(@NonNull String user) {
        RepositoryController.getInstance().loadRepository(user);
    }

    @Subscribe
    public void onRepoLoaded(RepoListSuccessEvent event) {
        List<RepoVO> voList = new ArrayList<>();

        for (Repo repo : event.getRepos()) {
            RepoVO vo = new RepoVO();
            vo.name = repo.name;
            voList.add(vo);
        }
        this.view.displayRepos(voList);
    }

    @Subscribe
    public void onRepoLoadedFail(RepoListFailureEvent event) {
        this.view.displayErrorMsg(event.getErrorMsg());
    }
}
