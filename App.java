import java.util.*;
import myClass.*;
import DataBase.*;

/**
 * 도서관 관리 시스템 실행 클래스
 * 이용자와 책의 정보를 불러와 등록하고 출력한다
 * 대출 기능을 실행하고 결과를 출력한다 
 *
 * @author (2021320032 임기홍)
 * @version (2025.10.20)
 */
public class App
{
    /**
     * 프로그램의 메인 메소드
     * 도서관 관리 시스템의 객체를 생성하고 이용자, 책 정보를 로드하여
     * 각 DB에 저장하고 목록을 출력한다.
     * 대출 기능을 실행하여 3건의 대출을 진행하고 현황을 출력한다.
     *
     * @param args 외부 입력 인자
     */
    public static void main(String[] args)
    {
        LibraryManagementSystem lms = new LibraryManagementSystem();
         
        lms.setUserDB("C:\\Temp\\UserData2025.txt");
        
        System.out.println("----- 이용자 목록 출력 -----");
        lms.printDB(lms.userDB);
        
        lms.setBookDB("C:\\Temp\\BookData2025.txt");
        
        System.out.println("\n----- 책 목록 출력 -----");
        lms.printDB(lms.bookDB);
        
        lms.borrowBook("2025320001", "B02");
        lms.borrowBook("2024320002", "B03");
        lms.borrowBook("2023320003", "B04");
        
        System.out.println("\n----- 대출 현황 -----");
        lms.printLoanList();
        System.out.println("--------------------\n");
    }
}