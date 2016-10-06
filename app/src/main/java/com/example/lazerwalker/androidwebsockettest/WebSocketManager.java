package com.example.lazerwalker.androidwebsockettest;

import java.util.*;
import android.util.*;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.http.server.*;
import com.koushikdutta.async.http.*;
import com.koushikdutta.async.callback.*;
import com.koushikdutta.async.http.WebSocket.*;
import com.koushikdutta.async.http.server.AsyncHttpServer.*;

/**
 * Created by lazerwalker on 10/1/16.
 */

public class WebSocketManager {
    private WebSocket host = null;

    private AsyncHttpServer server;

    public WebSocketManager() {
        server = new AsyncHttpServer();
        server.websocket("/", new WebSocketRequestCallback() {
            @Override
            public void onConnected(final WebSocket webSocket, AsyncHttpServerRequest request) {
                Log.i("websocket", "Connected client");

                webSocket.setStringCallback(new StringCallback() {
                    @Override
                    public void onStringAvailable(String s) {
                        Log.i("websocket", "Received message: " + s);
                        webSocket.send(s);
                    }
                });

                webSocket.setDataCallback(new DataCallback() {
                    @Override
                    public void onDataAvailable(DataEmitter emitter, ByteBufferList bb) {

                    }
                });

                webSocket.setPingCallback(new PingCallback() {
                    @Override
                    public void onPingReceived(String s) {
                        Log.i("websocket", "Received ping: " + s);
                    }
                });
            }
        });
    }

    public void listen(int port) {
        server.listen(port);
    }
}