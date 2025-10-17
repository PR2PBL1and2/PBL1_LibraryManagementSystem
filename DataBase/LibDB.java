package DataBase;
import java.util.*;
import myClass.DB_Element;

/**
 * App 클래스의 설명을 작성하세요.
 *
 * @author (2021320014_안교관)
 * @version (2025.10.16)
 */
public class LibDB<T extends DB_Element> {
    private ArrayList<T> db;
    
    public LibDB() {
        this.db = new ArrayList<>();
    }
    
    public void addElement(T element) {
        db.add(element);
    }
    
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
    
    public void printAllElements() {
        for (T element : db) {
            System.out.println(element);
        }
    }
}