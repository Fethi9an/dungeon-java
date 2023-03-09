
import org.junit.Assert;
import org.junit.Before;
import fethi9an.se.game.Monster;
import fethi9an.se.game.Player;

public class Test {

    Player player;
    Monster monster;
    Monster unkillableBoss;
    @Before
    public void setUp(){
        player = Player.builder()
                .name("Martin")
                .health(400)
                .level(1)
                .strength(20)
                .agility(20)
                .experience(0)
                .intelligence(0)
                .baseDamage(50).build();
        monster = new Monster(10,20,20,100,10,10);
        unkillableBoss = new Monster(999,999,999,100,50,50);
    }
    @org.junit.Test
    public void canLevel(){
        player.playerLevelUp();
        Assert.assertEquals(2,player.getLevel());
    }
    @org.junit.Test
    public void canLose(){
        boolean lostTheGame = false;
        unkillableBoss.setHealth(player.fight());
        if (unkillableBoss.getHealth() <= 0){
            System.out.printf("Congrats you have slain the monster nr%d\n");
            player.setExperience(player.getExperience() + unkillableBoss.getGrantedXp());
            if(player.getExperience() >= 100){
                System.out.println("You leveled up");
                player.playerLevelUp();
            }
        }
        else {
            player.setHealth(player.getHealth() - unkillableBoss.fight());
            if(player.getHealth() <= 0){
                System.out.println("You have been slain");
                lostTheGame = true;
            }
        }
        Assert.assertEquals(true,lostTheGame);

    }
    @org.junit.Test
    public void dmgCheck(){
        Assert.assertEquals(player.getBaseDamage()+(player.getStrength()*2/4+1), player.fight());
    }

}
