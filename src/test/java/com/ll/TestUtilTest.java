package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTest {

    @Test //표준 입력 리다이렉팅 테스트
    @DisplayName("TestUtil.genScanner() 테스트")
    void t1(){
        Scanner scanner = TestUtil.genScanner("""
                등록
                나의 죽음을 적들에게 알리지 말라!
                이순신""");
        String cmd = scanner.nextLine();
        String content = scanner.nextLine();
        String authorName = scanner.nextLine();
        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("나의 죽음을 적들에게 알리지 말라!");
        assertThat(authorName).isEqualTo("이순신");
    }

    @Test //표준 출력 리다이렉팅 테스트
    @DisplayName("TestUtil.setOutToByteArray() 테스트")
    void t2(){
       ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();
        System.out.println("2 / 이순신 / 나의 죽음을 적들에게 알리지 말라!");

       String out = byteArrayOutputStream.toString().trim();
       assertThat(out).isEqualTo("2 / 이순신 / 나의 죽음을 적들에게 알리지 말라!");

       TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

//       System.out.println("이제 화면에 출력");

    }

}
