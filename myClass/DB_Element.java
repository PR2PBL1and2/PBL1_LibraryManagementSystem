package myClass;


/**
 * 데이터베이스 요소의 추상 클래스
 * User와 Book의 부모 클래스이다.
 * 
 * @author (2021320032 임기홍)
 * @version (2025/10/25)
 */
public abstract class DB_Element
{
    /**
     * 데이터베이스 요소의 고유 ID를 반환하는 추상 메소드
     *
     * @param  없음
     * @return    데이터베이스 요소의 고유 ID를 Srting 타입으로 return
     *            Book 클래스에서는 책의 고유 넘버, User 클래스에서는 이용자의 학번
     */
    public abstract String getID(); 
}
