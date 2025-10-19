package DataBase;

import java.util.*;
import myClass.DB_Element;

/**
 * LibDB 클래스는 제네릭 타입의 데이터베이스 역할을 수행하며
 * 요소의 추가, 검색 및 출력 기능을 제공한다.
 * 
 * @author (2021320014 안교관)
 * @version (2025/10/16)
 */
public class LibDB<T extends DB_Element> {
    // 데이터베이스 요소를 저장하는 ArrayList
    // 7장 15번 
    private ArrayList<T> db;
    
    /**
     * LibDB 클래스의 생성자
     * ArrayList를 초기화
     */
    public LibDB() {
        this.db = new ArrayList<>();
    }
    
    /**
     * 요소를 데이터베이스에 추가하는 메소드
     *
     * @param element 추가할 요소
     */
    public void addElement(T element) {
        db.add(element);
    }
    
    /**
     * ID를 이용해 데이터베이스에서 요소를 찾는 메소드
     *
     * @param id 찾을 요소의 ID
     * @return 해당 ID의 요소, 없을 경우 null 
     */
    //7장 10번
    public T findElement(String id) {
        Iterator<T> it = db.iterator();
        while (it.hasNext()) {
            T elem = it.next();
            if (elem != null && elem.getID() != null && elem.getID().equals(id)) {
                return elem;
            }
        }
        return null;
    }
    
    /**
     * 데이터베이스에 저장된 모든 요소를 출력하는 메소드
     *
     * @param 없음
     * @return 없음 
     * 콘솔에 직접 출력
     */
    public void printAllElements() {
        for (T element : db) {
            System.out.println(element);
        }
    }
}
