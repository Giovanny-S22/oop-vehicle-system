import java.util.Scanner;

class Vehiculo{
    private String marca;
    private int velocidadMaxima;
    private int velocidad;

    public Vehiculo(String marca, int velocidadMaxima, int velocidad){
        this.marca = marca;
        this.velocidadMaxima = velocidadMaxima;
        this.velocidad = velocidad;
        
    }

    public String getMarca(){
        return marca;
    }

    public int getVelocidadMaxima(){
        return velocidadMaxima;
    }

    public int getVelocidad(){
        return velocidad;
    }
    public void conducir(){
        System.out.println("El vehiculo de marca "+marca+" esta avanzando");
    }

    public void aumentarVel(int aumento){
        if (velocidad+aumento>velocidadMaxima) {
            System.out.println("Error: la velocidad maxima permitida es "+velocidadMaxima+"km/h");
            System.out.println("Velocidad actual: "+velocidad+"km/h");
        }else{
            velocidad+=aumento;
            System.out.println("Su velocidad ahora es de "+velocidad+" km/h");
        }
    }
}

class Moto extends Vehiculo{
    boolean tieneSidecar;

    public Moto(String marca, int velocidadMaxima, int velocidad, boolean tieneSidecar){
        super(marca, velocidadMaxima, velocidad);
        this.tieneSidecar = tieneSidecar;
    }

    @Override
    public void conducir(){
        if (getVelocidad()<=getVelocidadMaxima()) {
            System.out.println("La moto de marca "+getMarca()+" avanza a "+getVelocidad()+" km/h sobre dos ruedas");
        }else{
            System.out.println("Exceso de velocidad, velocidad maxima permitida de la Moto "+getVelocidadMaxima()+" km/h");
        }
    }
}

class Bus extends Vehiculo{
    int capacidadPasajeros;

    public Bus(String marca, int velocidadMaxima, int velocidad, int capacidadPasajeros){
        super(marca, velocidadMaxima, velocidad);
        this.capacidadPasajeros = capacidadPasajeros;
    }

    @Override
    public void conducir(){
        if (getVelocidad()<=getVelocidadMaxima()) {
            System.out.println("El bus de marca "+getMarca()+" lleva a "+capacidadPasajeros+" personas.");
        }else{
            System.out.println("Exceso de velocidad, velocidad maxima permitida del Bus "+getVelocidadMaxima()+" km/h");
        }
    }
}


public class Vehiculos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Vehiculo m1 = new Moto ("Honda",100,80,true );
        Vehiculo b1 = new Bus("Hyundai", 80, 50, 20);
        

        m1.conducir();
        b1.conducir();

        System.out.println("Desea Aumentar Velocidad:\n 1.Si\n 2.No");
        int decision = sc.nextInt(); 

        if (decision == 1) {
            System.out.println("Ingrese el vehiculo que desea aumentar la velocidad:\n 1.Moto\n 2.Bus");
            int tipo = sc.nextInt();

            if (tipo==1) {
                System.out.println("Ingrese el Aumento para la Moto: ");
                int aumento = sc.nextInt();
                m1.aumentarVel(aumento);
            }else if (tipo==2) {
                System.out.println("Ingrese el Aumento del Bus: ");
                int aumento = sc.nextInt();
                b1.aumentarVel(aumento);
            }else{
                System.out.println("Valor incorrecto, Ingrese otro valor.");

            }
        }

        
    }    
}
