package com.otus.firstopenlesson.services;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Base64;

@RequiredArgsConstructor
public class EncodeService {

    private Encoder encoder;

    public byte[] encode(byte[] hash) {
        byte[] safe = Arrays.copyOf(hash, hash.length);
        return encodeInner(safe, 0);
    }

    private byte[] encodeInner(byte[] hash, int level) {
        byte[] result;
        try {
            result = encoder.encode(hash);

        } catch (Exception e) {
            long count = ExceptionUtils.countException(e);
            ExceptionUtils.acceptCount(count);

            result = Base64.getEncoder().encode(hash);
        }

        return result;
    }
}
