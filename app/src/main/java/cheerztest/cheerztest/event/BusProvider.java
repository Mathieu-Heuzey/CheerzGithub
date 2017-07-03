package cheerztest.cheerztest.event;

import com.squareup.otto.Bus;

/**
 * Created by Mateo on 02/07/2017.
 */
public final class BusProvider {
    private final static Bus instance = new Bus();

    private BusProvider() {
    }

    public static Bus getInstance() {
        return BusProvider.instance;
    }

    public static void register(Object object) {
        getInstance().register(object);
    }
    public static void unregister(Object object) {
        getInstance().unregister(object);
    }
    public static void post(Object event) {
        getInstance().post(event);
    }

    //la c'est pas le cas, mais faut faire gaffe que l'event soit bien dispatch dans l'ui thread, sinon ca va peter quand on call la view et qu'on fait des modifs sur l'ui
}
