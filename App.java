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
        
        LibraryManagementSystem lbSystem = new LibraryManagementSystem();
        
        // 이용자 명단을 데이터베이스에 등록, 출력
        lbSystem.setUserDB("C:\\Temp\\UserData2025.txt");
        
        
        System.out.println("----- 이용자 목록 출력 -----");
        lbSystem.printDB(lbSystem.userDB);
        
        // 수장자료 명단을 데이터베이스에 등록, 출력
        lbSystem.setBookDB("C:\\Temp\\BookData2025.txt");
        
        System.out.println("----- 책 목록 출력 -----");
        lbSystem.printDB(lbSystem.bookDB);
        
        // 대출작업 3건 수행
        lbSystem.borrowBook("2025320001", "B02");
        lbSystem.borrowBook("2024320002", "B03");
        lbSystem.borrowBook("2023320003", "B04");
        
        // 대출현황 출력
        lbSystem.printLoanList();
    }
}