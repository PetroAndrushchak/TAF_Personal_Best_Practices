package com.petroandrushchak.client.base;

import feign.RequestLine;
import feign.Response;
import org.springframework.web.bind.annotation.RequestBody;


public interface ICollectionClient extends BaseApi {

    @RequestLine("POST /api/listing/collection")
    Response createCollection(@RequestBody final String body);

}
