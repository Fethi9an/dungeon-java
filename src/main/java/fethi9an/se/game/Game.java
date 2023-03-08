package fethi9an.se.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private int monsterIndex = 0;
    private int notACoward;
    private Scanner scanner = new Scanner(System.in);
    private static ArrayList<Monster> monsters = new ArrayList<>(Arrays.asList(new Monster(10,20,150,100,10,10)
            , new Monster(20,40,200,70,20,20)
            ,new Monster(999,999,999,100,50,50)));
    public void run(){
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        Player player = Player.builder()
                .name(name)
                .health(400)
                .level(1)
                .strength(20)
                .agility(20)
                .experience(0)
                .intelligence(20)
                .baseDamage(50).build();
        do{
            notACoward = player.playerCombatAct(monsters.get(monsterIndex));
            if(notACoward == 1){
                if (monsters.get(monsterIndex).getHealth() <= 0){
                    System.out.printf("Congrats you have slain the monster nr%d\n",monsterIndex+1);
                    player.setExperience(player.getExperience() + monsters.get(monsterIndex).getGrantedXp());
                    if(player.getExperience() >= 100){
                        System.out.println("You leveled up");
                        player.playerLevelUp();
                    }
                    monsterIndex++;
                }
                else {
                    player.setHealth(player.getHealth() - monsters.get(monsterIndex).fight());
                    if(player.getHealth() <= 0){
                        System.out.println("You have been slain");
                        notACoward = 3;
                    }
                }
            }
        }while (!(notACoward == 3));
        System.out.printf("Thank you %s for playing this game :)",player.getName());
    }
}

