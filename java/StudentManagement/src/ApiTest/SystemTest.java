package ApiTest;

import java.util.Scanner;

public class SystemTest {

    static void main() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr1 = new int[10];
        System.arraycopy(arr, 0, arr1, 4, 3);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        Scanner sc=new Scanner(System.in);
//        System.out.println("请输入一个正确的电话号码");
//        String phone=sc.nextLine();
//        System.out.println(phone.matches("[1][0-9]{10}"));
//        /*
//         * [1] - 表示匹配字符 '1'
//         * [0-9] - 表示匹配任意数字（0-9）
//         * {10} - 表示前面的字符或字符集重复10次
//         */
//        /*
//        * 用户名部分（Local Part）
//允许的字符：
//
//英文字母（A-Z, a-z）
//数字（0-9）
//特殊字符：_（下划线）、.（点）、-（连字符）
//限制条件：
//
//不能以特殊字符（.、-）开头或结尾
//不能连续出现多个.（如 user..name 无效）
//长度通常限制在 64 个字符以内
//@ 符号
//必须且只能有一个 @ 符号
//不能出现在开头或结尾
//域名部分（Domain Part）
//结构：由域名主体和顶级域名组成，如 example.com
//
//域名主体：如 example
//顶级域名：如 .com、.cn、.org 等
//允许的字符：
//
//英文字母（A-Z, a-z）
//数字（0-9）
//连字符（-），但不能出现在开头或结尾
//长度限制：
//
//域名主体长度通常不超过 63 个字符
//完整域名长度不超过 253 个字符
//        *
//        * */


        System.out.println("请输入一个正确的邮箱");
        String email=sc.nextLine();
        System.out.println(email.matches("^[a-zA-Z0-9]+(?:[._-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:-[a-zA-Z0-9]+)*\\.[a-zA-Z]{2,}$"));
//    ^：匹配字符串开头
//        $：匹配字符串结尾
//    [a-zA-Z0-9]+(?:[._-][a-zA-Z0-9]+)*
//
//[a-zA-Z0-9]+：匹配至少1个字母（大小写）或数字（用户名必须以字母/数字开头）
//        (?:[._-][a-zA-Z0-9]+)*：
//        (?:...)：非捕获组（不存储匹配结果，仅用于分组）
//[._-]：匹配特殊字符 .、_ 或 -
//[a-zA-Z0-9]+：特殊字符后必须跟至少1个字母/数字
//                *：整个组可重复0次或多次（允许用户名包含多个特殊字符，但不能连续出现）




    }

}
