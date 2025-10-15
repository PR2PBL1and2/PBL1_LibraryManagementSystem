package myClass;

/**
 * User 클래스의 설명을 작성하세요.
 *
 * @author (2021320032 임기홍)
 * @version (2025/10/15)
 */
public class User extends DB_Element
{
    private String name;
    private Integer stID;

    /**
     * User 클래스의 객체 생성자
     * 
     * @param name 이용자의 이름
     * @param stID 이용자의 학번
     */
    public User(String name, Integer stID)
    {
        this.name = name;
        this.stID = stID;
    }
    /**
     * User 객채의 학번을 반환하는 메소드
     *
     * @param     없음
     * @return    stID 값을 반환
     */
    @Override
    public String getID()
    {
        return Integer.toString(stID);
    }
    /**
     * User 객체의 정보를 String 타입으로 return하는 메소드
     *
     * @param     없음
     * @return    문제지 결과화면의 양식에 맞춰 저장된 책 정보를 반환
     */
    @Override
    public String toString()
    {
        // 여기에 코드를 작성하세요.
        return "[" + stID + "]" + name;
    }
}
