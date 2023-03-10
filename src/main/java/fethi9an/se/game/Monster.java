package fethi9an.se.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Monster implements ICombat{
    private int baseDamage;
    private int strength;
    private int health;
    private int grantedXp;
    private int intelligence;
    private int agility;

    @Override
    public int fight() {
        if(didCriticallyStrike()) {
            System.out.printf("The monster did a critical strike dealing %d dmg!!!\n",calculateDamage() * 2);
            return calculateDamage() * 2;
        }
        else {
            System.out.printf("The monster dealt %d dmg to you!\n",calculateDamage());
            return calculateDamage();
        }
    }

    @Override
    public int calculateDamage() {return baseDamage +(strength*2/4+1);    }

    @Override
    public boolean didCriticallyStrike() {
        int x = (int) (Math.random() * 100+1);
        return x < intelligence;
    }
}
