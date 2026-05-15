package Ex2;

public class Math {
    int sum(int a, int b){
        return a+b;
    }

    int sum(int a, int b, int c){
        return a+b+c;
    }

    int sum(int[] values){
        int total = 0;
        for(int val : values){
            total += val;
        }

        return total;
    }

    int multiply(int a, int b){
        return a*b;
    }

    int multiply(int a, int b, int c){
        return a*b*c;
    }

    int multiply(int[] values){
        int product = 1;
        for(int val : values){
            product *= val;
        }

        return product;
    }

    int max(int a, int b, int c){
        int max = (a > b) ? a : b;
        
        return (max > c) ? max : c;
    }

    int max(int a, int b, int c, int d){
        int max = a;
        max = (max > b) ? max : b;
        max = (max > c) ? max : c;
        max = (max > d) ? max : d;
        return max;
    }

    int max(int[] values){
        if(values.length == 0) return 0;

        int max = values[0];
        for(int val : values){
            max = (max > val) ? max : val;
        }
        return max;
    }

    int min(int a, int b, int c){
        int min = (a < b) ? a : b;
        
        return (min < c) ? min : c;
    }

    int min(int a, int b, int c, int d){
        int min = a;
        min = (min < b) ? min : b;
        min = (min < c) ? min : c;
        min = (min < d) ? min : d;
        return min;
    }

    int min(int[] values){
        if(values.length == 0) return 0;

        int min = values[0];
        for(int val : values){
            min = (min < val) ? min : val;
        }
        return min;
    }

    double average(int a, int b){
        return (a+b)/2.0;
    }

    double average(int a, int b, int c){
        return (a+b+c)/3.0;
    }

    double average(int a, int b, int c, int d){
        return (a+b+c+d)/3.0;
    }

    double average(int[] values){
        if(values.length == 0) return 0;

        return sum(values)/(double)values.length;
    }
}
