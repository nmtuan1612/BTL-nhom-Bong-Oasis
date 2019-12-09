package Main;
import Enemy.Enemy;
import Enemy.Soldier;
import Enemy.Tank;
import Main.Map.MapDif;
import Main.Map.MapEz;
import Main.Player.Player;
import Tower.Tower;
import Tower.* ;
import Enemy.* ;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.List;


public class GameField {
    private int dem = 0 ;
    private static long LastCreatingTime = 0;
    public GraphicsContext gc ;
    private String mapType;
    private String StartDefense;
    private MapEz mapEz;
    private MapDif mapDif;;
    private ArrayList<Enemy> DifEnemy ;
    private ArrayList<Enemy> EzEnemy;
    private ArrayList<Tower> towerList1;
    private ArrayList<Tower> towerList2;
    private ArrayList<Button> buildButton;
    List<Integer> integers = new ArrayList<>();
    private Player player;
    Text winText = new Text("You Win !");
    int EzPauseClick = 0;
    int DifPauseClick = 0;
    private int BuildClick = 0;
    private int createNumber = 0;
    private int createNumber2 = 0;
    private int enemyPerWave = 20;
    private boolean endWave1 = false;
    private boolean endWave2 = false;

    public GameField() {
        mapType = "null";
        StartDefense = "null";
        EzEnemy = new ArrayList<Enemy>();
        DifEnemy = new ArrayList<Enemy>() ;
        towerList1 = new ArrayList<Tower>();
        towerList2 = new ArrayList<Tower>();
        player = new Player();
        mapEz = new MapEz();
        mapDif = new MapDif();
    }
    public final AnimationTimer Timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            render();
            update();
        }
    };
     public void render() {

         if (mapType == "ez") {
             for (Enemy enemy : EzEnemy)
                 enemy.setMapType("ez");
             if (StartDefense == "run") {
                 mapEz.drawEzMap(gc);
                 player.draw(gc);
                 EzEnemy.forEach(g -> g.render(gc));
                 towerList1.forEach(g -> g.renderTower(gc));
                 if (enemyPerWave == 0) {
                     Timer.stop();
                     gc.setFill(Color.BROWN);
                     Font font = Font.loadFont("file:D:\\Cules\\BTL_1\\font\\font.ttf" , 60) ;
                     gc.setFont(font);
                     gc.fillText(winText.getText(),96 * 6, 96 * 4);
                 }
             }
         }
         if (mapType == "dif") {
             for (Enemy enemy : DifEnemy)
                 enemy.setMapType("dif");
             if (StartDefense == "run") {
                 mapDif.drawDifMap(gc);
                 player.draw(gc);
                 DifEnemy.forEach(g -> g.render(gc));
                 towerList2.forEach(g -> g.render(gc));
                 if (enemyPerWave == 0) {
                     Timer.stop();
                     gc.setFill(Color.BROWN);
                     Font font = Font.loadFont("file:D:\\Cules\\BTL_1\\font\\font.ttf" , 60) ;
                     gc.setFont(font);
                     gc.fillText(winText.getText(),96 * 6, 96 * 4);
                 }
             }
         }
     }


    public void update() {
        if (mapType == "ez") {
            if (!endWave1 && createNumber < 5 && System.currentTimeMillis() - LastCreatingTime >= 2000) {
                EzEnemy.add(new SoldierCules(0,8, Direction.UP));
                EzEnemy.add(new Soldier(0,8, Direction.UP));
                //EzEnemy.add(new Tank(0,8, Direction.UP));
                createNumber++;
                LastCreatingTime = System.currentTimeMillis();
            }

            if (endWave1 && createNumber < 5 && System.currentTimeMillis() - LastCreatingTime >= 2000) {
                EzEnemy.add(new SoldierCules(0,8, Direction.UP));
                EzEnemy.add(new Tank(0,8, Direction.UP));
                createNumber++;
                LastCreatingTime = System.currentTimeMillis();
            }

            for (Tower tower : towerList1) {
                tower.attack(EzEnemy);
            }
            towerList1.forEach(Tower::update);
            for (int i = 0; i < EzEnemy.size(); i++) {
                EzEnemy.get(i).update();
                if ((i == EzEnemy.size() - 1 && EzEnemy.get(i).getX() > 1190)) {
                    endWave1 = true;
                    createNumber = 0;
                }
                if (EzEnemy.get(i).getX() > 1190) {
                    EzEnemy.remove(i);
                    player.setLife(player.getLife() - 1);
                } else if (!EzEnemy.get(i).isAlive()) {
                    if (i == EzEnemy.size() - 1) {
                        endWave1 = true;
                        createNumber = 0;
                    }
                    player.setMoney(player.getMoney() + (int) EzEnemy.get(i).getReward());
                    EzEnemy.remove(i);
                    enemyPerWave--;
                    if (enemyPerWave == 0) {
                        resetGame();
                    }
                }
            }
            if (player.getLife() <= 0) System.exit(0);
        }

        if (mapType == "dif") {
            if (!endWave2 && createNumber2 < 5 && System.currentTimeMillis() - LastCreatingTime >= 2000) {
                DifEnemy.add(new SoldierCules(0,6, Direction.RIGHT));
                DifEnemy.add(new Soldier(0,6, Direction.RIGHT));
                //EzEnemy.add(new Tank(0,8, Direction.RIGHT));
                createNumber2++;
                LastCreatingTime = System.currentTimeMillis();
            }

            if (endWave2 && createNumber2 < 5 && System.currentTimeMillis() - LastCreatingTime >= 2000) {
                DifEnemy.add(new SoldierCules(0,6, Direction.RIGHT));
                DifEnemy.add(new Tank(0,8, Direction.UP));
                createNumber2++;
                LastCreatingTime = System.currentTimeMillis();
            }

            for (Tower tower : towerList2) {
                tower.attack(DifEnemy);
            }
            towerList2.forEach(Tower::update);
            for (int i = 0; i < DifEnemy.size(); i++) {
                DifEnemy.get(i).update();
                if ((i == DifEnemy.size() - 1 && DifEnemy.get(i).getX() > 1190)) {
                    endWave2 = true;
                    createNumber2 = 0;
                }
                if (DifEnemy.get(i).getX() > 1190) {
                    DifEnemy.remove(i);
                    player.setLife(player.getLife() - 1);
                } else if (!DifEnemy.get(i).isAlive()) {
                    if (i == DifEnemy.size() - 1) {
                        endWave2 = true;
                        createNumber2 = 0;
                    }
                    player.setMoney(player.getMoney() + (int) DifEnemy.get(i).getReward());
                    DifEnemy.remove(i);
                }
                if (player.getLife() <= 0) System.exit(0);
            }
        }
    }
    public void drawTowerEz() {
        towerList1.add(new BaseTower(2,6,"045",null,null)) ;
        towerList1.add(new BaseTower(2,7,"045",null,null)) ;
        towerList1.add(new BaseTower(2,8,"045",null,null)) ;
        towerList1.add(new BaseTower(2,2,"045",null,null)) ;
        towerList1.add(new BaseTower(2,3,"045",null,null)) ;
        towerList1.add(new BaseTower(5,4,"045",null,null)) ;
        towerList1.add(new BaseTower(5,5,"045",null,null)) ;
        towerList1.add(new BaseTower(8,8,"110",null,null)) ;
        towerList1.add(new BaseTower(8,3,"110",null,null)) ;
        towerList1.add(new BaseTower(8,4,"110",null,null)) ;
        towerList1.add(new BaseTower(8,2,"110",null,null)) ;
    }
    public void drawTowerDif() {
        towerList2.add(new BaseTower(2,4,"045",null,null)) ;
        //towerList.add(new BaseTower(3,4,"045",null,null)) ;
        towerList2.add(new BaseTower(2,8,"045",null,null)) ;
        towerList2.add(new BaseTower(3,8,"045",null,null)) ;
        towerList2.add(new BaseTower(5,8,"045",null,null)) ;
        towerList2.add(new BaseTower(5,1,"045",null,null)) ;
        towerList2.add(new BaseTower(1,4,"045",null,null)) ;
        towerList2.add(new BaseTower(10,3,"110",null,null));
        towerList2.add(new BaseTower(9,3,"110",null,null)) ;
        towerList2.add(new BaseTower(9,4,"110",null,null)) ;
        towerList2.add(new BaseTower(9,5,"110",null,null)) ;
        towerList2.add(new BaseTower(5,3,"045",null,null)) ;
        towerList2.add(new BaseTower(5,4,"045",null,null)) ;
        towerList2.add(new BaseTower(4,4,"045",null,null)) ;
    }
    public void resetGame() {
        EzEnemy.clear();
        towerList1.clear();
        towerList2.clear();
    }

    public void mouseEvent(Stage theStage) {
        theStage.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            for (int i = 0; i < towerList1.size(); i++) {
                Tower towers = towerList1.get(i);
                if ((towers.getX() <= e.getX() && towers.getX() + 96 >= e.getX()) && (towers.getY() <= e.getY() && towers.getY() + 96 > e.getY())) {
                    towers.update();
                    if (0 <= towers.getRank() && towers.getRank() <= 3) {
                        if (towers.getRank() == 0 && player.getMoney() >= 150) {
                            towerList1.set(i, new TowerGun(towers.getI(), towers.getJ()));
                        }
                    /*    else if (towers.getRank() == 1 && player.getMoney() >= 300)
                            towerList.set(i, new TowerDouGun(towers.getI(), towers.getJ()));

                     */
                        else if (towers.getRank() == 1 && player.getMoney() >= 1000)
                            towerList1.set(i, new TowerRocket(towers.getI(), towers.getJ()));
                        else if (towers.getRank() == 3 && player.getMoney() >= 2000)
                            towerList1.set(i, new TowerDouRocket(towers.getI(), towers.getJ()));
                        player.setMoney(player.getMoney() - towerList1.get(i).getPrice());
                    }
                }
            }
            for (int i = 0; i < towerList2.size(); i++) {
                Tower towers = towerList2.get(i);
                if ((towers.getX() <= e.getX() && towers.getX() + 96 >= e.getX()) && (towers.getY() <= e.getY() && towers.getY() + 96 > e.getY())) {
                    towers.update();
                    if (0 <= towers.getRank() && towers.getRank() <= 3) {
                        if (towers.getRank() == 0 && player.getMoney() >= 150) {
                            towerList2.set(i, new TowerGun(towers.getI(), towers.getJ()));
                        }
                    /*    else if (towers.getRank() == 1 && player.getMoney() >= 300)
                            towerList.set(i, new TowerDouGun(towers.getI(), towers.getJ()));

                     */
                        else if (towers.getRank() == 1 && player.getMoney() >= 1000)
                            towerList2.set(i, new TowerRocket(towers.getI(), towers.getJ()));
                        else if (towers.getRank() == 3 && player.getMoney() >= 2000)
                            towerList2.set(i, new TowerDouRocket(towers.getI(), towers.getJ()));
                        player.setMoney(player.getMoney() - towerList2.get(i).getPrice());
                    }
                }
            }
        });
    }

    public void setMapType(String mapType) { this.mapType = mapType;}
    public void setStartDefense(String startDefense) { StartDefense = startDefense; }
    public String getMapType() { return mapType; }
    public String getStartDefense() { return StartDefense; }
}
/*
        for (int i = 0; i < towerList.size(); i++) {
        Tower towers = towerList.get(i);
        if ((towers.getX() <= e.getX() && towers.getX() + 96 >= e.getX()) && (towers.getY() <= e.getY() && towers.getY() + 96 > e.getY())) {
        towers.update();
        if (0 <= towers.getRank() && towers.getRank() <= 3) {
        if (towers.getRank() == 0 && player.getMoney() >= 150) {
        towerList.set(i , new TowerGun(towers.getI(), towers.getJ()));
        }
        else if (towers.getRank() == 1 && player.getMoney() >= 300)
        towerList.set(i, new TowerDouGun(towers.getI(), towers.getJ()));
        else if (towers.getRank() == 2 && player.getMoney() >= 1000)
        towerList.set(i, new TowerRocket(towers.getI(), towers.getJ()));
        else if (towers.getRank() == 3 && player.getMoney() >= 2000)
        towerList.set(i, new TowerDouRocket(towers.getI(), towers.getJ()));
        player.setMoney(player.getMoney() - towerList.get(i).getPrice());
        }
        }
        }

 */

