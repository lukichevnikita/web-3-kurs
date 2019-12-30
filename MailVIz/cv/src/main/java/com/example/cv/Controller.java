package com.example.cv;


import okhttp3.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class Controller {
    private final static String token = "bBQf5zagNVo4dUJ1jsXS7TL3NmG7brazWFzQNL9c9KxusFCkL";
    private final static String provider = "mcs";

    @GetMapping("/getCV")
    public String cv() throws IOException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://smarty.mail.ru/api/v1/objects/detect?oauth_provider="+provider+"&oauth_token="+token).newBuilder();

        String url = urlBuilder.build().toString();
        File file = new File("C:/Users/07021/Desktop/kak-pokupat-cherez-internet.jpg");

        okhttp3.RequestBody formBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("meta", "{\"mode\":[\"multiobject\"],\"images\":[{\"name\":\"file_0\"}]}")
                .addFormDataPart("file_0", file.getName(), okhttp3.RequestBody.create(MediaType.parse("multipart/form-data"), file))
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Ошибка: " + response);
        }

        return response.body().string();
    }
}
