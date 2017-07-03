package cheerztest.cheerztest.service;

/**
 * Created by Mateo on 02/07/2017.
 */
public interface NetworkCallback<T> {

    void onSuccess(T result);

    void onError(int httpCode, String bodyError);
}
