package com.netcracker.models.enums;

import java.math.BigInteger;

public enum UserStatusActive {
    YES (new BigInteger("39")),
    NO (new BigInteger("40"));
    private BigInteger id ;

    UserStatusActive(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }
}
