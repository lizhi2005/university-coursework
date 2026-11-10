package com.tang.demo1;

import java.util.Random;

public class Role
{
private String name;
private int blood;

public Role(){
    this.name="";
    this.blood=0;
}

public Role(String name,int blood){
    this.name=name;
    this.blood=blood;
}

public void Attack(Role target,int damage){
//    if(this.blood <= 0){
//        System.out.println(this.name+"已经死亡，无法攻击！");
//        return;
//    }
//
//    // 检查目标是否已死亡
//    if(target.blood <= 0){
//        System.out.println(target.name+"已经死亡，无需攻击！");
//        return;
//    }
//
//    target.blood-=damage;
//    System.out.println(this.name+"攻击了"+target.name+"，造成了"+damage+"点伤害");
//    if(target.blood<=0){
//        System.out.println(target.name+"被"+this.name+"攻击了"+damage+"点伤害，被杀死了");
//    }
//    else{
//        System.out.println(target.name+"被"+this.name+"攻击了"+damage+"点伤害，剩余血量为"+target.blood);
//    }
//}
    if (this.blood <= 0) {
        System.out.println(this.name + "已经死亡，无法攻击！");
        return;
    }

    // 检查目标是否已死亡
    if (target.blood <= 0) {
        System.out.println(target.name + "已经死亡，无需攻击！");
        return;
    }

    // 攻击描述数组
    String[] attacks_desc = {
            "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
            "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };

    // 受伤描述数组
    String[] injureds_desc = {
            "结果%s退了半步，毫发无损",
            "结果给%s造成一处瘀伤",
            "结果一击命中，%s痛得弯下腰",
            "结果%s痛苦地闷哼了一声，显然受了点内伤",
            "结果%s摇摇晃晃，一跤摔倒在地",
            "结果%s脸色一下变得惨白，连退了好几步",
            "结果『轰』的一声，%s口中鲜血狂喷而出",
            "结果%s一声惨叫，像滩软泥般塌了下去"
    };

    Random r = new Random();

// 随机选择攻击描述
    int attackIndex = r.nextInt(attacks_desc.length);
    System.out.printf(attacks_desc[attackIndex], this.name, target.name);
    System.out.println();

    // 计算伤害
    target.blood -= damage;

    // 根据伤害值选择受伤描述（伤害越大，受伤越严重）
    int injuredIndex;
    if (target.blood <= 0) {
        injuredIndex = 7; // 死亡描述
    } else if (damage >= 15) {
        injuredIndex = 6; // 重伤描述
    } else if (damage >= 10) {
        injuredIndex = 5; // 较重伤描述
    } else if (damage >= 5) {
        injuredIndex = 4; // 中等伤描述
    } else if (damage >= 3) {
        injuredIndex = 3; // 轻伤描述
    } else if (damage >= 1) {
        injuredIndex = 2; // 轻微伤描述
    } else {
        injuredIndex = 0; // 无伤害描述
    }

    System.out.printf(injureds_desc[injuredIndex], target.name);
    System.out.println();

    // 输出剩余血量
    if (target.blood > 0) {
        System.out.printf("%s剩余血量：%d\n", target.name, target.blood);
    } else {
        System.out.printf("%s已死亡！\n", target.name);
    }
}

public  void arenaFight(Role role1){
    Random r = new Random();
    System.out.println("=== 擂台赛开始 ===");
    System.out.println(role1.name + " vs " + this.name);
    System.out.println("初始状态：" + role1.name + "(" + role1.blood + "血)，" + this.name + "(" + this.blood + "血)");
    System.out.println();
    int round = 1;
    // 循环攻击直到一方死亡
    while (role1.blood > 0 && this.blood > 0) {
        // 角色1攻击角色2
        System.out.println("第" + round + "轮");
        int damage1 = r.nextInt(20) + 1; // 1-20的随机伤害
        role1.Attack(this, damage1);
        System.out.println();

        // 检查角色2是否死亡
        if (this.blood <= 0) {
            break;
        }

        // 角色2攻击角色1
        int damage2 = r.nextInt(20) + 1; // 1-20的随机伤害
        this.Attack(role1, damage2);
        System.out.println();
        round++;
    }

    // 输出比赛结果
    System.out.println("=== 擂台赛结束 ===");
    if (role1.blood > 0) {
        System.out.println(role1.name + "获胜！剩余血量：" + role1.blood);
    } else {
        System.out.println(this.name + "获胜！剩余血量：" + this.blood);
    }
}





}
