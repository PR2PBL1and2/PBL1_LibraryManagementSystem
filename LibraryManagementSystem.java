import java.util.*;
import java.io.*;
import myClass.*;
import DataBase.*;


/**
 * LibraryManagementSystem 클래스의 설명을 작성하세요.
 *
 * @author (202232032_정윤성)
 * @version (2025.10.16)
 */
public class LibraryManagementSystem
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    LibDB<Book> bookDB; 
    LibDB<User> userDB;
    HashMap<User,Book> loanDB;

    // 클래스의 생성자, 3개의 데이터베이스를 생성한다
    public LibraryManagementSystem()
    {
        bookDB = new LibDB<Book>();
        userDB = new LibDB<User>();
        loanDB = new HashMap<User, Book>();
    }

    // userID, bookID를 매개변수로 가져와 대출 작업을 수행하는 메서드
    // 이용자 DB에서 이용자를 찾고, 책 DB에서 책을 찾아, 대출 DB에 저장하는 역할을 수행
    public void borrowBook(String userID, String bookID){
        User user = userDB.findElement(userID);
        Book book = bookDB.findElement(bookID);
        loanDB.put(user, book);
    }
    
    // 책 DB, 이용자 DB를 매개변수로 전달 받고 데이터베이스에 저장된 모든 요소를 출력하는 메소드
    public static <T extends DB_Element> void printDB(LibDB<T> db){
        db.printAllElements();
    }
    
    // 대출 DB에 저장되어 있는 정보를 출력하는 메서드(iterator 사용)
    public void printLoanList(){
        Set<User> userset = loanDB.keySet();
        Iterator<User> it = userset.iterator();
        while(it.hasNext()){
            User user = it.next();
            Book book = loanDB.get(user);
            System.out.println(user + " ===> " + book);
        }
    }
    
    // 책의 정보가 저장된 파일 경로를 매개변수로 전달 받아, 책 객체를 생성, 책DB에 저장하는 메서드
    public LibDB<Book> setBookDB(String bookFile) {
        try {
            FileReader input_stream = new FileReader(bookFile);
            Scanner scanner = new Scanner(input_stream);
            
            Iterator<String> it = scanner;
            while (it.hasNext()) {
                String line = scanner.nextLine();  // 텍스트 파일의 줄별로 line에 임시저장
                StringTokenizer st = new StringTokenizer(line, "/");  // line에 임시 저장한 줄에서 / 기준으로 나눔
                                    
                String bookID = st.nextToken();
                String title = st.nextToken();
                String auther = st.nextToken();
                String publisher = st.nextToken();
                int year = Integer.parseInt(st.nextToken());
                    
                Book book = new Book(auther, bookID, publisher, title, year);   // book 객체 생성 및 저장 
                bookDB.addElement(book);  // book 객체를 DB에 등록
                
            }
            scanner.close();   // 스캐너 종료
            input_stream.close();  // 파일리더 종료
            
            
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
        return bookDB;  // 추가된 데이터베이스를 리턴
    }
    
    // 이용자의 정보가 저장된 파일 경로를 매개변수로 전달 받아, 이용자 객체를 생성, 책DB에 저장하는 메서드
    public LibDB<User> setUserDB(String userFile) {
        try {
            FileReader input_stream = new FileReader(userFile);
            Scanner scanner = new Scanner(input_stream);
            
            Iterator<String> it = scanner;
            while (it.hasNext()) {
                String line = scanner.nextLine();  // 텍스트 파일의 줄별로 line에 임시저장
                StringTokenizer st = new StringTokenizer(line, "/");  // line에 임시 저장한 줄에서 / 기준으로 나눔
                                   
                Integer stID = Integer.valueOf(st.nextToken()); // 첫번째 st.nextToken() 즉 "202532001" 이러한 문자열을 stID에 Integer 타입으로 저장
                String name = st.nextToken(); // 첫번째 st.nextToken() 즉 "KIM" 이러한 문자열을 name에 String 타입으로 저장
                    
                User user = new User(name, stID);   // user 객체 생성 및 저장 
                userDB.addElement(user);  // user 객체를 DB에 등록
                
            }
            scanner.close();   // 스캐너 종료
            input_stream.close();  // 파일리더 종료
            
            
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
        return userDB;  // 추가된 데이터베이스를 리턴
    }
}