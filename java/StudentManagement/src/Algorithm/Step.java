package Algorithm;

public class Step {
    static void main() {
        System.out.println(stepMuch(20));
    }
    public static int stepMuch(int stepnum){
        if(stepnum==1)
        {return 1;}
        if(stepnum==2)
        {return 2;}
        if(stepnum==3)
        {return 3;}
        if(stepnum==4)
        {return 5;}
        if(stepnum==5)
        {return 8;}
        if(stepnum==6)
        {return 13;}
        if(stepnum==7)
        {return 21;}
        return stepMuch(stepnum-1)+stepMuch(stepnum-2);
    }
}
