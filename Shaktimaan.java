import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IronMan here.
 * 
 * @author (Sergio Humberto Aguilar Ochoa) 
 * @version (a version number or a date)
 */
public class Shaktimaan extends Character implements Subject
{
    private GreenfootImage[] arrImages; //Arreglo de imagenes para uso del jugador (Iron Man)
    private int vidas; //Numero de vidas del jugador.
    private int health; // Number of player health.
    private int energia; //tiene que tener la energia el 100% para poder lanzar un rayo.
   // private int escudo; //escudo que sirve como salud extra.
    private int puntos;
    
    private int numShots; //Number of shots that can make the player.
    private ShaktimaanState hasShotState;
    private ShaktimaanState outOfShotState;
    private ShaktimaanState currState = outOfShotState;
    
    
    //private GreenfootSound rayoSound;
    private GreenfootSound explosionSound;
    private GreenfootSound disparoSound;
    
    private PointsObserver obs;
    
    //protected SimpleTimer rayoTimer;
    /**
     * Shaktimaan builder class. Shaktimaan images are loaded, variable life, health, and points are initialized. Attacks sounds are loaded.
     */
    public Shaktimaan()
    {
        arrImages = new GreenfootImage [3];
        arrImages[0] = new GreenfootImage("IronMan.png");
        arrImages[1] = new GreenfootImage("IronManArriba.png");
        arrImages[2] = new GreenfootImage("IronManAbajo.png");
        vidas = 3;
        health = 50;
        this.setImage(arrImages[0]);
        numShots = 5;
        //energia = 100;
        puntos=0;
        
        //rayoSound = new GreenfootSound("rayo.wav");
        explosionSound = new GreenfootSound("explosionNave.wav");
        disparoSound = new GreenfootSound("disparoJugador.wav");
       
        //escudo = 0;
        
        hasShotState = new HasShotState(this,shotTimer);
        outOfShotState = new OutOfShotState(this);
        if(numShots > 0){
            this.currState = hasShotState;
        }
        
        //rayoTimer = new SimpleTimer();
        //rayoTimer.mark();
    }
    
