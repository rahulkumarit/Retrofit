package com.rnd.retofitsample.wsutils;

/**
 * Created by Devrepublic-14 on 7/14/2017.
 */

public interface JsonResponse<T> {

    public void successResponse(T response, int code);
    public void failureRespons(Throwable error, int code);

}




