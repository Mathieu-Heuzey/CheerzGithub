package cheerztest.cheerztest.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
