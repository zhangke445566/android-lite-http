package com.litesuits.http.request;

import android.graphics.Bitmap;
import com.litesuits.http.parser.impl.BitmapParser;
import com.litesuits.http.request.param.HttpParamModel;

import java.io.File;

/**
 * @author MaTianyu
 * @date 2015-04-18
 */
public class BitmapRequest extends AbstractRequest<Bitmap> {

    protected File saveToFile;

    protected BitmapParser bitmapParser;

//    public BitmapRequest() {
//        super();
//    }

    public BitmapRequest(HttpParamModel model) {
        super(model);
    }

    public BitmapRequest(HttpParamModel model, File saveToFile) {
        super(model);
        this.saveToFile = saveToFile;
    }

    public BitmapRequest(HttpParamModel model, String saveToPath) {
        super(model);
        setFileSavePath(saveToPath);
    }

    public BitmapRequest(String url) {
        super(url);
    }

    public BitmapRequest(String url, File saveToFile) {
        super(url);
        this.saveToFile = saveToFile;
    }

    public BitmapRequest(String url, String saveToPath) {
        super(url);
        setFileSavePath(saveToPath);
    }


    public BitmapRequest setFileSavePath(String savaToPath) {
        if (savaToPath != null) {
            saveToFile = new File(savaToPath);
        }
        return this;
    }

    @Override
    public BitmapParser getDataParser() {
        if (bitmapParser == null) {
            bitmapParser = new BitmapParser(this, saveToFile);
        }
        return bitmapParser;
    }
}
