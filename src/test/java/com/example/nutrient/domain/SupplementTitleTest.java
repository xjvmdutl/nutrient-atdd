package com.example.nutrient.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class SupplementTitleTest {
    @Test
    @DisplayName("영양제 제목을 생성한다")
    void create() {
        assertThatCode(() -> new SupplementTitle("6년근 고려홍삼정 PREMIUM"))
            .doesNotThrowAnyException();
    }

    @DisplayName("영양제 제목은 비어있지 않아야 한다")
    @ParameterizedTest
    @NullAndEmptySource
    void createNullAndEmpty(String name) {
        assertThatThrownBy(() -> new SupplementTitle(name))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("영양제 제목을 수정한다")
    void update() {
        SupplementTitle supplementTitle = new SupplementTitle("6년근 고려홍삼정 PREMIUM");
        assertThatCode(() -> supplementTitle.update("클러스터"))
            .doesNotThrowAnyException();
        assertNotEquals(supplementTitle.update("클러스터"), supplementTitle);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("영양제 제목이 없을 경우 수정하지 않는다")
    void notUpdateToNullAndEmpty(String name) {
        SupplementTitle supplementTitle = new SupplementTitle("6년근 고려홍삼정 PREMIUM");
        assertEquals(supplementTitle.update(name), supplementTitle);
    }

    @Test
    @DisplayName("영양제 제목이 같을경우 수정하지 않는다.")
    void notUpdate() {
        SupplementTitle supplementTitle = new SupplementTitle("6년근 고려홍삼정 PREMIUM");
        assertEquals(supplementTitle.update("6년근 고려홍삼정 PREMIUM"), supplementTitle);
    }
}