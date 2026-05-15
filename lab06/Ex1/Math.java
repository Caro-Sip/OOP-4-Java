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
        if (num >= 0){
            return (int) (num +0.5);
        }
        else{
            return (int) (num - 0.5);
        }
    }

    @Override
    int countDistinct(int[] values){
        int count=0;

        for(int i=0; i < values.length; i++){
            boolean isDistinct = true;
            for(int j=0; j<i; j++){
                if(values[i] == values[j]){
                    isDistinct = false;
                    break;
                }
            }
            if(isDistinct){
                count++;
            }
        }

        return count;
    }

    @Override
    int decimalToBinary(int decimal){
        if(decimal == 0){
            return 0;
        }

        int binary = 0;
        int num = java.lang.Math.abs(decimal);

        while(num > 0){
            binary += (num%2);
            num /= 2;
        }

        return binary;
    }
}
