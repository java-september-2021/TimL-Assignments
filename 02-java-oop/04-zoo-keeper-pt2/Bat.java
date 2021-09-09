public class Bat extends Mammal{

    public Bat(int energyLevel){
        super(energyLevel);
    }

    public void fly(){
        System.out.println("zoom-zoom.");
        this.energyLevel -= 50;
    }
    
    public void eatHumans(){
        System.out.println("so- well, never mind.");
        this.energyLevel += 25;
    }

    public void attackTown(){
        System.out.println("boom-boom.");
        this.energyLevel -= 100;
    }
    
}
