import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Fichero {

    private File fichero = new File("Horari.xls");
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


        try {
            this.writableWorkbook = Workbook.createWorkbook(this.fichero);
            this.writableSheet = writableWorkbook.createSheet("Sheet1", 0);
            this.boldFont  = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false);
            this.formatoBold = new WritableCellFormat(boldFont);
            this.formatoBold.setAlignment(jxl.format.Alignment.CENTRE);

            this.writableSheet.setColumnView(1,15);
            this.writableSheet.setColumnView(2,15);
            this.writableSheet.setColumnView(3,15);
            this.writableSheet.setColumnView(4,15);
            this.writableSheet.setColumnView(5,15);
            this.writableSheet.setColumnView(6,15);
            this.writableSheet.setColumnView(7,15);


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR AL CREAR EL WORKBOOK");
        }

        this.crearSemana();


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






        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR AL ESCRIBIR");
        }

    }




    public void escribirClases(){

        int y = 1;
        try {
            for (Clase c: this.clases) {



                Label horario = new Label(0, y, c.getHorari(),this.formatoBold);

                Label nombre = new Label(c.getDia().getNum(), y, c.getNom());

                this.writableSheet.addCell(horario);
                this.writableSheet.addCell(nombre);

                y++;
            }
            this.writableWorkbook.write();
            this.writableWorkbook.close();

        }catch (Exception e){
            e.fillInStackTrace();
        }


    }

    public void acabar(){
        this.escribirClases();
    }

    public Clase findClase(String nom,String numdia,String horari,ArrayList<Clase> clases) {
        for(Clase c : clases) {
            if(c.getHorari().equals(horari)) {
                return c;
            }
        }
        return null;
    }



    /**
     * Sets new dimarts.
     *
     * @param dimarts New value of dimarts.
     */
    public void setDimarts(Dia dimarts) {
        this.dimarts = dimarts;
    }

    /**
     * Gets dimarts.
     *
     * @return Value of dimarts.
     */
    public Dia getDimarts() {
        return dimarts;
    }

    /**
     * Gets divendres.
     *
     * @return Value of divendres.
     */
    public Dia getDivendres() {
        return divendres;
    }

    /**
     * Sets new writableWorkbook.
     *
     * @param writableWorkbook New value of writableWorkbook.
     */
    public void setWritableWorkbook(WritableWorkbook writableWorkbook) {
        this.writableWorkbook = writableWorkbook;
    }

    /**
     * Gets boldFont.
     *
     * @return Value of boldFont.
     */
    public WritableFont getBoldFont() {
        return boldFont;
    }

    /**
     * Sets new dimecres.
     *
     * @param dimecres New value of dimecres.
     */
    public void setDimecres(Dia dimecres) {
        this.dimecres = dimecres;
    }

    /**
     * Gets dissabte.
     *
     * @return Value of dissabte.
     */
    public Dia getDissabte() {
        return dissabte;
    }

    /**
     * Gets clases.
     *
     * @return Value of clases.
     */
    public ArrayList<Clase> getClases() {
        return clases;
    }

    /**
     * Sets new dijous.
     *
     * @param dijous New value of dijous.
     */
    public void setDijous(Dia dijous) {
        this.dijous = dijous;
    }

    /**
     * Gets dilluns.
     *
     * @return Value of dilluns.
     */
    public Dia getDilluns() {
        return dilluns;
    }

    /**
     * Sets new formatoBold.
     *
     * @param formatoBold New value of formatoBold.
     */
    public void setFormatoBold(WritableCellFormat formatoBold) {
        this.formatoBold = formatoBold;
    }

    /**
     * Sets new diumenge.
     *
     * @param diumenge New value of diumenge.
     */
    public void setDiumenge(Dia diumenge) {
        this.diumenge = diumenge;
    }

    /**
     * Sets new dilluns.
     *
     * @param dilluns New value of dilluns.
     */
    public void setDilluns(Dia dilluns) {
        this.dilluns = dilluns;
    }

    /**
     * Sets new divendres.
     *
     * @param divendres New value of divendres.
     */
    public void setDivendres(Dia divendres) {
        this.divendres = divendres;
    }

    /**
     * Gets dijous.
     *
     * @return Value of dijous.
     */
    public Dia getDijous() {
        return dijous;
    }

    /**
     * Sets new boldFont.
     *
     * @param boldFont New value of boldFont.
     */
    public void setBoldFont(WritableFont boldFont) {
        this.boldFont = boldFont;
    }

    /**
     * Gets diumenge.
     *
     * @return Value of diumenge.
     */
    public Dia getDiumenge() {
        return diumenge;
    }

    /**
     * Gets formatoBold.
     *
     * @return Value of formatoBold.
     */
    public WritableCellFormat getFormatoBold() {
        return formatoBold;
    }

    /**
     * Sets new clases.
     *
     * @param clases New value of clases.
     */
    public void setClases(ArrayList<Clase> clases) {
        this.clases = clases;
        Collections.sort(this.clases);
    }

    /**
     * Sets new fichero.
     *
     * @param fichero New value of fichero.
     */
    public void setFichero(File fichero) {
        this.fichero = fichero;
    }

    /**
     * Gets dimecres.
     *
     * @return Value of dimecres.
     */
    public Dia getDimecres() {
        return dimecres;
    }

    /**
     * Gets writableSheet.
     *
     * @return Value of writableSheet.
     */
    public WritableSheet getWritableSheet() {
        return writableSheet;
    }

    /**
     * Sets new writableSheet.
     *
     * @param writableSheet New value of writableSheet.
     */
    public void setWritableSheet(WritableSheet writableSheet) {
        this.writableSheet = writableSheet;
    }

    /**
     * Sets new dissabte.
     *
     * @param dissabte New value of dissabte.
     */
    public void setDissabte(Dia dissabte) {
        this.dissabte = dissabte;
    }

    /**
     * Gets writableWorkbook.
     *
     * @return Value of writableWorkbook.
     */
    public WritableWorkbook getWritableWorkbook() {
        return writableWorkbook;
    }

    /**
     * Gets fichero.
     *
     * @return Value of fichero.
     */
    public File getFichero() {
        return fichero;
    }
}
