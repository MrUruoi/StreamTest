public class Student2 {
    public enum Sex { FEMALE, MALE }
    public enum City { TOKYO, OSAKA }

    private String name;
    private int score;
    private Sex sex;
    private City city;

    public Student2(String name, int score, Student2.Sex sex, Student2.City city) {
        this.name = name;
        this.score = score;
        this.sex = sex;
        this.city = city;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public Sex getSex() {
        return sex;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
   
}
