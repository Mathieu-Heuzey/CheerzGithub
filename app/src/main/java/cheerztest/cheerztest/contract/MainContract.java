package cheerztest.cheerztest.contract;

import java.util.List;

import cheerztest.cheerztest.presenter.vo.RepoVO;

/**
 * Created by Mateo on 02/07/2017.
 */
public interface MainContract {

    public interface View extends AbstractContrat.View {
        void displayRepos(List<RepoVO> repos);
    }

    public interface Presenter extends AbstractContrat.Presenter {
        void loadRepository(String user);
    }
}
