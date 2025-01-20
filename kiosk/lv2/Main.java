package kiosk.lv2;
import java.util.*;

public class Main
{




    public static void main(String [] args)
    {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Iterator<MenuItem> iterator;

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
                    MenuItem pointer = null;
                    iterator = menuItems.iterator();

                    while(iterator.hasNext())
                    {
                        // iterator pattern
                        pointer = iterator.next(); // interator -> menuitems
                        System.out.println( (menuItems.indexOf(pointer) + 1) + ". " + pointer.itemName + "    | "
                                + pointer.itemPrice + " | " + pointer.itemDescription);

                    }
                    System.out.println("0. 종료 | 1. 다시보기");
                    continue; // goto while(true) Lv_1_process_01_F: 무한반복진행

                case 0: // Lv_1_input_02_N: 0을 입력받으면 종료
                    break; // switch(ctrlInt) 탈출

                default:
                    System.out.println("숫자를 다시 입력하세요"); // 요구사항에 없는 기능 trycatch 추가 하기 문자열 예외
                    continue; // goto while(true)

            } // switch(ctrlInt) 끝

            break; // Lv_1_input_02_N: 무한 반복문 while(true) 탈출 & 종료

        } // while(true) 끝

    } // main(String [] args) 끝


} // Main class 끝



class MenuItem
{
    String itemName;
    double itemPrice;
    String itemDescription;


    MenuItem(String itemName, double itemPrice, String itemDescription)
    {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
    }

}









