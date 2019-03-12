package work_2;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs;
    }
    public int getDegree(){
        return coeffs.length -1;
    }

    @Override
    public String toString(){

        String res="";
        for(int i=coeffs.length - 1; i>=0 ; i--){
            if(i!=0)
                res += coeffs[i]+"x^" + i+" + ";
            else
                res+= coeffs[i];
        }
        return res;
    }

    public double[] getCoeffs() {
        return coeffs;
    }

    public MyPolynomial add(MyPolynomial right){
        MyPolynomial res;
        double[] newCoef;
        int n;
        if(getDegree() >= right.getDegree())
            n = getDegree();
        else n = right.getDegree();
        newCoef = new double[n+1];
        for(int i=0; i<getDegree()+1; i++){
            newCoef[i] += coeffs[i];
        }
        for(int i=0; i<right.getDegree()+1;i++){
            newCoef[i] += right.getCoeffs()[i];
        }
        res = new MyPolynomial(newCoef);
        return res;
    }
    public MyPolynomial multiply(MyPolynomial right){
        MyPolynomial res;
        double[] newCoef;
        int n;
        if(getDegree() >= right.getDegree())
            n = getDegree();
        else n = right.getDegree();
        newCoef = new double[n+1];

        for(int i=0; i<newCoef.length; i++)
            newCoef[i]=1.0;

        for(int i=0; i<getDegree()+1; i++){
           newCoef[i] *= coeffs[i];
        }
        for(int i=0; i<right.getDegree()+1;i++){
            newCoef[i] *= right.getCoeffs()[i];
        }

        res = new MyPolynomial(newCoef);
        return res;
    }
}
