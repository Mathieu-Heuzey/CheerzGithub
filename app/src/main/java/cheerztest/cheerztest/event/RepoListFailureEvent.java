package cheerztest.cheerztest.event;

/**
 * Created by Mateo on 02/07/2017.
 */
public class RepoListFailureEvent {
    private String errorMsg;

    public RepoListFailureEvent(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
