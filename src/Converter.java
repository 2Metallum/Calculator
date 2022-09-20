public enum Converter {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100);

    private int arabicNumber;

    Converter(int arabicNumber){
        this.arabicNumber = arabicNumber;
    }

    public int getArabicNumber(){
        return arabicNumber;
    }

    public static String intToRoman(int n) throws Exception {

        if( n <= 0) {
            throw new IllegalArgumentException();
        }

        StringBuilder buf = new StringBuilder();

        final Converter[] values = Converter.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (n >= values[i].arabicNumber) {
                buf.append(values[i]);
                n -= values[i].arabicNumber;
            }
        }
        return buf.toString();
    }

    public static int romanToInteger(String str){
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'I' && i + 1 != str.length() && str.charAt(i+1) == 'V'){
                sum += 4;
                i++;
            }else if(str.charAt(i) == 'I' && i + 1 != str.length() && str.charAt(1) == 'X'){
                sum += 9;
                i++;
            }else if(str.charAt(i) == 'I' && i + 1 != str.length() && str.charAt(i+1) == 'L'){
                sum += 49;
                i++;
            }else if(str.charAt(i) == 'I'){
                sum += 1;
            }else if(str.charAt(i) == 'V'){
                sum += 5;
            }else if(str.charAt(i) == 'X'){
                sum += 10;
            }else if(str.charAt(i) == 'L'){
                sum += 50;
            }else if(str.charAt(i) == 'C'){
                sum += 100;
            }
        }
        return sum;
    }
    public static boolean isRoman(String s){
        if(s.charAt(0) == 'I' || s.charAt(0) == 'V' || s.charAt(0) == 'X'){
            return true;
        }else{
            return false;
        }
    }
}
