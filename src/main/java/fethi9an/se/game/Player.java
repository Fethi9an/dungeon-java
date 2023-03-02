package fethi9an.se.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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

