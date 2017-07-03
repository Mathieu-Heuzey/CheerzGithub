package cheerztest.cheerztest.event;

import java.util.List;

import cheerztest.cheerztest.model.Repo;

/**
 * Created by Mateo on 02/07/2017.
 */
public class RepoListSuccessEvent {
    private List<Repo> repos;

    public RepoListSuccessEvent(List<Repo> repos) {
        this.repos = repos;
    }

    public List<Repo> getRepos() {
        return this.repos;
    }
}
