package Ex1;

public class Math extends AbstractMath{
    @Override
    int reverseNumber(int num){
        // we need to take first index as current
        // then access tail 
        // l and save it into tail
        // we then take 

        String text = String.valueOf(num);
        String numText = "";

        
        for(int i = 0; i < text.length(); i++){
            numText += text.charAt(text.length()-1-i);
        }
        num = Integer.parseInt(numText);
        return num;
    }

    @Override
    int roundedNumber(double num){
        int rounded = 0;
        // int num1 = (int) num;
        double numPlus = (int) num + 0.5;
        // System.out.println(num + " " + numPlus);
        if(num > numPlus){
            // System.out.println("Case 1");
            rounded = (int) num + 1;
            return rounded;
        }
        else {
            // System.out.println("Case 2");
            return (int) num;
        }
    }

    @Override
    int countDistinct(int[] values){
        int distinct;
        
        return distinct;
    }
}
