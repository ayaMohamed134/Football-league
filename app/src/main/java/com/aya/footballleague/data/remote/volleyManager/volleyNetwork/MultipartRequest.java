package com.aya.footballleague.data.remote.volleyManager.volleyNetwork;

import android.util.Log;
import android.webkit.MimeTypeMap;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by aya mohamed on 5/27/2018.
 */

public class MultipartRequest extends Request<NetworkResponse> {
    private final Response.Listener<NetworkResponse> mListener;
    private final Response.ErrorListener mErrorListener;
    private final Map<String, String> mHeaders;
    private HttpEntity mHttpEntity;



    public MultipartRequest(String url, Response.Listener<NetworkResponse> listener, Response.ErrorListener errorListener, Map<String, String> params
            , Map<String, File> files, Map<String, String> mHeaders) {
        super(Method.POST, url, errorListener);
        this.mListener = listener;
        this.mErrorListener = errorListener;
        this.mHeaders = mHeaders;
        this.mHttpEntity = buildMultipartEntity(files);
        System.out.println(mHttpEntity.getContentType().getName() + " " + mHttpEntity.getContentType().getValue());
        this.mHeaders.put(mHttpEntity.getContentType().getName(), mHttpEntity.getContentType().getValue());
        this.mHeaders.put("cache-control", "no-cache");
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return (mHeaders != null) ? mHeaders : super.getHeaders();
    }


    private HttpEntity buildMultipartEntity(Map<String, File>  files) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();


        for (String key : files.keySet()){
            String pathtoimage= ""+ files.get(key);
            File externalFile = new File(pathtoimage);
            Log.i("f", key + " " + externalFile);
            FileBody fileBody = new FileBody(externalFile);
            //builder.addPart(key, fileBody);
            String extension = MimeTypeMap.getFileExtensionFromUrl(externalFile.getPath());
            Log.i("extension", "ext:" + extension);
            builder.addBinaryBody(key, externalFile,
                    ContentType.create(MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)),
                    externalFile.getName());
        }

        return builder.build();
    }

    @Override
    public String getBodyContentType() {
        return mHttpEntity.getContentType().getValue();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            mHttpEntity.writeTo(bos);
        } catch (IOException e) {
            VolleyLog.e("IOException writing to ByteArrayOutputStream");
        }
        return bos.toByteArray();
    }


    @Override
    protected Response<NetworkResponse> parseNetworkResponse(NetworkResponse response) {
        try {
            return Response.success(
                    response,
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (Exception e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(NetworkResponse response) {
        mListener.onResponse(response);
    }

    @Override
    public void deliverError(VolleyError error) {
        mErrorListener.onErrorResponse(error);
    }
}
