package com.koala.app.client.data;

import io.socket.client.IO;
import io.socket.client.Socket;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by mrsfy on 22-Dec-16.
 */
public class SocketProvider {


    private static Socket socket;


    public static Socket getSocket() {

        if (socket == null){
            try {
                socket = IO.socket("http://localhost:8081");
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            socket.connect();
        }

        return socket;
    }


}
