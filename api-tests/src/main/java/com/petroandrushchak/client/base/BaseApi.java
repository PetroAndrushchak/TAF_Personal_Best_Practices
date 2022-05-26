package com.petroandrushchak.client.base;

import feign.Headers;

@Headers({
        "Content-Type: application/json",
        "Accept: application/json"
})
public interface BaseApi {


}
