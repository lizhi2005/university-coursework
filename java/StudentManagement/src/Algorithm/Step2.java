package Algorithm;

public class Step2 {
    static void main() {
        // 标准写法
        long start = System.currentTimeMillis();
        System.out.println("开始时间："+start);
        System.out.println(stepMuch(22));
        long end= System.currentTimeMillis();
        System.out.println("结束时间："+end);
        System.out.println("耗时："+(end-start)+"ms");
    }



    public static long stepMuch(int stepnum){
        if(stepnum==1)
        {return 1;}
        if(stepnum==2)
        {return 2;}
        if(stepnum==3)
        {return 4;}

        return stepMuch(stepnum-1)+stepMuch(stepnum-2)+stepMuch(stepnum-3);
    }
}
