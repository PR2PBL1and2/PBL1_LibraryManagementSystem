package myClass;


/**
 * DB_Element 클래스의 설명을 작성하세요.
 *
 * @author (2021320032 임기홍)
 * @version (2025/10/25)
 */
public abstract class DB_Element
{
    /**
     * 데이터베이스 요소의 고유 ID를 반환하는 추상 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    데이터베이스 요소의 고유 ID를 Srtinf 타입으로 return
     * Book 클래스에서는 책의 고유 넘버를, User 클래스에서는 이용자의 학번을
     */
    public abstract String getID();
}
