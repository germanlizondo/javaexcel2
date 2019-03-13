import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Clase> clases = new ArrayList<Clase>();

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit){
            try{
                System.out.println("Escriu el input separat per ,");

                String input = scanner.next();

                String[] splited = input.split(",");

                String accio = splited[0];

                Fichero fichero = new Fichero();

                Dia dia;

                String numdia = splited[1];
                String hora = splited[2];

                switch (Integer.parseInt(numdia)){
                    case 0: dia = fichero.getDilluns(); break;
                    case 1: dia = fichero.getDimarts();break;
                    case 2: dia = fichero.getDimecres();break;
                    case 3: dia = fichero.getDijous();break;
                    case 4: dia = fichero.getDivendres();break;
                    case 5: dia = fichero.getDissabte();break;
                    case 6: dia = fichero.getDiumenge();break;
                    default: dia = fichero.getDilluns();break;
                }


                if(accio.equals("add")){
                    String nom  =splited[3];


                    Clase clase = new Clase(hora,dia,nom);

                    clases.add(clase);
                    fichero.setClases(clases);

                }else if(accio.equals("del")){
                    System.out.println(fichero.findClase(numdia,hora,clases).toString());
                    clases.remove(fichero.findClase(numdia,hora,clases));
                    fichero.setClases(clases);
                }


                fichero.acabar();

                System.out.println("Has acabat? (y,n)");

                String res = scanner.next();
                if(res.equals("y")) exit = true;



            }catch (Exception e){
                e.fillInStackTrace();
            }

        }




    }




}