    /**
     * Act - do whatever the IronMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.mover();
        this.atacar();
        this.tocoEnemigo();
        //this.recuperaEnergia();
        this.generaBonus();
        //this.energiaToDisparos();
    }    
    
    /**
     * Metodo para los movimientos del jugador.
     */
    public void mover()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            this.setImage(arrImages[0]);
            if(this.getX()+this.getImage().getWidth()/2 < getWorld().getWidth())
                this.setLocation(this.getX() + 5,this.getY());
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            this.setImage(arrImages[0]);
            if(this.getX()-this.getImage().getWidth()/2 > 0)
                this.setLocation(this.getX() - 5, this.getY());
        }
        else if(Greenfoot.isKeyDown("up"))
        {
            this.setImage(arrImages[1]);
            if(this.getY()-this.getImage().getHeight()/2 > 0)
                this.setLocation(this.getX(), this.getY() - 5);
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            this.setImage(arrImages[2]);
            if(this.getY()+this.getImage().getHeight()/2 < getWorld().getHeight())
                this.setLocation(this.getX(), this.getY() + 5);
        }
    }
    
    /**
     * When the player presses the spacebar, "Shaktimaan" will launch a shot. 
     * Each shot has a delay of 250 milliseconds.
     * When you press the letter z launches three rays.
     */
    public void atacar()
    {
        /*if(shotTimer.millisElapsed() > 250 && numShots > 0)
        {
            if(Greenfoot.isKeyDown("space"))
            { 
                disparoSound.setVolume(80);
                disparoSound.play();
                getWorld().addObject(new DisparoJugador(), this.getX()+getImage().getWidth()/2, this.getY());
                numShots--;
                shotTimer.mark();
            }
        }*/
        
        if(shotTimer.millisElapsed() > 250){
            if(Greenfoot.isKeyDown("space")){
                currState.attackEnemy();
            }
        }
        /*if(energia == 100)
        {    
            if(Greenfoot.isKeyDown("z"))
            {   
                rayoSound.play();
                getWorld().addObject(new Rayo(), 0-getImage().getWidth()*3, this.getY()-50);
                getWorld().addObject(new Rayo(), 0-getImage().getWidth()*2, this.getY());
                getWorld().addObject(new Rayo(), 0-getImage().getWidth()*4, this.getY()+50);
                energia = 0;
                rayoTimer.mark();
            }
        }*/
    }
    
    /**
     * Subtraction method 's' Player health.
     * And if health reaches 0 you subtract one life and restores 50 health.
     */
    public void reduceHealth(int s)
    {
        // Commented code for removing shield
        /*if(escudo == 0)
            health-=s;
        else if(escudo>0)
        {
            escudo-=s;
            if(escudo<0)
            {
                health+=escudo;
                escudo=0;
            }
        }*/
        if(health > 0){
            health-=s; 
        }
        else if(health <= 0)
        {
            vidas--;
            health = 50;
            if(vidas==0)
                health=0;
        }
    }
    
    /**
     * Check if I touch an enemy and destroys it.
     */
    public void tocoEnemigo()
    {
        Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
        Kazaki g = (Kazaki)getOneIntersectingObject(Kazaki.class);
        if(e!=null)
        {
            Scenario es = (Scenario)getWorld();
            es.reduceEnemies();
            explosionSound.play();
            getWorld().addObject(new Explosion(1), e.getX(), e.getY());
            getWorld().removeObject(e);
            this.reduceHealth(5);
        }
        else if(g!=null)
        {
            if(g.getHealth() > 0)
            {
                this.reduceHealth(1);
                getWorld().addObject(new Explosion(3), getX()+getImage().getWidth()/2, getY());
            }
        }
    }
    
    /**
     * Regresa las vidas del jugador.
     */
    public int getVidas()
    {
        return vidas;
    }
    
    /**
     * Regresa la salud del jugador.
     */
    public int getSalud()
    {
        return health;
    }
    
    /**
     * Returns the number of shots the player.
     */
    public int getNumShots()
    {
        return numShots;
    }
    
    /**
     * Regresa la energia del jugador.
     */
   /* public int getEnergia()
    {
        return energia;
    }*/
    
    /**
     * Regresa el escudo del jugador.
     */
    /*public int getEscudo()
    {
        return escudo;
    }*/
    
    /**
     * Regresa los puntos.
     */
    public int getPuntos()
    {
        return puntos;
    }
    
    /**
     * When the player spends energy makes this method recovers slowly
     */
    /*public void recuperaEnergia()
    {
        if(energia < 100)
        {
            if(rayoTimer.millisElapsed() > 1000*energia)
                energia++;
        }
    }*/
    
    /**
     * Asigna una cantidad de energía.
     */
    public void setEnergia(int en)
    {
        energia = en;
        if(energia > 100)
            energia = 100;
    }
    
    /**
     * Assigns a number of shots
     */
    public void setNumShots(int d)
    {
        //numShots += d;
        numShots = d;
    }
    
    /**
     * Asigna 90 disparos.
     */
    public void setDisparos()
    {
        numShots = 100;
    }
    
    /**
     * Asigna el valor al escudo.
     */
    /*public void setEscudo()
    {
        escudo=20;
    }*/
    
    /**
     * Asigna un valor a la salud.
     */
    public void setSalud(int s)
    {
        health = s;
    }
    
    public void attach(PointsObserver points){
         Scenario scenario = (Scenario) getWorld();
         obs = scenario.getGamePoints();
    }
    
    /**
     * Assign a value to the points..
     */
    public void setPoints(int p)
    {
        puntos += p;
        notifyObservers();
    }
    
    public void notifyObservers(){
       
        obs.updatePoints(puntos); 
    }
    
    /**
     * Increase Life
     */
    public void increaseLife()
    {
        vidas++;
    }
    
    /**
     * Randomly generated bonus throughout the game.
     */
    public void generaBonus()
    {
        if(numShots < 15)
        {
            if(Greenfoot.getRandomNumber(5000) < 20)
            {
                getWorld().addObject( new BonusShot(),
                Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
            }
        }
        /*if(energia < 100)
        {
            if((Greenfoot.getRandomNumber(20000) < 3))
            {
                getWorld().addObject( new BonusRayo(), 
                Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
            }
        }*/
        if(Greenfoot.getRandomNumber(18000) < 5 && vidas<5)
        {
            getWorld().addObject( new BonusLife(), 
            Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
        }
        /*if(Greenfoot.getRandomNumber(18000) < 10 && escudo==0)
        {
            getWorld().addObject( new BonusEscudo(), 
            Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
        }*/
    }
    
    /**
     * Turn every 5 units of energy in an energy shot is set to 0.
     */
    /*public void energiaToDisparos()
    {
        if(Greenfoot.isKeyDown("x") && energia > 4)
        {
            numShots += (energia/5);
            energia = 0;
            rayoTimer.mark();
        }
    }*/
    
    public void setCurrState(ShaktimaanState state) {
        this.currState = state;
    }
    
    public ShaktimaanState getOutOfShotState(){
        return this.outOfShotState;
    }
    
    public ShaktimaanState getHasShotState(){
        return this.hasShotState;
    }
}
