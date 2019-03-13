import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.util.ArrayList;

public class Fichero {

    private File fichero = new File("/home/lordfisto/Documents/Horari.xls");
    private Dia dilluns = new Dia("Dilluns",1);
    private Dia dimarts = new Dia("Dimarts",2);
    private Dia dimecres = new Dia("Dimecres",3);
    private Dia dijous = new Dia("Dijous",4);
    private Dia divendres = new Dia("Divendres",5);
    private Dia dissabte = new Dia("Dissabte",6);
    private Dia diumenge = new Dia("Diumenge",7);

    private ArrayList<Clase> clases = new ArrayList<Clase>();

    private WritableWorkbook writableWorkbook;
    private WritableSheet writableSheet;

    private WritableFont boldFont;
    private WritableCellFormat formatoBold;

    public Fichero() {
        this.crearSemana();

        try {
            this.writableWorkbook = Workbook.createWorkbook(this.fichero);
            this.writableSheet = writableWorkbook.createSheet("Sheet1", 0);
            this.boldFont  = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false);
            this.formatoBold = new WritableCellFormat(boldFont);
            this.formatoBold.setAlignment(Alignment.CENTRE);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR AL CREAR EL WORKBOOK");
        }


    }

    public void crearSemana(){

        try {
            Label dilluns = new Label(this.dilluns.getNum(), 0, this.dilluns.getNom(),this.formatoBold);
            Label dimarts = new Label(this.dimarts.getNum(), 0, this.dimarts.getNom(),this.formatoBold);
            Label dimecres = new Label(this.dimecres.getNum(), 0, this.dimecres.getNom(),this.formatoBold);
            Label dijous = new Label(this.dijous.getNum(), 0, this.dijous.getNom(),this.formatoBold);
            Label divendres = new Label(this.divendres.getNum(), 0, this.divendres.getNom(),this.formatoBold);
            Label dissabte = new Label(this.dissabte.getNum(), 0, this.dissabte.getNom(),this.formatoBold);
            Label diumenge = new Label(this.diumenge.getNum(), 0, this.diumenge.getNom(),this.formatoBold);


            this.writableSheet.addCell(dilluns);
            this.writableSheet.addCell(dimarts);
            this.writableSheet.addCell(dimecres);
            this.writableSheet.addCell(dijous);
            this.writableSheet.addCell(divendres);
            this.writableSheet.addCell(dissabte);
            this.writableSheet.addCell(diumenge);


            writableWorkbook.write();
            writableWorkbook.close();


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR AL ESCRIBIR");
        }

    }

    public void anadirClase(Clase clase){

        this.clases.add(clase);

    }

}
