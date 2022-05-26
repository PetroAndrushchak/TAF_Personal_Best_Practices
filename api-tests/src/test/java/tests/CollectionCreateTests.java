package tests;

import com.petroandrushchak.client.CognitoClient;
import com.petroandrushchak.client.CollectionClient;
import com.petroandrushchak.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.base.TestBaseApi;

class CollectionCreateTests extends TestBaseApi {

    @Autowired
    CollectionClient collectionClient;

    @Autowired
    CognitoClient cognitoClient;

    @Test
    void createCollection() {
        User user = User.builder()
                .email("petroandrushchak@gmail.com")
                .password("eby9p9R$KFNMkij")
                .build();
        cognitoClient.login(user);
        collectionClient.createCollection();
    }

}
