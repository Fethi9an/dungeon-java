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
        return 0;
    }

    @Override
    public int calculateDamage() {
        return 0;
    }

    @Override
    public boolean didCriticallyStrike() {
        return false;
    }
}