import java.util.List;

public class Polinom{
    private FractionList coefficients = new FractionList();

    //Polinom(){ }
    Polinom(FractionList P){
        coefficients = P;
    }

    @Override
    public String toString() {
        String str="";
        //List<Fraction> E = coefficients.getList();
        for(int i = 0; i < coefficients.getList().size(); i++){
            if(i == 0){
                if((coefficients.getList().get(i).numerator > 0 && coefficients.getList().get(i).denominator > 0) || (coefficients.getList().get(i).numerator < 0 && coefficients.getList().get(i).denominator < 0)){
                    str += coefficients.getList().get(i).toStringAbs();
                }
                else{
                    str += "-" + coefficients.getList().get(i).toStringAbs();
                }
            }
            else{
                if(i == coefficients.getList().size() - 1){
                    str += coefficients.getList().get(i).toStringAbs();
                    break;
                }
                else{
                    str += coefficients.getList().get(i).toStringAbs();
                }
            }
            if(coefficients.getList().size() - i - 1 == 1){
                if((coefficients.getList().get(i + 1).numerator > 0 && coefficients.getList().get(i + 1).denominator > 0) || (coefficients.getList().get(i + 1).numerator < 0 && coefficients.getList().get(i + 1).denominator < 0)){
                    str += "x + ";
                }
                else{
                    str += "x - ";
                }

            }
            else{
                if(coefficients.getList().size()- i - 1 > 1){
                    if((coefficients.getList().get(i + 1).numerator > 0 && coefficients.getList().get(i+1).denominator > 0) || (coefficients.getList().get(i + 1).numerator < 0 && coefficients.getList().get(i + 1).denominator < 0) ){
                        str += "x^" + (coefficients.getList().size()-i - 1) + " + ";
                    }
                    else{
                        str += "x^" + ((coefficients.getList().size()-i - 1)) + " - ";
                    }

                }
            }
        }
        return str;
    }


    public Polinom sum(Polinom PP){
        int d = Math.abs(PP.coefficients.getList().size() - this.coefficients.getList().size());
        FractionList list = new FractionList();
        if(PP.coefficients.getList().size() > this.coefficients.getList().size()){
            for(int i = 0; i < d; i++){
                list.getList().add(PP.coefficients.getList().get(i));
            }
            for(int i = d; i < PP.coefficients.getList().size(); i++){
                list.getList().add(PP.coefficients.getList().get(i).sum(this.coefficients.getList().get(i - d)));
            }

        }
        else{
            for(int i = 0; i < d; i++){
                list.getList().add(this.coefficients.getList().get(i));
            }
            for(int i = d; i < this.coefficients.getList().size(); i++) {
                list.getList().add(this.coefficients.getList().get(i).sum(PP.coefficients.getList().get(i - d)));
            }
        }
        Polinom result = new Polinom(list);
        return result;
    }
}
