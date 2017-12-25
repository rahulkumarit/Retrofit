package com.rnd.retofitsample.enums;

import com.rnd.retofitsample.interfaces.WsResponse;
import com.rnd.retofitsample.models.Category;
import com.rnd.retofitsample.models.SubCategory;

import static android.R.attr.x;
import static android.R.attr.y;

/**
 * Created by Devrepublic-14 on 7/20/2017.
 */

public enum WSTypeCasting {
    WS_CATGORY,
    WS_SUB_CATGORY,
    WS_SUB_POEMS,
    WS_SUB_LINES;

    WsResponse typeCast() {
        switch (this) {
            case WS_CATGORY:
                return new Category();
            case WS_SUB_CATGORY:
                return new SubCategory();
            case WS_SUB_POEMS:
//                return x * y;
            case WS_SUB_LINES:
//                return x / y;
            default:
                throw new AssertionError("Unknown operations " + this);
        }
    }


}
