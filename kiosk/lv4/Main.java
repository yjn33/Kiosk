package kiosk.lv4;
import java.util.*;

public class Main
{
    public static void main(String [] args)
    {
        Menu menu = new Menu();

        menu.menuItems.add(new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.menuItems.add(new MenuItem(1, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.menuItems.add(new MenuItem(1, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.menuItems.add(new MenuItem(1, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        menu.menuItems.add(new MenuItem(2, "test", 5.4, "test"));
        menu.menuItems.add(new MenuItem(2, "drinks", 5.4, "test drinks"));

        menu.menuItems.add(new MenuItem(3, "test", 5.4, "test"));
        menu.menuItems.add(new MenuItem(3, "desserts", 5.4, "test desserts"));


        Kiosk testKiosk = new Kiosk(menu);
        testKiosk.start();

    }

}


class Kiosk
{
    Scanner scanner = new Scanner(System.in);
    String input;
    int ctrlMenu;
    Menu menu;
    int categoryRange;


    Kiosk(Menu menu)
    {
        this.menu = menu;
    }


    void start()
    {
        Iterator<MenuItem> iterator = null;
        boolean checkInputException = false;
        this.categoryRange = menu.getCategoryRange();

        while(true)
        {
            System.out.println("[ Main Menu ]");
            menu.getCategoryNameMenu();
            System.out.println("0: 종료");

            this.input = scanner.next();

            checkInputException = checkException(); // 정수형 예외처리
            // this.ctrlInt = Integer.parseInt(this.input);

            if(checkInputException) // user가 int값이 아닌 다른 타입을 입력할경우
            {
                System.out.println("숫자를 입력하셔야 합니다"); // 터미널 들여쓰기 정리
                continue; // goto while(true) 메뉴 재시작
            }


            if(ctrlMenu > 0 && ctrlMenu < categoryRange)
            {
                MenuItem pointer = null;
                iterator = this.menu.menuItems.iterator();


                System.out.println("[ " + this.menu.getCategoryName(ctrlMenu) + " Menu ]");
                while(iterator.hasNext())
                {
                    pointer = iterator.next();

                    if(pointer.itemCategoryNumber == ctrlMenu)
                    {
                        System.out.println(". " + pointer.itemName + "    | "
                                + pointer.itemPrice + " | " + pointer.itemDescription);

                    }

                }

            }

            else if(ctrlMenu == 0)
            {
                break; // 프로그램 종료
            }

            else // getCategoryRange()에 없는 숫자일경우
            {
                System.out.println("숫자를 다시 입력하세요");
            }

            System.out.println();
        }

    }


    boolean checkException()
    {
        try
        {
            this.ctrlMenu = Integer.parseInt(this.input);
        }

        catch(NumberFormatException e)
        {
            return true;
        }

        return false;

    }

}



class MenuItem
{
    String itemCategory;
    int itemCategoryNumber;
    String itemName;
    double itemPrice;
    String itemDescription;


    MenuItem(int itemCategoryNumber, String itemName, double itemPrice, String itemDescription)
    {
        this.itemCategoryNumber = itemCategoryNumber;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        setItemCategory();
    }


    void setItemCategory()
    {
        switch (this.itemCategoryNumber)
        {
            case 1:
                this.itemCategory = "burgers";
                break;

            case 2:
                this.itemCategory = "drinks";
                break;

            case 3:
                this.itemCategory = "desserts";
                break;

        }

    }

}


class Menu
{
    List<MenuItem> menuItems = new ArrayList<>();
    Iterator<MenuItem> iterator;


    void getCategoryNameMenu()
    {
        MenuItem pointer = null;
        iterator = this.menuItems.iterator();
        int categoryNumber = 1;

        while(iterator.hasNext()) // iterator pattern
        {
            pointer = iterator.next();

            if(pointer.itemCategoryNumber == categoryNumber)
            {
                System.out.println( categoryNumber + ". " + pointer.itemCategory);
                categoryNumber++;
            }

        }
    }


    int getCategoryRange()
    {
        MenuItem pointer = null;
        iterator = this.menuItems.iterator();
        int categoryNumber = 1;

        while(iterator.hasNext()) // iterator pattern
        {
            pointer = iterator.next();

            if(pointer.itemCategoryNumber == categoryNumber)
            {
                categoryNumber += 1;
            }

        }

        return categoryNumber;
    }


    String getCategoryName(int categoryNumber)
    {
        MenuItem pointer = null;
        iterator = this.menuItems.iterator();


        while(iterator.hasNext()) // iterator pattern
        {
            pointer = iterator.next();

            if(pointer.itemCategoryNumber == categoryNumber)
            {
                return pointer.itemCategory;
            }

        }

        System.out.println("해당하는 카테고리명을 찾지 못하였습니다");
        return null;

    }

}

