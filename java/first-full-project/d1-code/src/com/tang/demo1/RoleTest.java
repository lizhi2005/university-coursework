package com.tang.demo1;

public class RoleTest {
    public static void main(String[] args) {
        Role player=new Role("张三",100);
        Role enemy=new Role("李四",100);
        player.arenaFight(enemy);

    }
}
