package enemy;

import java.util.ArrayList;

import enemy.base.*;
import enemy.type.*;

/**
 * @author User
 *
 */
public class EnemyPool {
    
    public ArrayList<Enemy> tier1 = new ArrayList<Enemy>();
    public ArrayList<Enemy> tier2 = new ArrayList<Enemy>();
    public ArrayList<Enemy> tier3 = new ArrayList<Enemy>();
    public ArrayList<Enemy> allTier ;
    public void EnemyPoolProgram() {
        
    
        Birdy birdy = new Birdy();
        Knight knight = new Knight();
        Slime slime = new Slime();
        Snagge snagge = new Snagge();
        Worm worm = new Worm();
        ArrayList<Enemy> allTier = new ArrayList<Enemy>();
        allTier.add(birdy);
        allTier.add(snagge);
        allTier.add(slime);

        allTier.add(worm);
        allTier.add(knight);
        this.setAllTier(allTier);
        System.out.println(allTier);
        
//        sortTier(allTier);
    }

    private void sortTier(ArrayList<Enemy> allTier) {
        for (int i = 0; i < allTier.size(); i++) {
            Enemy temp = allTier.get(i);
            if (temp.getTeir() == 1) {
                tier1.add(temp);
            }
            else if(temp.getTeir() == 2) {
                tier2.add(temp);
            }
            else {
                tier3.add(temp);
            }
        }
        
    }
    public ArrayList<Enemy> getTier1(){
    	return this.tier1;
    }
    public ArrayList<Enemy> getTier2(){
    	return this.tier2;
    }
    public ArrayList<Enemy> getTier3(){
    	return this.tier3;
    }
    public ArrayList<Enemy> getallTier(){
    	return this.allTier;
    }
    public void setAllTier(ArrayList<Enemy> allTier) {
    	this.allTier = allTier;
    }

}



