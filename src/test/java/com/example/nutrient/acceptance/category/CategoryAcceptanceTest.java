package com.example.nutrient.acceptance.category;

import com.example.nutrient.acceptance.AcceptanceTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.UUID;

import static com.example.nutrient.acceptance.category.CategorySteps.*;

public class CategoryAcceptanceTest extends AcceptanceTest {

    @DisplayName("카테고리를 관리한다.")
    @Test
    void manage(){
        ExtractableResponse<Response> createParentResponse = 카테고리_생성_요청("비타민");
        카테고리_생성됨(createParentResponse.statusCode());
        ExtractableResponse<Response> createResponse = 카테고리_자식_생성_요청("비타민D",1);
        카테고리_자식_생성됨(createResponse.statusCode());

        UUID 비타민D = createResponse.response().jsonPath().getUUID("id");

        ExtractableResponse<Response> updateParentResponse = 카테고리_수정_요청(비타민D, "비타민C", 1);
        카테고리_수정됨(updateParentResponse.statusCode());

    }
}
