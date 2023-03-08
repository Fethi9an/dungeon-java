package fethi9an.se.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Player implements ICombat  {
    private String name;
    private int strength;
    private int intelligence;
    private int agility;
    private int health;
    private int experience;
    private int level;
    private int baseDamage;

    public void playerFlee(){
        System.out.println("You ran like a coward!");
    }
    @Override
    public int fight(){
        if(didCriticallyStrike()) {
            System.out.printf("You did a critical strike dealing %d dmg!\n",calculateDamage() * 2);
            return calculateDamage() * 2;
        }
        else {
            System.out.printf("You dealt %d dmg!\n",calculateDamage());
            return calculateDamage();
        }
    }

    public void getStatus(Monster monster) {
        System.out.printf("Your stats strength: %d, intelligence: %d, agility: %d, health: %d , experience: %d , level: %d , baseDamage: %d`\n",strength,intelligence,agility,health,experience,level,baseDamage);
        System.out.printf("Monster stats strength: %d, intelligence: %d, agility: %d, health: %d baseDamage: %d\n",monster.getStrength(),monster.getIntelligence(),monster.getAgility(),monster.getHealth(),monster.getBaseDamage());

    }
    @Override
    public boolean didCriticallyStrike(){
        int x = (int) (Math.random() * 100+1);
        return x < intelligence;
    }
    public int playerCombatAct(Monster monster){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose action....");
        System.out.println("(1)Fight, (2)Status, (3)Flee");
        int choice = scanner.nextInt();
        if(choice < 1 || choice > 3){
            System.out.println("Please choose a number between 1 and 3");
        }
        switch (choice) {
            case 1 -> {
                monster.setHealth(monster.getHealth() - fight());
                return 1;
            }
            case 2 -> {
                getStatus(monster);
                return 2;
            }
            case 3 -> {
                playerFlee();
                return 3;
            }
        }
        return 0;
    }

    public void playerLevelUp(){
        setLevel(level+1);
        setAgility(agility+2);
        setStrength(strength+2);
        setIntelligence(intelligence+2);
        setExperience(experience-100);
    }
    @Override
    public int calculateDamage(){
        return baseDamage +(strength*2/4+1);
    }

    public boolean playerDidDodge(){
        int x = (int) (Math.random() * 100+1);
        return x < agility;
    }

}
