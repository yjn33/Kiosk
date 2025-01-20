/*
* Kiosk Level 1 구현 과제
*
* 요구사항 ID 체크
* Lv_1_output_01_F
* Lv_1_input_01_F
* Lv_1_input_01_N
* Lv_1_input_02_N
* Lv_1_process_01_F
* LV_1_design_01_N
*
*
*/
package kiosk.lv1;
import java.util.Scanner;

public class Main
{
    public static void main(String [] args)
    {
        prototypeMenu(); // 클래스 메소드 호출
    }

    // 프로토타입 코드로서 c언어 스타일로 구현 static
    private static void prototypeMenu() // LV_1_design_01_N
    {
        Scanner scanner = new Scanner(System.in); // 문자열 입력 받기
        String input = null; // 지역참조변수 초기화
        int ctrlInt = 0; // 지역변수 초기화


        System.out.println("메뉴를 선택하세요");
        System.out.println("1: 햄버거 메뉴, 0: 종료");

        while(true) // Lv_1_process_01_F: 무한반복진행
        {
            input = scanner.next(); // Lv_1_input_01_N: 서브루틴 제어 문자열로 받아들이기
            ctrlInt = Integer.parseInt(input); // 정수값으로 변환

            switch(ctrlInt) // Lv_1_input_01_F: 입력받은 값에 따라 해당하는 서브루틴 실행
            {
                case 1: // Lv_1_output_01_F: 햄버거 메뉴 전체 출력
                    System.out.println("[ SHAKESHACK MENU ]");
                    System.out.println("ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                    System.out.println("SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                    System.out.println("Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                    System.out.println("Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                    System.out.println("종료: 0     | 다시보기: 1");
                    continue; // goto while(true) Lv_1_process_01_F: 무한반복진행

                case 0: // Lv_1_input_02_N: 0을 입력받으면 종료
                    break; // switch(ctrlInt) 탈출

                default:
                    System.out.println("숫자를 다시 입력하세요"); // 요구사항에 없는 기능 trycatch 추가 하기 문자열 예외
                    continue; // goto while(true)

            } // switch(ctrlInt) 끝

            break; // Lv_1_input_02_N: 무한 반복문 while(true) 탈출 & 종료

        } // while(true) 끝

    } // Main.prototypeMenu() 끝

} // Main class 끝


