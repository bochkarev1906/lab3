import java.util.*;

public class FractionList {
    private List<Fraction> list = new ArrayList<>();

    FractionList(){}

    FractionList(Fraction... f){
        for(int i = 0; i < f.length; i++){
            list.add(f[i]);
        }

    }

    public List<Fraction> getList(){
        return this.list;
    }

    public void add(Fraction f){
        list.add(f);
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < list.size(); i++){
            str += list.get(i).toString() + " ";
        }
        return str;
    }



    public Fraction getMax(){
        Fraction max = list.get(0);
        for (int i = 0; i < list.size(); i++){
            if(this.list.get(i).compareTo(max) > 0 ){
                max = list.get(i);
            }
        }
        return max;
    }

    public Fraction getMin(){
        Fraction min = list.get(0);
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).compareTo(min) < 0 ){
                min = list.get(i);
            }
        }
        return min;
    }

    public int countMoreThan(Fraction f){
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).compareTo(f) > 0 ){
                count++;
            }
        }
        return count;
    }

    public int countLessThan(Fraction f){
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).compareTo(f) < 0 ){
                count++;
            }
        }
        return count;
    }
}