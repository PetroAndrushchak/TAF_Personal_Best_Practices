package com.petroandrushchak.client;

import com.petroandrushchak.client.base.ICollectionClient;
import feign.Contract;
import feign.Logger;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Import(FeignClientsConfiguration.class)
@Component
public class CollectionClient extends AuthApiClient {

    private ICollectionClient collectionClient;

    @Autowired
    public CollectionClient(Decoder decoder, Encoder encoder, Contract contract, Logger.Level level) {
        super(level);
        this.collectionClient = createBaseFeignBuilder()
                .target(ICollectionClient.class, "https://www.realtyaustin.com/");
    }

    public void createCollection() {
        Response response = collectionClient.createCollection("{\"name\":\"TestPetroSpringFeine\",\"description\":\"\",\"listings\":[]}");
        System.out.println("dsfsdf");
    }
}
