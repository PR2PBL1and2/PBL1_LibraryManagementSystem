package myClass;

/**
 * User 클래스의 설명을 작성하세요.
 *
 * @author (2021320032 임기홍)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class User extends DB_Element
{
    private String name;
    private Integer stID;

    /**
     * User 클래스의 객체 생성자
     */
    public User(String name, Integer stID)
    {
        this.name = name;
        this.stID = stID;
    }
    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public String getID()
    {
        return Integer.toString(stID);
    }
    /**
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public String toString()
    {
        // 여기에 코드를 작성하세요.
        return "[" + stID + "]" + name;
    }
}
