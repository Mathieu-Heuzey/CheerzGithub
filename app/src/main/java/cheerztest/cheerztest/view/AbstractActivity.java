package cheerztest.cheerztest.view;

import android.app.Activity;
import android.os.Bundle;

import cheerztest.cheerztest.contract.AbstractContrat;

/**
 * Created by Mateo on 02/07/2017.
 */
public abstract class AbstractActivity<P extends AbstractContrat.Presenter> extends Activity implements AbstractContrat.View {

    protected P presenter;

    protected abstract P newPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = this.newPresenter();
    }

    @Override
    public void displayErrorMsg(String msg) {
        //TODO dialog avec msg and title "Error", and a button "ok" and cancelable true
        msg.isEmpty();
    }
}
