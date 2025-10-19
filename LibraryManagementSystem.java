import java.util.*;
import java.io.*;
import myClass.*;
import DataBase.*;


/**
 * 이용자, 책, 대출 데이터베이스를 생성하고 관리하는 클래스
 * 대출 작업을 수행하고, 데이터베이스에 객체를 추가, 출력하는 기능을 갖췄다.
 * 
 * @author (202232032_정윤성)
 * @version (2025.10.17)
 */
public class LibraryManagementSystem
{
    LibDB<Book> bookDB; 
    LibDB<User> userDB;
    HashMap<User,Book> loanDB;

    /**
     * LibraryManagementSystem 생성자
     * 
     * 생성자 클래스로 객체의 필드값을 설정 192p, 컬랙션 선언 404p
     * 
     * @param bookDB 책 데이터베이스
     * @param userDB 이용자 데이터베이스
     * @param loanDB 대출 데이터베이스
     * 
     */
    public LibraryManagementSystem()
    {
        bookDB = new LibDB<Book>();
        userDB = new LibDB<User>();
        loanDB = new HashMap<User, Book>();
    }


    /**
     * 이용자ID와 책ID를 찾아, 대출 DB에 저장하는 역할을 수행하는 메소드
     * 
     * HashMap 컬랙션에 요소를 삽입 425p, 메소드 호출 185p
     * 
     * @param     userID 이용자의 ID
     * @param     bookID 책의 ID
     * @return    없음
     */
    public void borrowBook(String userID, String bookID){
        User user = userDB.findElement(userID);
        Book book = bookDB.findElement(bookID);
        loanDB.put(user, book);
    }
    
    
    /**
     * 데이터베이스에 저장된 모든 속성를 출력하는 메소드
     * 
     * 제네릭 메소드 구현 440p
     *
     * @param     db 이용자, 책의 데이터베이스
     * @return    없음
     * 콘솔에 직접 출력
     */
    public static <T extends DB_Element> void printDB(LibDB<T> db){
        db.printAllElements();
    }
    

    /**
     * 대출 데이터베이스에 저장되어 있는 대출정보들을 출력하는 메서드
     * 
     * 해시맵의 모든 키를 담은 Set<User> userset 컬랙션 리턴 425p, 순차 검색할 Iterator 객체 얻기 422p
     * it.hasNext()로 userset의 끝까지 반복 422p, it.next()로 userset 컬랙션의 key 삽입 422p
     * loanDB.get(user) 메소드로 loanDB 해시맵의 value 삽입 425p
     * 
     * @param     없음
     * @return    없음
     * 콘솔에 직접 출력
     */
    public void printLoanList(){
        Set<User> userset = loanDB.keySet();
        Iterator<User> it = userset.iterator();
        while(it.hasNext()){
            User user = it.next();
            Book book = loanDB.get(user);
            System.out.println(user + " ===> " + book);
        }
    }
    

    /**
     * 책의 정보가 저장된 파일 경로를 매개변수로 전달 받아, 책 객체를 생성, 책DB에 저장하는 메서드
     *
     * @param     bookFile 책의 정보가 저장된 파일 경로
     * @return    bookDB   책 데이터베이스
     */
    public LibDB<Book> setBookDB(String bookFile) {
        try {
            FileReader input_stream = new FileReader(bookFile);
            Scanner scanner = new Scanner(input_stream);
            
            Iterator<String> it = scanner;
            while (it.hasNext()) {
                String line = scanner.nextLine(); 
                StringTokenizer st = new StringTokenizer(line, "/");
                                    
                String bookID = st.nextToken();
                String title = st.nextToken();
                String auther = st.nextToken();
                String publisher = st.nextToken();
                int year = Integer.parseInt(st.nextToken());
                    
                Book book = new Book(auther, bookID, publisher, title, year);
                bookDB.addElement(book); 
                
            }
            scanner.close(); 
            input_stream.close();  
            
            
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
        return bookDB; 
    }
    

    /**
     * 이용자의 정보가 저장된 파일 경로를 매개변수로 전달 받아, 이용자 객체를 생성, 책DB에 저장하는 메서드
     *
     * @param     userFile 이용자의 정보가 저장된 파일 경로
     * @return    userDB   이용자 데이터베이스
     */
    public LibDB<User> setUserDB(String userFile) {
        try {
            FileReader input_stream = new FileReader(userFile);
            Scanner scanner = new Scanner(input_stream);
            
            Iterator<String> it = scanner;
            while (it.hasNext()) {
                String line = scanner.nextLine();  
                StringTokenizer st = new StringTokenizer(line, "/");  
                                   
                Integer stID = Integer.valueOf(st.nextToken()); 
                String name = st.nextToken(); 
                    
                User user = new User(name, stID);    
                userDB.addElement(user);  
                
            }
            scanner.close(); 
            input_stream.close(); 
            
            
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
        return userDB; 
    }
}