package com.tang.demo1;

import java.util.Random;

public class IntegratedPractice {
    public static void main(String[] args) {
        int moon=11;
        String specs="头等舱";
        double ticketPrice=1000;
        System.out.println(processTicketSale(ticketPrice,moon,specs));
        System.out.println(countPrimes(101,200));
        System.out.println(generateCaptcha());
        double []scores={80,90,85,95,88,90};
        System.out.println(calculateAverageScoreWithoutExtremes(scores));
        int [][]arr=new int[4][3];
        arr[0]=new int[]{22,66,44};
        arr[1]=new int[]{77,33,88};
        arr[2]=new int[]{25,45,65};
        arr[3]=new int[]{11,66,99};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static double calculateAverageScoreWithoutExtremes(double[] scores) {
        double min=100;
        double max=0;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i]<0||scores[i]>100) {
                return -1;
            }
            else if(scores[i]<=100&&scores[i]>=0){
                    for (int j = 0; j < scores.length; j++) {
                        if(scores[j]<min){
                            min=scores[j];
                        }
                    }
                    for (int j = 0; j < scores.length; j++) {
                        if(scores[j]>max){
                            max=scores[j];
                        }
                    }
                    double sum=0;
                    for (int j = 0; j < scores.length; j++) {
                        if(scores[j]!=min&&scores[j]!=max){
                            sum+=scores[j];
                        }
                    }
                    double avg=sum/(scores.length-2);
                    return avg;
                }
            }

        return -1;

    }

    public static String generateCaptcha() {
        String result="";
        char []chars=new char[52];
        Random r=new Random();
        for (int i = 0; i < chars.length; i++) {
            if(i<26){
                chars[i]=(char)(i+97);
            }else{
                chars[i]=(char)(i-26+65);
            }
        }
        for (int i = 0; i < 4; i++) {
            char RandomIndex=chars[r.nextInt(chars.length)];
            result+=RandomIndex;
        }
        int num=r.nextInt(10);
        result+=num;
        return result;
    }

    public static int countPrimes(int from,int to)
    {
        int count=0;
        for (int i = from; i < to; i++) {
            if (i > 1) { // 排除1
                boolean isPrime = true;
                for (int j = 2; j < i; j++) { // 检查2到i-1
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    count++;
                }
            }
        }
        return count;
    }
    public static double processTicketSale(double ticketPrice, int moon, String specs)
    {
        // 验证月份是否合法（1-12）
        if (moon < 1 || moon > 12) {
            System.out.println("月份输入错误，应为1-12之间的整数");
            return ticketPrice;
        }

        // 验证仓位是否合法
        if (!"头等舱".equals(specs) && !"经济舱".equals(specs)) {
            System.out.println("仓位输入错误，应为'头等舱'或'经济舱'");
            return ticketPrice;
        }

        switch (moon) {
            case 11,12,1,2,3,4:
                if ("头等舱".equals(specs)) {
                    ticketPrice = ticketPrice * 0.7;
                } else  {
                    ticketPrice = ticketPrice * 0.6;
                }
                break;
            case 5,6,7,8,9,10:
                if ("头等舱".equals(specs)) {
                    ticketPrice = ticketPrice * 0.9;
                } else  {
                    ticketPrice = ticketPrice * 0.85;
                }
                break;
        }
        return ticketPrice;
    }






}





