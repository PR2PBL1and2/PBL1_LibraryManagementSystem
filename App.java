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
        LibraryManagementSystem lms = new LibraryManagementSystem();
        
        // 2
        lms.setUserDB("C:\\Temp\\UserData2025.txt");
        
        // 3
        System.out.println("----- 이용자 목록 출력 -----");
        lms.printDB(lms.userDB);
        
        // 4
        lms.setBookDB("C:\\Temp\\BookData2025.txt");
        
        // 5
        System.out.println("\n----- 책 목록 출력 -----");
        lms.printDB(lms.bookDB);
        
        // 6
        lms.borrowBook("2023320003", "B04");
        lms.borrowBook("2025320001", "B02");
        lms.borrowBook("2024320002", "B03");
        
        // 7
        System.out.println("\n----- 대출 현황 -----");
        lms.printLoanList();
        System.out.println("--------------------\n");
    }
}