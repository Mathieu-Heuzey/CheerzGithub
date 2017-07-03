package cheerztest.cheerztest.presenter;

import cheerztest.cheerztest.contract.AbstractContrat;
import cheerztest.cheerztest.event.BusProvider;

/**
 * Created by Mateo on 02/07/2017.
 */
public class AbstractPresenter<T extends AbstractContrat.View> implements AbstractContrat.Presenter{
    T view;

    public AbstractPresenter(T view) {
        this.view = view;
        BusProvider.register(this);
    }
}
