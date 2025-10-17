import java.util.*;
import myClass.*;
import DataBase.*;

/**
 * App 클래스의 설명을 작성하세요.
 *
 * @author (2021320032 임기홍)
 * @version (2025.10.16)
 */
public class App
{
    public static void main(String[] args){
        // 1
        LibraryManagementSystem lbSystem = new LibraryManagementSystem();
        
        // 2
        lbSystem.setUserDB("C:\\Temp\\UserData2025.txt");
        
        // 3
        System.out.println("----- 이용자 목록 출력 -----");
        lbSystem.printDB(lbSystem.userDB);
        
        // 4
        lbSystem.setBookDB("C:\\Temp\\BookData2025.txt");
        
        // 5
        System.out.println("----- 책 목록 출력 -----");
        lbSystem.printDB(lbSystem.bookDB);
        
        // 6
        lbSystem.borrowBook("2023320003", "B04");
        lbSystem.borrowBook("2025320001", "B02");
        lbSystem.borrowBook("2024320002", "B03");
        
        // 7
        System.out.println("----- 대출 현황 -----");
        lbSystem.printLoanList();
    }
}