package com.cloudmanager.apis.helper;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;


public class ByteBufferToString {

    public static String convertByteBufferToString(ByteBuffer buffer, Charset charset) {
        byte[] bytes;
        if (buffer.hasArray()) {
            bytes = buffer.array();
        } else {
            bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
        }
        return new String(bytes, charset);
    }
}
