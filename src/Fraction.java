
public class Fraction implements Comparable<Fraction> {
    public int numerator, denominator;

    Fraction() {
        numerator = 0;
        denominator = 1;
    }

    Fraction(int n, int m) {
        this.numerator = n;
        this.denominator = m;
    }

    @Override
    public String toString() {
        if(this.numerator == this.denominator){
            return "1";
        }
        else{
            if(this.numerator == 0){
                return "0";
            }
            else{
                return fractionReduction(this).numerator +  "/" + fractionReduction(this).denominator;
            }
        }
    }

    public String toStringAbs() {
        if(Math.abs(this.numerator) == Math.abs(this.denominator)){
            return "1";
        }
        else{
            if(this.numerator == 0){
                return "0";
            }
            else{
                return Math.abs(fractionReduction(this).numerator) +  "/" + Math.abs(fractionReduction(this).denominator);
            }
        }
    }

     public Fraction fractionReduction(Fraction f){
        int n = Math.abs(f.numerator);
        int m = Math.abs(f.denominator);
        while(n != 0 && m != 0){
            if(n > m){
                n = n % m;
            }
            else{
                m = m % n;
            }
        }
        f.numerator = f.numerator / (n + m);
        f.denominator = f.denominator / (n + m);
        return f;
     }

    public Fraction sum(Fraction F){
        int n = this.denominator * F.numerator + this.numerator * F.denominator;
        int m = this.denominator * F.denominator;
        Fraction result = new Fraction(n, m);
        return fractionReduction(result);
    }

    @Override
    public int compareTo(Fraction other) {
        double difference = (double) this.numerator / this.denominator - (double) other.numerator / other.denominator;
        if (difference > 0){
            return 1;
        }
        else{
            if(difference < 0){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
}