class Solution {
    public static String solution(String new_id) {

        // 1단계
        String step1 = new_id.toLowerCase();

        //2단계
        String  step2 = "";
        for (int i = 0; i < step1.length(); i++) {
            char c = step1.charAt(i);
            if(  (c>='0'&&c<='9')||c=='-'||c=='_'||c=='.'||(c>='a'&&c<='z')||(c>='A'&&c<='Z') ){
                step2 += c;
            }
        }
        //3단계
        String step3=step2;
        while (step3.contains("..")) {
            step3=step3.replace("..", ".");
        }
        //4단계
        String step4 = step3;
        if (step4.length() > 0) {
            if (step4.charAt(0) == '.' ) {
                step4 = step4.substring(1, step4.length());
            }
        }
        if(step4.length()>0){
            if (step4.charAt(step4.length() - 1) == '.') {
                step4 = step4.substring(0, step4.length()-1);
            }
        }
        //5단계
        String step5 = step4;
        if (step5.equals("")) {
            step5 += "a";
        }
        //6단계
        String step6 = step5;
        if (step6.length() >= 16) {
            step6 = step6.substring(0, 15);
        }
        if (step6.charAt(step6.length() - 1) == '.') {
            step6 = step6.substring(0, step6.length()-1 );
        }
        //7단계
        String step7 = step6;
        if (step7.length() <= 2) {
            while (step7.length()<3){
                step7 += step7.charAt(step7.length() - 1);
            }
        }

        return step7;

    }
}