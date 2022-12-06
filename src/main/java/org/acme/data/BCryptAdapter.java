package org.acme.data;

import jodd.crypt.BCrypt;

public class BCryptAdapter implements Encrypter {
    @Override
    public String hash(String plain) {
        return BCrypt.hashpw(plain, BCrypt.gensalt());
    }
}
