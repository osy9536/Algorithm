package String;

import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        People people1 = new People("sebang", 29);
        People people2 = new People("nebang", 25);
        People people3 = new People("dobang", 27);
        int whoIsBig = people1.compare(people2, people3);
        String s1 ="ad";
        String s2 = "cd";
        if(whoIsBig>0){
            System.out.println("2번이 3번보다 많습니다.");
        }
        else if(whoIsBig==0){
            System.out.println("3번과 3번의 나이가 같습니다.");
        }
        else {
            System.out.println("2번이 3번보다 적습니다.");
        }
    }
}
class People implements Comparator<People> {
    String name;
    int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compare(People o1, People o2) {
        return o1.age - o2.age;
    }
}
